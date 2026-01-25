package br.com.gabsdev.market_list.model.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public record ItemDTO(
        String marketName,
        String name,
        Long quantity,
        BigDecimal value,
        Date buyDate
        ) {

}
