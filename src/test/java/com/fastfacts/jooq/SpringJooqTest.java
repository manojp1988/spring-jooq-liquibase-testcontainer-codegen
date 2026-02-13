package com.fastfacts.jooq;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest
public class SpringJooqTest {
  @ServiceConnection
  static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
      "postgres:16-alpine"
  );

  @Test
  public void test() {
    assertThat(postgres.isCreated()).isTrue();
    assertThat(postgres.isRunning()).isTrue();
  }
}
