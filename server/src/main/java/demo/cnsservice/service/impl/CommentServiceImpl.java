package demo.cnsservice.service.impl;

import demo.cnsservice.dto.CommentDto;
import demo.cnsservice.entity.Booking;
import demo.cnsservice.entity.Comment;
import demo.cnsservice.exception.BookingAPIException;
import demo.cnsservice.repository.BookingRepository;
import demo.cnsservice.repository.CommentRepository;
import demo.cnsservice.service.CommentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private BookingRepository bookingRepository;
    private ModelMapper modelMapper;

    // REST API - Create New Comment
    @Override
    public CommentDto createComment(long bookingId, CommentDto commentDto) {

        Comment comment = modelMapper.map(commentDto, Comment.class);
        Booking booking = bookingRepository.findById(bookingId).orElseThrow();
        comment.setBooking(booking);

        Comment savedComment = commentRepository.save(comment);
        return  modelMapper.map(savedComment, CommentDto.class);

    }

    // REST API - Get Comments By Booking Id
    @Override
    public List<CommentDto> getCommentsByBookingId(long bookingId) {
        List<Comment> comments = commentRepository.findByBookingId(bookingId);
        return comments.stream().map((comment)-> modelMapper.map(comment, CommentDto.class))
                .collect(Collectors.toList());
    }


    // REST API - Get Comments By Id
    @Override
    public CommentDto getCommentById(long bookingId, long commentId) {

        Booking booking = bookingRepository.findById(bookingId).orElseThrow();
        Comment comment = commentRepository.findById(commentId).orElseThrow();

        if (!comment.getBooking().getId().equals(booking.getId())) {
            throw new BookingAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to this Booking");
        }
        return modelMapper.map(comment, CommentDto.class);
    }


    // REST API - Delete Comment
    @Override
    public void deleteComment(long bookingId, long commentId) {

        Booking booking = bookingRepository.findById(bookingId).orElseThrow();
        Comment comment = commentRepository.findById(commentId).orElseThrow();

        if(!comment.getBooking().getId().equals(booking.getId())){
            throw new BookingAPIException(HttpStatus.BAD_REQUEST,"Comment does not belongs to this Booking");
        }
        commentRepository.deleteById(commentId);

    }

    // REST API - Update Comment
    @Override
    public CommentDto updateComment(Long bookingId, Long commentId, CommentDto commentRequest) {

        Booking booking = bookingRepository.findById(bookingId).orElseThrow();
        Comment comment = commentRepository.findById(commentId).orElseThrow();

        if(!comment.getBooking().getId().equals(booking.getId())){
            throw new BookingAPIException(HttpStatus.BAD_REQUEST,"Comment does not belongs this Booking");
        }

        comment.setName(commentRequest.getName());
        comment.setEmail(commentRequest.getEmail());
        comment.setBody(commentRequest.getBody());

        Comment updateCommentObj = commentRepository.save(comment);
        return  modelMapper.map(updateCommentObj, CommentDto.class);
    }

}
