package demo.cnsservice.service;

import demo.cnsservice.dto.AmenityDto;

import java.util.List;

public interface AmenityService {

    AmenityDto createAmenity(AmenityDto amenityDto);

    List<AmenityDto> getAllAmenities();

    AmenityDto getAmenityById(Long amenityId);

    AmenityDto updateAmenity(Long amenityId, AmenityDto updateAmenity);

    void deleteAmenity(Long amenityId);

}
