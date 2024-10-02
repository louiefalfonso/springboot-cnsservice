package demo.cnsservice.service;

import demo.cnsservice.dto.AmenityDto;

import java.util.List;

public interface AmenityService {

    AmenityDto createAmenity(AmenityDto amenityDto);

    List<AmenityDto> getAllAmenities();

    AmenityDto getAmenityById(Long amenityId);

    /*


    CustomerDto updateCustomer(Long customerId, CustomerDto updateCustomer);

    void deleteCustomer(Long customerId)
     */
}
