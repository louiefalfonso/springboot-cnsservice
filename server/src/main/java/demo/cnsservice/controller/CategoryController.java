package demo.cnsservice.controller;


import demo.cnsservice.dto.CategoryDto;
import demo.cnsservice.entity.Category;
import demo.cnsservice.repository.CategoryRepository;
import demo.cnsservice.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //GET All Categories REST API
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> category = categoryService.getAllCategories();
        return ResponseEntity.ok(category);
    }

    //GET Category By ID REST API
    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id")  long id){
        Category category = categoryRepository.findAllById(id)
                .orElseThrow(()->new RuntimeException("Category does not exist with Id:" + id));
        return ResponseEntity.ok(category);
    }

}
