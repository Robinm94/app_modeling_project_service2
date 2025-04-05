package com.example.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Fee;

@Repository
public interface FeeRepository extends ReactiveMongoRepository<Fee, String> {
    
}
