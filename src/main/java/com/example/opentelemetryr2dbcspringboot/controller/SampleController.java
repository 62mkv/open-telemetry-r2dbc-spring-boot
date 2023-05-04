package com.example.opentelemetryr2dbcspringboot.controller;

import com.example.opentelemetryr2dbcspringboot.model.Sample;
import com.example.opentelemetryr2dbcspringboot.repository.SampleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/sample")
public class SampleController {
    private final SampleRepository repository;

    public SampleController(SampleRepository repository) {this.repository = repository;}

    @GetMapping
    public Flux<Sample> samples() {
        return repository.findAll();
    }
}
