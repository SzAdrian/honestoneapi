package com.codecool.honestoneapi.controller;

import com.codecool.honestoneapi.controller.dto.UserCredentials;
import com.codecool.honestoneapi.controller.dto.UserResponseCredentials;
import com.codecool.honestoneapi.repository.UserRepository;
import com.codecool.honestoneapi.security.JwtUtil;
import com.codecool.honestoneapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.Duration;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    @Value("${jwt.expiration.hours}")
    private int jwtExpirationHours;


    @PostMapping("/login")
    public ResponseEntity<UserResponseCredentials> login(@RequestBody UserCredentials user, HttpServletResponse response) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword()));

        String jwtToken = jwtUtil.generateToken(authentication);
        addTokenToCookie(response, jwtToken);

        return ResponseEntity.ok().body(userService.getUserResponseCredentials(user));
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserCredentials userCredentials){
        userService.register(userCredentials);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCredentials.getUsername());
    }

    private void addTokenToCookie(HttpServletResponse response, String token) {

        ResponseCookie cookie = ResponseCookie.from("token", token)
                .domain("https://honestone.herokuapp.com") // should be parameterized
                .sameSite("Strict")  // CSRF
//                .secure(true)
                .maxAge(Duration.ofHours(jwtExpirationHours))
                .httpOnly(true)      // XSS
                .path("/")
                .build();
        response.addHeader("Set-Cookie", cookie.toString());
    }
}
