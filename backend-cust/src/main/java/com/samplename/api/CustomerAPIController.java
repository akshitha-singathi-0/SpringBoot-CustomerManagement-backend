package com.samplename.api;

import java.net.URI;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.samplename.objects.Customer;
import com.samplename.repositories.CustRepository;

@RestController
@RequestMapping("/")
public class CustomerAPIController {

    @Autowired
    CustRepository repo;

    @GetMapping
    public String onRoot(){
        return "The API is up and running!";
    }

    @GetMapping("/customers")
    public Iterable<Customer> getAll(){
        return repo.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public Optional<Customer> getCustomerById(@PathVariable("customerId") long id){
        return repo.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer){
        if(newCustomer.getName() == null || newCustomer.getEmail() == null){
            return ResponseEntity.badRequest().build();
        }
        newCustomer = repo.save(newCustomer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/customers/{customerId}").buildAndExpand(newCustomer.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer newCustomer, @PathVariable long id){
        if(newCustomer.getId() != id || newCustomer.getName() == null || newCustomer.getEmail() == null){
            return ResponseEntity.badRequest().build();
        }
        repo.save(newCustomer);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable long id){
        repo.deleteById(id);;
        return ResponseEntity.ok().build();
    }
}
