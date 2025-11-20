package br.com.gabsdev.market_list.service.impl;

import br.com.gabsdev.market_list.exception.UsuarioException;
import br.com.gabsdev.market_list.model.entity.User;
import br.com.gabsdev.market_list.model.repository.UserRepository;
import br.com.gabsdev.market_list.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UserRepository repository;

    public UsuarioServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User salvar(User usuario) {
        if (usuario.getId() != null){
            if (repository.existsById(usuario.getId())){
                throw new UsuarioException("Usuario já existente");
            }
        }

        return repository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
