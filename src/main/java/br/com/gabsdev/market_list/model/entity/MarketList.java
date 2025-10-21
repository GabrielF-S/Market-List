package br.com.gabsdev.market_list.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "market_list")
@Data
@AllArgsConstructor
public class MarketList {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Item> itemsList;
    private BigDecimal totalAmounth;
    private LocalDate buyDate;
    private Boolean current;
    private String marketName;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MarketList that = (MarketList) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public MarketList() {
        this.current = true;
        this.itemsList = new ArrayList<>();
        this.totalAmounth = new BigDecimal(0);

    }

    public BigDecimal getTotalAmounth(){
        BigDecimal total = BigDecimal.ZERO;
        if (!this.getItemsList().isEmpty()){
            for( Item item : this.getItemsList()){
                total= total.add(new BigDecimal(item.getValue().toString()));
            }
        }
        return total;
    }

}
