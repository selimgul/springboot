package com.example.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class ServiceHealth implements HealthIndicator {

    @Override
    public Health health() {
        return Health.status(Status.UP)
                .withDetail("Servisin sağlık durumu ile ilgili başlık",
                            "Servisin sağlık durumu ile ilgili detay")
                .build();
    }

}
