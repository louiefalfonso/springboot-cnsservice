package demo.cnsservice.controller;

import demo.cnsservice.dto.BookingDto;
import demo.cnsservice.repository.BookingRepository;
import demo.cnsservice.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;
    private BookingService bookingService;


    //POST New Booking REST API
    @PostMapping
    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto){
        BookingDto savedBooking = bookingService.createBooking(bookingDto);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }

    //GET All Bookings REST API
    @GetMapping
    public ResponseEntity<List<BookingDto>> getAllBookings(){
        List<BookingDto> booking = bookingService.getAllBookings();
        return ResponseEntity.ok(booking);
    }

}
