package demo.cnsservice.controller;


import demo.cnsservice.dto.CategoryDto;
import demo.cnsservice.repository.CategoryRepository;
import demo.cnsservice.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {


    @Autowired
    private CategoryRepository categoryRepository;
    private CategoryService categoryService;

    //POST New Category REST API
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto savedCategory = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }



}
