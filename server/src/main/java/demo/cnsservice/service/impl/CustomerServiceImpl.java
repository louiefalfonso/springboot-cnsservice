package demo.cnsservice.service.impl;

import demo.cnsservice.dto.CustomerDto;
import demo.cnsservice.entity.Customer;
import demo.cnsservice.repository.CustomerRepository;
import demo.cnsservice.service.CustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;


    // REST API - Create New Customer
    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        Customer savedCustomer = customerRepository.save(customer);
        return modelMapper.map(savedCustomer, CustomerDto.class);
    }
}
