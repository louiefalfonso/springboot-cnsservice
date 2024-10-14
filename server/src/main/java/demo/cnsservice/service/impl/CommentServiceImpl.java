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


}
