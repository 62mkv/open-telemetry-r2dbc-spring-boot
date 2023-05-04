package com.example.opentelemetryr2dbcspringboot.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table
public class Sample {
    @Id
    UUID id;

    String name;
}
