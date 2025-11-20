package br.com.gabsdev.market_list.model.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record RegisterUserRequest(@NotEmpty(message = "Nome é obrigatorio")
                                  String name, @NotEmpty(message = "Email é obrigatorio") String email,
                                  @NotEmpty(message = "Senha é obrigatorio") String password) {
}
