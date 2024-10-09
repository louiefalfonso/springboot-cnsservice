package demo.cnsservice.repository;

import demo.cnsservice.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByCategoryId(Long categoryId);

    Optional<Booking> findAllById(Long BookingId);

}
