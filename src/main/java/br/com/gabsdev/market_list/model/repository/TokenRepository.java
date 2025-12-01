package br.com.gabsdev.market_list.model.repository;

import br.com.gabsdev.market_list.model.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
    boolean existsByTokenString(String token);
}
