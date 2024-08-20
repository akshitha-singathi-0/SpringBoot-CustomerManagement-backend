package com.samplename.api;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samplename.repositories.CustRepository;

@RestController
@RequestMapping("/customers")
public class CustomerAPIController {

    @Autowired
    CustRepository repo;

    ArrayList<Customer> customerList = new ArrayList<Customer>();

    public CustomerAPIController(){
        Customer cust1 = new Customer(0, "John Smith", "abc123", "abc@gmail.com");
        Customer cust2 = new Customer(1, "Sarah Jane", "abc456", "abc456@gmail.com");
        Customer cust3 = new Customer(2, "Mary Kate", "def123", "def@gmail.com");
        Customer cust4 = new Customer(3, "Richard Green", "def456", "def456@gmail.com");
        
        customerList.add(cust1);
        customerList.add(cust2);
        customerList.add(cust3);
        customerList.add(cust4);
    }

    @GetMapping("/customer")
    public ArrayList<Customer> getAll(){
        return customerList;
    }

    @GetMapping("/{custId}")
    public Customer getCustomerById(@PathVariable("custId") long id){
        Customer foundCustomer = new Customer(0, null, null, null);
        for(int i = 0; i < customerList.size(); i++){
            foundCustomer = customerList.get(i);
            if(foundCustomer.getId() == id){
                return foundCustomer;
            }
        }
        return foundCustomer;
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer){
        if(newCustomer.getName() == null || newCustomer.getEmail() == null){
            return ResponseEntity.badRequest().build();
        }
        customerList.add(newCustomer);
        return ResponseEntity.ok().build();
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<?> updateCustomer(@RequestBody Customer newCustomer, @PathVariable long id){
    //     if(newCustomer.getName() == null || newCustomer.getEmail() == null){
    //         return ResponseEntity.badRequest().build();
    //     }
    //     customerList.add(newCustomer);
    //     return ResponseEntity.ok().build();
    // }
}
