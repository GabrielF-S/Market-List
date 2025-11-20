package br.com.gabsdev.market_list.model.dto.response;

import jakarta.validation.constraints.NotEmpty;

public record RegisterUserResponse(String name,String email) {
}
