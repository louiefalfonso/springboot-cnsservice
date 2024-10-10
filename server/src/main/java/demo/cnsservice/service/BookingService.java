package demo.cnsservice.service;

import demo.cnsservice.dto.BookingDto;

import java.util.List;

public interface BookingService {

    BookingDto createBooking(BookingDto bookingDto);

    List<BookingDto> getAllBookings();

    BookingDto getBookingById (Long bookingId);

    BookingDto updateBooking(Long bookingId, BookingDto updateBooking);


}
