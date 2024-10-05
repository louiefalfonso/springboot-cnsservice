package demo.cnsservice.service;

import demo.cnsservice.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategories();

    CategoryDto getCategoryById(Long categoryId);

    CategoryDto updateCategory(Long categoryId, CategoryDto updateCategory);

    void deleteCategory(Long categoryId);
}
