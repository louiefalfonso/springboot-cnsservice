package demo.cnsservice.repository;

import demo.cnsservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findAllById(Long CategoryId);


}


