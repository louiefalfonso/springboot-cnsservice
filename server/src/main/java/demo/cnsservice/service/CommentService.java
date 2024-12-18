package demo.cnsservice.service;

import demo.cnsservice.dto.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createComment(long bookingId, CommentDto commentDto);

    List<CommentDto> getCommentsByBookingId (long bookingId);

    CommentDto getCommentById(long bookingId, long commentId);

    void deleteComment(long bookingId, long commentId);

    CommentDto updateComment(Long bookingId, Long commentId, CommentDto commentRequest);

}
