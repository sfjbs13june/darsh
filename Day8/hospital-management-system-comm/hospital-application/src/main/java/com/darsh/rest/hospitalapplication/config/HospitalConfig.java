package com.darsh.rest.hospitalapplication.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import java.time.*;

@Configuration
public class HospitalConfig {

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {

    return builder
      .setConnectTimeout(Duration.ofMillis(3000))
      .setReadTimeout(Duration.ofMillis(3000))
      .build();
  }
}
