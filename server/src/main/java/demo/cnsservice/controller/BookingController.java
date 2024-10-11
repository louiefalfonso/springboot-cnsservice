package demo.cnsservice.controller;

import demo.cnsservice.dto.BookingDto;
import demo.cnsservice.entity.Booking;
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

    //GET Booking By ID REST API
    @GetMapping("{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable("id") long id){
        Booking booking = bookingRepository.findAllById(id)
                .orElseThrow(()-> new RuntimeException("Booking does not exist with Id:" + id));
        return ResponseEntity.ok(booking);
    }


    //UPDATE Booking REST API
    @PutMapping ("{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable("id") long id,
                                                 @RequestBody Booking bookingDetails){
        Booking updateBooking = bookingRepository.findAllById(id)
                .orElseThrow(()->new RuntimeException("Booking does not exist with id: " + id));

        updateBooking.setBookingName(bookingDetails.getBookingName());
        updateBooking.setBookingDate(bookingDetails.getBookingDate());
        updateBooking.setPrice(bookingDetails.getPrice());
        updateBooking.setStatus(bookingDetails.getStatus());
        updateBooking.setDescription(bookingDetails.getDescription());
        updateBooking.setCategory(bookingDetails.getCategory());

        bookingRepository.save(updateBooking);
        return ResponseEntity.ok(updateBooking);
    }

    //DELETE Booking REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable("id") Long bookingId){
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.ok("Booking Deleted Successfully");
    }

}
