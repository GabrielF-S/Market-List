package br.com.gabsdev.market_list.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
@AllArgsConstructor
@Data
public class Item {

    private String name;
    private BigDecimal expectedValue;
    private BigDecimal realdValue;
    private Boolean addedToCart;
    private int quantity;


    public Item() {
        this.expectedValue = new BigDecimal(0);
        this.realdValue = new BigDecimal(0);
    }

    public BigDecimal getTotalValue() {
        var value = realdValue.compareTo(BigDecimal.ZERO) ==0 ? expectedValue : realdValue;
        return value.multiply(new BigDecimal(this.quantity));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
