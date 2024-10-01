package demo.cnsservice.controller;


import demo.cnsservice.dto.CustomerDto;
import demo.cnsservice.entity.Customer;
import demo.cnsservice.repository.CustomerRepository;
import demo.cnsservice.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    private CustomerService customerService;

    //POST New Customer REST API
    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto savedCustomer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    //GET All Customers REST API
    @GetMapping
    public  ResponseEntity<List<CustomerDto>> getAllCustomers(){
        List<CustomerDto> customer = customerService.getAllCustomers();
        return ResponseEntity.ok(customer);
    }

    //GET Customer By ID REST API
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById( @PathVariable("id") long id){
        Customer customer = customerRepository.findAllById(id)
                .orElseThrow(()-> new RuntimeException("Customer does not exist with Id:" + id));
        return  ResponseEntity.ok(customer);
    }

    //UPDATE Customer REST API
    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer (@PathVariable ("id") long id,
                                                    @RequestBody Customer customerDetails){
        Customer updateCustomer = customerRepository.findAllById(id)
                .orElseThrow(()-> new RuntimeException("Customer does not exist with id: " + id));

        updateCustomer.setFirstName(customerDetails.getFirstName());
        updateCustomer.setLastName(customerDetails.getFirstName());
        updateCustomer.setEmail(customerDetails.getEmail());
        updateCustomer.setPhoneNumber(customerDetails.getPhoneNumber());

        customerRepository.save(updateCustomer);
        return ResponseEntity.ok(updateCustomer);

    }


    //DELETE Customer REST API
    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteCustomer( @PathVariable("id") Long customerId){
        customerService.deleteCustomer(customerId);
        return  ResponseEntity.ok("Customer Deleted Successfully");
    }

}
