package demo.cnsservice.service;

import demo.cnsservice.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customerDto);

    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById (Long customerId);

    CustomerDto updateCustomer(Long customerId, CustomerDto updateCustomer);

    void deleteCustomer(Long customerId);

}
