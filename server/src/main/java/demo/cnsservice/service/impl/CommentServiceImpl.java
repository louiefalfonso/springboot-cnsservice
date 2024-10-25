package demo.cnsservice.service.impl;

import demo.cnsservice.dto.CommentDto;
import demo.cnsservice.entity.Booking;
import demo.cnsservice.entity.Comment;
import demo.cnsservice.exception.ResourceNotFoundException;
import demo.cnsservice.repository.BookingRepository;
import demo.cnsservice.repository.CommentRepository;
import demo.cnsservice.service.CommentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(()->new ResourceNotFoundException("Booking", "id", bookingId));

        comment.setComment(comment);
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


    // REST API - Get Comment By Id
    @Override
    public CommentDto getCommentById(long bookingId, long commentId) {

        Booking booking = bookingRepository.findAllById(bookingId)
                .orElseThrow(()-> new ResourceNotFoundException("Booking", "id", bookingId));

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(()-> new ResourceNotFoundException("Comment", "id", commentId));

        return modelMapper.map(comment, CommentDto.class);
    }

}
