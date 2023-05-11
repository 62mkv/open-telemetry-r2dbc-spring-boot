package com.example.opentelemetryr2dbcspringboot.tracing;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.instrumentation.r2dbc.v1_0.R2dbcTelemetry;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TracingConfiguration {

    @Bean
    ConnectionFactory connectionFactory(R2dbcProperties properties) {
        var openTelemetry = GlobalOpenTelemetry.get();
        var factoryOptions = ConnectionFactoryOptions.parse(properties.getUrl())
                                                     .mutate()
                                                     .option(ConnectionFactoryOptions.USER, properties.getUsername())
                                                     .option(ConnectionFactoryOptions.PASSWORD, properties.getPassword())
                                                     .build();

        return wrapWithProxyFactory(openTelemetry, ConnectionFactories.get(factoryOptions), factoryOptions);
    }

    private ConnectionFactory wrapWithProxyFactory(OpenTelemetry openTelemetry, ConnectionFactory originalFactory, ConnectionFactoryOptions factoryOptions) {
        return R2dbcTelemetry
                   .create(openTelemetry)
                   .wrapConnectionFactory(originalFactory, factoryOptions);
    }
}
