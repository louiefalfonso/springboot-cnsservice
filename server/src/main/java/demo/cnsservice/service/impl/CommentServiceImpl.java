package demo.cnsservice.service.impl;

import demo.cnsservice.dto.CommentDto;
import demo.cnsservice.entity.Booking;
import demo.cnsservice.entity.Comment;
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
    private ModelMapper modelMapper;

    // REST API - Create New Comment
    @Override
    public CommentDto createComment(CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        Comment savedComment = commentRepository.save(comment);
        return  modelMapper.map(savedComment, CommentDto.class);
    }

}
