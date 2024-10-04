package demo.cnsservice.service;

import demo.cnsservice.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategories();

    /*

    CustomerDto getCustomerById (Long customerId);

    CustomerDto updateCustomer(Long customerId, CustomerDto updateCustomer);

    void deleteCustomer(Long customerId);
     */
}
