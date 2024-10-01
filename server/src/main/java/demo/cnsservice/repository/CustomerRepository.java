package demo.cnsservice.repository;

import demo.cnsservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findAllById (Long CustomerId);
}
