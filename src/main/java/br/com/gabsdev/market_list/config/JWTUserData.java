package br.com.gabsdev.market_list.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long userId, String email) {
}
