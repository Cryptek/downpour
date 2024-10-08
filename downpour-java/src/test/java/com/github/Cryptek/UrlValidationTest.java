package com.github.Cryptek;

import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UrlValidationTest {

  @Test
  void properUrl_IsValid() throws URISyntaxException {
    String url = "https://google.com";
    assertNotNull(Downpour.validateAndGetUrl(url));
  }

  @Test
  void wrongUrl_IsInvalid() {
    String url = "hello world";
    assertThrows(URISyntaxException.class, () -> {
      Downpour.validateAndGetUrl(url);
    });
  }
}
