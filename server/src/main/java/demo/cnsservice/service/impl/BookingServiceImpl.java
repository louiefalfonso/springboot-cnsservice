package demo.cnsservice.service.impl;

import demo.cnsservice.dto.BookingDto;
import demo.cnsservice.entity.Booking;
import demo.cnsservice.repository.BookingRepository;
import demo.cnsservice.repository.CategoryRepository;
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
    private CategoryRepository categoryRepository;
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

    // REST API - Get Booking By Id
    @Override
    public BookingDto getBookingById(Long bookingId) {
        Booking booking = bookingRepository.findAllById(bookingId)
                .orElseThrow(()-> new RuntimeException("Booking doesn't exist with a given Id:" + bookingId));
        return modelMapper.map(booking, BookingDto.class);
    }


    // REST API - Update Booking
    @Override
    public BookingDto updateBooking(Long bookingId, BookingDto updateBooking) {
        Booking booking = bookingRepository.findAllById(bookingId)
                .orElseThrow(()-> new RuntimeException("Booking doesn't exist with a given Id:" + bookingId));

        booking.setBookingName(updateBooking.getBookingName());
        booking.setBookingDate(updateBooking.getBookingDate());
        booking.setPrice(updateBooking.getPrice());
        booking.setStatus(updateBooking.getStatus());
        booking.setDescription(updateBooking.getDescription());
        booking.setCategory(modelMapper.map(updateBooking.getCategoryId(), Booking.class).getCategory());

        Booking updateBookingObj = bookingRepository.save(booking);
        return modelMapper.map(updateBookingObj, BookingDto.class);
    }


}
