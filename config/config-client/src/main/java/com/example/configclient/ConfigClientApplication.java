package com.example.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// config client için spring-cloud-starter-config ve spring-cloud-starter-bootstrap dependency'leri eklendi.
// bootstrap.yml dosyasında config-server'ın adresi verildi.
// uygulamayı restart etmeden config değerlerinin güncellenmesi için @RefreshScope annotation'ı kullanıldı.
// config değerlerinin güncellenmesi için gerekli /actuator/refresh endpoint'i bootstrap.yml içerisinde expose edildi.

@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

}
