package demo.cnsservice.repository;

import demo.cnsservice.entity.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AmenityRepository extends JpaRepository<Amenity, Long> {

    Optional <Amenity> findAllById(Long AmenityId);

}
