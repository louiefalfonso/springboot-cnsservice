package demo.cnsservice.controller;

import demo.cnsservice.dto.CommentDto;
import demo.cnsservice.repository.CommentRepository;
import demo.cnsservice.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;
    private CommentService commentService;

    //POST New Comment REST API
    @PostMapping("/bookings/{bookingId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "bookingId")long bookingId,
                                                    @RequestBody CommentDto commentDto){
        CommentDto savedComment = commentService.createComment(bookingId,commentDto);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    //GET All Comments By Booking Id REST API
    @GetMapping("/bookings/{bookingId}/comments")
    public List<CommentDto> getCommentsByBookingId(@PathVariable(value = "bookingId") Long bookingId){
        return commentService.getCommentsByBookingId(bookingId);
    }

    //GET Comment By Id REST API
    @GetMapping("/bookings/{bookingId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "bookingId") Long bookingId,
                                                     @PathVariable(value = "id") Long commentId){
        CommentDto commentDto = commentService.getCommentById(bookingId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    //UPDATE Comment REST API
    @PutMapping("/bookings/{bookingId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable(value = "bookingId") Long bookingId,
                                                    @PathVariable(value = "id") Long commentId,
                                                    @RequestBody CommentDto commentDto){
        CommentDto updateComment = commentService.updateComment(bookingId, commentId, commentDto);
        return new ResponseEntity<>(updateComment, HttpStatus.OK);

    }

    //DELETE Comment REST API
    @DeleteMapping("/bookings/{bookingId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "bookingId") Long bookingId,
                                                @PathVariable(value = "id") Long commentId){
        commentService.deleteComment(bookingId, commentId);
        return new ResponseEntity<>("Comment Deleted successfully", HttpStatus.OK);
    }
}
