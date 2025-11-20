package br.com.gabsdev.market_list.service;

import br.com.gabsdev.market_list.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService  extends UserDetailsService {

    User salvar(User usuario);

}
