package br.com.gabsdev.market_list.controller;

import br.com.gabsdev.market_list.model.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UsuarioController {

    @PostMapping
    ResponseEntity<User>  createUsuario(@RequestBody User usuario);
}
