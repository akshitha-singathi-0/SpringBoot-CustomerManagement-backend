package com.samplename.repositories;

import org.springframework.data.repository.CrudRepository;

import com.samplename.api.Customer;

public interface CustRepository extends CrudRepository<Customer, Long>{
    
}
