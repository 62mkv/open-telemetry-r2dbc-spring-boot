package com.example.opentelemetryr2dbcspringboot.controller;

import com.example.opentelemetryr2dbcspringboot.model.Sample;
import com.example.opentelemetryr2dbcspringboot.repository.SampleRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/sample")
public class SampleController {
    private final SampleRepository repository;

    public SampleController(SampleRepository repository) {this.repository = repository;}

    @GetMapping
    public Flux<Sample> samples() {
        return repository.findAll();
    }

    @PostMapping
    public Mono<Sample> create(@RequestParam String name) {
        return repository.create(name);
    }
}
