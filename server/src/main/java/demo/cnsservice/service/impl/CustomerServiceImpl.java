package demo.cnsservice.service.impl;

import demo.cnsservice.dto.CustomerDto;
import demo.cnsservice.entity.Customer;
import demo.cnsservice.repository.CustomerRepository;
import demo.cnsservice.service.CustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    // REST API - Get All Customers
    @Override
    public List<CustomerDto> getAllCustomers() {
        List <Customer> customers = customerRepository.findAll();
        return customers.stream().map((customer)-> modelMapper.map(customer, CustomerDto.class))
                .collect(Collectors.toList());
    }

    // REST API - Get Customer By Id
    @Override
    public CustomerDto getCustomerById(Long customerId) {
        Customer customer = customerRepository.findAllById(customerId)
                .orElseThrow(()-> new RuntimeException("Customer doesn't exist with a given Id:" + customerId));
        return modelMapper.map(customer, CustomerDto.class);
    }


    // REST API - Update Customer
    @Override
    public CustomerDto updateCustomer(Long customerId, CustomerDto updateCustomer) {

        Customer customer = customerRepository.findAllById(customerId)
                .orElseThrow(()-> new RuntimeException("Customer doesn't exist with a given Id:" + customerId));

        customer.setFirstName(updateCustomer.getFirstName());
        customer.setLastName(updateCustomer.getLastName());
        customer.setEmail(updateCustomer.getEmail());
        customer.setPhoneNumber(updateCustomer.getPhoneNumber());

        Customer updateCustomerObj = customerRepository.save(customer);
        return  modelMapper.map(updateCustomerObj, CustomerDto.class);

    }

    // REST API - Delete Customer
    @Override
    public void deleteCustomer(Long customerId) {
        Customer customer = customerRepository.findAllById(customerId)
                .orElseThrow(()-> new RuntimeException("Customer doesn't exist with given id:" + customerId));
        customerRepository.deleteById(customerId);
    }

}
