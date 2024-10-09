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
        return null;
    }
}
