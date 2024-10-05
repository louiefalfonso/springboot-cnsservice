package demo.cnsservice.service.impl;

import demo.cnsservice.dto.CategoryDto;
import demo.cnsservice.entity.Category;
import demo.cnsservice.repository.CategoryRepository;
import demo.cnsservice.service.CategoryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    // REST API - Create New Category
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        Category savedCategory = categoryRepository.save(category);
        return  modelMapper.map(savedCategory, CategoryDto.class);
    }

    // REST API - Get All Categories
    @Override
    public List<CategoryDto> getAllCategories() {
        List <Category> categories = categoryRepository.findAll();
        return  categories.stream().map((category)-> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    // REST API - Get Category By Id
    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        Category category = categoryRepository.findAllById(categoryId)
                .orElseThrow(()-> new RuntimeException("Category doesn't exist with a given Id:" + categoryId));
        return modelMapper.map(category, CategoryDto.class);
    }

    // REST API - Update Category
    @Override
    public CategoryDto updateCategory(Long categoryId, CategoryDto updateCategory) {
        Category category = categoryRepository.findAllById(categoryId)
                .orElseThrow(()-> new RuntimeException("Category doesn't exist with a given Id:" + categoryId));

        category.setName(updateCategory.getName());
        category.setDescription(updateCategory.getDescription());

        Category updateCategoryObj = categoryRepository.save(category);
        return modelMapper.map(updateCategoryObj, CategoryDto.class);
    }

    // REST API - Delete Category
    @Override
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepository.findAllById(categoryId)
                .orElseThrow(()-> new RuntimeException("Category doesn't exist with given id:" + categoryId));
        categoryRepository.deleteById(categoryId);

    }

}
