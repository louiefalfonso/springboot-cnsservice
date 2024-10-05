package demo.cnsservice.service.impl;

import demo.cnsservice.dto.CommentDto;
import demo.cnsservice.repository.BookingRepository;
import demo.cnsservice.repository.CommentRepository;
import demo.cnsservice.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private BookingRepository bookingRepository;
    private ModelMapper modelMapper;

    public  CommentServiceImpl(CommentRepository commentRepository, BookingRepository bookingRepository, ModelMapper modelMapper){
        this.commentRepository = commentRepository;
        this.bookingRepository = bookingRepository;
        this.modelMapper = modelMapper;

    }


    @Override
    public CommentDto createComment(long bookingI, CommentDto commentDto) {
        return null;
    }
}
