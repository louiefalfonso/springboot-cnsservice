package demo.cnsservice.service;

import demo.cnsservice.dto.BookingDto;

public interface BookingService {

    BookingDto createBooking(BookingDto bookingDto);

    /*

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);

    List<PostDto> getPostsByCategory(Long categoryId);
     */
}
