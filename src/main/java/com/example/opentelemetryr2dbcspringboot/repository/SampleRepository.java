package com.example.opentelemetryr2dbcspringboot.repository;

import com.example.opentelemetryr2dbcspringboot.model.Sample;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SampleRepository extends R2dbcRepository<Sample, UUID>, SampleRepositoryCustom {


}
