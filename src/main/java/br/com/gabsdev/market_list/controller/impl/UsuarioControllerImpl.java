package br.com.gabsdev.market_list.controller.impl;

import br.com.gabsdev.market_list.controller.UsuarioController;
import br.com.gabsdev.market_list.model.entity.User;
import br.com.gabsdev.market_list.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuario")
@RequiredArgsConstructor
public class UsuarioControllerImpl implements UsuarioController {

    private final UsuarioService service;

    @Override
    public ResponseEntity<User> createUsuario(User usuario) {
        return ResponseEntity.ok(service.salvar(usuario));


    }
}
