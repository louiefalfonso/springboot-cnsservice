package springboot_cnsservice.cnsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot_cnsservice.cnsservice.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
