package com.example.demo.controller;

import com.example.demo.model.Fee;
import com.example.demo.model.Fee.FeeType;
import com.example.demo.service.FeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/fees")
public class FeeController {

    private final FeeService feeService;

    public FeeController(FeeService feeService) {
        this.feeService = feeService;
    }
    
    @GetMapping("/")
    public String home() {
        return "index"; // will render index.html in templates/
    }


    // ✅ REST endpoint for API-based fee calculation
    @PostMapping("/calculate")
    @ResponseBody
    public Fee calculateFee(
            @RequestParam FeeType feeType,
            @RequestParam double price,
            @RequestParam int quantity) {

        return feeService.calculateFee(feeType, price, quantity).block();
    }

    // ✅ Thymeleaf: show the form
    @GetMapping("/form")
    public String showForm() {
        return "calculateFee"; // refers to calculateFee.html
    }

    // ✅ Thymeleaf: handle form POST, return result page
    @PostMapping("/calculate/view")
    public Mono<String> calculateAndShowResult(
            @RequestParam FeeType feeType,
            @RequestParam double price,
            @RequestParam int quantity,
            Model model) {

        return feeService.calculateFee(feeType, price, quantity)
                .map(savedFee -> {
                    model.addAttribute("fee", savedFee);
                    return "feeResult"; // refers to feeResult.html
                });
    }
}
