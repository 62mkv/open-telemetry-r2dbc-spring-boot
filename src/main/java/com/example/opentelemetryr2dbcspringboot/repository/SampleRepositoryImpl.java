package com.example.opentelemetryr2dbcspringboot.repository;

import com.example.opentelemetryr2dbcspringboot.model.Sample;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
public class SampleRepositoryImpl implements SampleRepositoryCustom {

    private final R2dbcEntityTemplate template;

    @Override
    public Mono<Sample> create(String name) {
        Sample sample = new Sample();
        sample.setId(UUID.randomUUID());
        sample.setName(name);
        return template.insert(sample);
    }

}
