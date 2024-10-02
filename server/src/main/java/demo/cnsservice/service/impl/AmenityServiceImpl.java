package demo.cnsservice.service.impl;

import demo.cnsservice.dto.AmenityDto;
import demo.cnsservice.entity.Amenity;
import demo.cnsservice.repository.AmenityRepository;
import demo.cnsservice.service.AmenityService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AmenityServiceImpl implements AmenityService {

    private AmenityRepository amenityRepository;
    private ModelMapper modelMapper;


    // REST API - Create New Amenity
    @Override
    public AmenityDto createAmenity(AmenityDto amenityDto) {
        Amenity amenity = modelMapper.map(amenityDto, Amenity.class);
        Amenity savedAmenity = amenityRepository.save(amenity);
        return modelMapper.map(savedAmenity, AmenityDto.class);
    }

    // REST API - Get All Amenities
    @Override
    public List<AmenityDto> getAllAmenities() {
        List<Amenity> amenities = amenityRepository.findAll();
        return  amenities.stream().map((amenity) -> modelMapper.map(amenity, AmenityDto.class))
                .collect(Collectors.toList());
    }

    // REST API - Get Amenity By Id
    @Override
    public AmenityDto getAmenityById(Long amenityId) {
        Amenity amenity = amenityRepository.findAllById(amenityId)
                .orElseThrow(()-> new RuntimeException("Amenity doesn't exist with a given Id:" + amenityId));
        return  modelMapper.map(amenity, AmenityDto.class);
    }

}
