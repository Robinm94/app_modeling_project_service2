package com.example.demo.service;

import com.example.demo.model.Fee;
import com.example.demo.model.Fee.FeeType;
import com.example.demo.repository.FeeRepository;

import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class FeeService {

    private final FeeRepository feeRepository;

    public FeeService(FeeRepository feeRepository) {
        this.feeRepository = feeRepository;
    }

    public Mono<Fee> calculateFee(FeeType feeType, double price, int quantity) {
        double total = price * quantity;
        float feeAmount = (float) (total * 0.01);
        float salesTax = (float) (total * 0.13);

        // Directly using the constructor
        Fee fee = new Fee(feeType, feeAmount, salesTax, LocalDate.now(), LocalTime.now());

        return feeRepository.save(fee);
    }
}

