package br.com.gabsdev.market_list.controller.impl;

import br.com.gabsdev.market_list.config.TokenConfig;
import br.com.gabsdev.market_list.controller.AuthController;
import br.com.gabsdev.market_list.model.dto.request.LoginRequest;
import br.com.gabsdev.market_list.model.dto.request.RegisterUserRequest;
import br.com.gabsdev.market_list.model.dto.response.LoginResponse;
import br.com.gabsdev.market_list.model.dto.response.RegisterUserResponse;
import br.com.gabsdev.market_list.model.entity.User;
import br.com.gabsdev.market_list.model.repository.UserRepository;
import br.com.gabsdev.market_list.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthControllerImpl implements AuthController {
    private final UsuarioService service;
    private final PasswordEncoder encoder;
    private  final AuthenticationManager authenticationManager;
    private final TokenConfig tokenConfig;

    public AuthControllerImpl(UserRepository repository,
                              UsuarioService service,
                              PasswordEncoder encoder,
                              AuthenticationManager authenticationManager, TokenConfig tokenConfig) {
        this.service = service;
        this.encoder = encoder;
        this.authenticationManager = authenticationManager;
        this.tokenConfig = tokenConfig;
    }


    @Override
    public ResponseEntity<LoginResponse> login(LoginRequest request) {

        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(
                request.email(),
                request.password()
        );

        Authentication authentication = authenticationManager.authenticate(userAndPass);

        User user = (User) authentication.getPrincipal();
        String token = tokenConfig.generateToken(user);



        return  ResponseEntity.ok(new LoginResponse(token)) ;
    }

    @Override
    public ResponseEntity<RegisterUserResponse> registerUserResponseResponseEntity(RegisterUserRequest request) {
        User newUser = new User();
        newUser.setPassword(encoder.encode(request.password()));
        newUser.setEmail(request.email());
        newUser.setName(request.name());
        service.salvar(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(new RegisterUserResponse(newUser.getName(),newUser.getEmail()));

    }


}
