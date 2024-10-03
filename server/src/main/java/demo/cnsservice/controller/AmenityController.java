package demo.cnsservice.controller;

import demo.cnsservice.dto.AmenityDto;
import demo.cnsservice.entity.Amenity;
import demo.cnsservice.repository.AmenityRepository;
import demo.cnsservice.service.AmenityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/amenities")
public class AmenityController {

    @Autowired
    private AmenityRepository amenityRepository;
    private AmenityService amenityService;


    //POST New Amenity REST API
    @PostMapping
    public ResponseEntity<AmenityDto> createAmenity(@RequestBody AmenityDto amenityDto){
        AmenityDto savedAmenity = amenityService.createAmenity(amenityDto);
        return  new ResponseEntity<>(savedAmenity, HttpStatus.CREATED);
    }

    //GET All Amenities REST API
    @GetMapping
    public ResponseEntity<List<AmenityDto>> getAllAmenities(){
        List<AmenityDto> amenity = amenityService.getAllAmenities();
        return ResponseEntity.ok(amenity);
    }


    //GET Amenity By ID REST API
    @GetMapping("{id}")
    public ResponseEntity<Amenity> getAmenityById(@PathVariable("id") long id){
        Amenity amenity = amenityRepository.findAllById(id)
                .orElseThrow(()-> new RuntimeException("Amenity does not exist with Id:" + id));
        return ResponseEntity.ok(amenity);
    }

    //UPDATE Amenity REST API
    @PutMapping("{id}")
    public ResponseEntity<Amenity> updateAmenity(@PathVariable("id") long id,
                                                  @RequestBody Amenity amenityDetails){
        Amenity updateAmenity = amenityRepository.findAllById(id)
                .orElseThrow(()-> new RuntimeException("Amenity does not exist with id: " + id));

        updateAmenity.setAmenityName(amenityDetails.getAmenityName());
        updateAmenity.setAmenityPrice(amenityDetails.getAmenityPrice());
        updateAmenity.setDescription(amenityDetails.getDescription());
        updateAmenity.setStatus(amenityDetails.getStatus());

        amenityRepository.save(updateAmenity);
        return ResponseEntity.ok(updateAmenity);
    }

    //DELETE Amenity REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAmenity(@PathVariable("id") Long amenityId){
        amenityService.deleteAmenity(amenityId);
        return ResponseEntity.ok("Amenity Deleted Successfully");
    }

}
