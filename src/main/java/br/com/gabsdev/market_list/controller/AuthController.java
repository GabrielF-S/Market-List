package br.com.gabsdev.market_list.controller;

import br.com.gabsdev.market_list.model.dto.request.LoginRequest;
import br.com.gabsdev.market_list.model.dto.request.RegisterUserRequest;
import br.com.gabsdev.market_list.model.dto.response.LoginResponse;
import br.com.gabsdev.market_list.model.dto.response.RegisterUserResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthController {

    @PostMapping("/login")
    ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request);

    @PostMapping("/register")
    ResponseEntity<RegisterUserResponse> registerUserResponseResponseEntity(@Valid @RequestBody RegisterUserRequest request);

}
