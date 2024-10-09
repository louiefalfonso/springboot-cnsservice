package demo.cnsservice.service.impl;

import demo.cnsservice.dto.BookingDto;
import demo.cnsservice.entity.Booking;
import demo.cnsservice.repository.BookingRepository;
import demo.cnsservice.service.BookingService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;
    private ModelMapper modelMapper;

    // REST API - Create New Booking
    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        Booking booking = modelMapper.map(bookingDto, Booking.class);
        Booking savedBooking = bookingRepository.save(booking);
        return modelMapper.map(savedBooking, BookingDto.class);
    }

    // REST API - Get All Bookings
    @Override
    public List<BookingDto> getAllBookings() {
       List <Booking> bookings = bookingRepository.findAll();
       return bookings.stream().map((booking)-> modelMapper.map(booking, BookingDto.class))
               .collect(Collectors.toList());
    }

}
