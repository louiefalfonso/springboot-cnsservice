package demo.cnsservice.service;

import demo.cnsservice.dto.CommentDto;

public interface CommentService {

    CommentDto createComment(long bookingI, CommentDto commentDto);

}
