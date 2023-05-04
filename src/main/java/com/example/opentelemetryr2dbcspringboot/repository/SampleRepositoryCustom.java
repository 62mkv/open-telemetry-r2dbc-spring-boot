package com.example.opentelemetryr2dbcspringboot.repository;

import com.example.opentelemetryr2dbcspringboot.model.Sample;
import reactor.core.publisher.Mono;

public interface SampleRepositoryCustom {
    Mono<Sample> create(String name);
}
