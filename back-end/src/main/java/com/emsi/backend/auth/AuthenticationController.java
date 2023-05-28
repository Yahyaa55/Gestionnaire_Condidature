package com.emsi.backend.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
//@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
          @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
  @PostMapping("/authenticate")
  public ResponseEntity<String> authenticate(
          @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
          HttpServletRequest request,
          HttpServletResponse response
  ) throws IOException {
    service.refreshToken(request, response);
  }


}
