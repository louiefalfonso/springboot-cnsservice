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

    @Override
    public CommentDto createComment(CommentDto commentDto) {
        return null;
    }
}
