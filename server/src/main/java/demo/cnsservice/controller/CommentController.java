package demo.cnsservice.controller;


import demo.cnsservice.dto.CommentDto;
import demo.cnsservice.repository.CommentRepository;
import demo.cnsservice.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;
    private CommentService commentService;

    //POST New Comment REST API
    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto){
        CommentDto savedComment = commentService.createComment(commentDto);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

}
