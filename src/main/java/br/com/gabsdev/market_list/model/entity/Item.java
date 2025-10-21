package br.com.gabsdev.market_list.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;
@Entity
@AllArgsConstructor
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private BigDecimal expectedValue;
    private BigDecimal realdValue;
    private Boolean addedToCart;
    private int quantity;


    public Item() {

        this.expectedValue = new BigDecimal(0);
        this.realdValue = new BigDecimal(0);
    }

    public BigDecimal getValue() {

        var value = realdValue.equals(BigDecimal.ZERO) ? expectedValue : realdValue;

        for( int qtd = 1; qtd < this.quantity; qtd++){
            value = value.add(new BigDecimal(value.intValue()));
        }
        return value;
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
