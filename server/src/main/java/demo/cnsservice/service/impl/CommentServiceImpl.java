package demo.cnsservice.service.impl;

import demo.cnsservice.dto.CommentDto;
import demo.cnsservice.entity.Booking;
import demo.cnsservice.entity.Comment;
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
    public CommentDto createComment(long bookingId, CommentDto commentDto) {


        /*
           Comment comment = mapToEntity(commentDto);

        // retrieve post entity by id
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", postId));

        // set post to comment entity
        comment.setPost(post);

        // comment entity to DB
        Comment newComment =  commentRepository.save(comment);

        return mapToDTO(newComment);
         */
    }
}
