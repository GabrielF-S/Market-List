package br.com.gabsdev.market_list.model.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(@NotEmpty(message = "Email é obrigatorio") String email,
                           @NotEmpty(message = "Senha é obrigatorio") String password) {
}
