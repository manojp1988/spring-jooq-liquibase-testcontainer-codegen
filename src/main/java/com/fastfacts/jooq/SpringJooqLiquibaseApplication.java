package com.fastfacts.jooq;

import com.fastfacts.jooq.generated.public_.tables.Certificate;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJooqLiquibaseApplication {

  @Autowired
  DSLContext dsl;

  public static void main(String[] args) {
    SpringApplication.run(SpringJooqLiquibaseApplication.class, args);
  }

  @Bean
  ApplicationRunner runner() {
    return args -> {
      long count = dsl.select(Certificate.CERTIFICATE.ID).from(Certificate.CERTIFICATE).stream().count();
      System.out.println(count);
    };
  }


}
