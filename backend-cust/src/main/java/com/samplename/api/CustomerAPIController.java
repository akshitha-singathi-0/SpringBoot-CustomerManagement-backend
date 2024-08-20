package com.samplename.api;

import java.util.Iterator;
import java.util.Optional;

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

    @GetMapping
    public Iterable<Customer> getAll(){
        return repo.findAll();
    }

    @GetMapping("/{customerId}")
    public Optional<Customer> getCustomerById(@PathVariable("customerId") long id){
        return repo.findById(id);
    }

    // @PostMapping
    // public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer){
    //     if(newCustomer.getName() == null || newCustomer.getEmail() == null){
    //         return ResponseEntity.badRequest().build();
    //     }
    //     customerList.add(newCustomer);
    //     return ResponseEntity.ok().build();
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity<?> updateCustomer(@RequestBody Customer newCustomer, @PathVariable long id){
    //     if(newCustomer.getName() == null || newCustomer.getEmail() == null){
    //         return ResponseEntity.badRequest().build();
    //     }
    //     customerList.add(newCustomer);
    //     return ResponseEntity.ok().build();
    // }
}
