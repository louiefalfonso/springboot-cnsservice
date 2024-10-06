package demo.cnsservice.service.impl;

import demo.cnsservice.dto.BookingDto;
import demo.cnsservice.entity.Category;
import demo.cnsservice.exception.ResourceNotFoundException;
import demo.cnsservice.repository.BookingRepository;
import demo.cnsservice.repository.CategoryRepository;
import demo.cnsservice.service.BookingService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;
    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              ModelMapper modelMapper,
                              CategoryRepository categoryRepository){
        this.bookingRepository = bookingRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public BookingDto createBooking(BookingDto bookingDto) {

        Category category = categoryRepository.findById(bookingDto.getCategoryId())
                .orElseThrow(()-> new ResourceNotFoundException("Category", "id", bookingDto.getCategoryId()));


    }

    /*
     @Override
    public PostDto createPost(PostDto postDto) {

        Category category = categoryRepository.findById(postDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", postDto.getCategoryId()));

        // convert DTO to entity
        Post post = mapToEntity(postDto);
        post.setCategory(category);
        Post newPost = postRepository.save(post);

        // convert entity to DTO
        PostDto postResponse = mapToDTO(newPost);
        return postResponse;
    }
     */
}
