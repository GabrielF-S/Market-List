package br.com.gabsdev.market_list.model.repository;

import br.com.gabsdev.market_list.model.dto.response.ItemDTO;
import br.com.gabsdev.market_list.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(value = """
                SELECT  
                    m.market_name AS marketName,
                    i.name AS name,
                    SUM(i.quantity) AS quantity,
                    ROUND(AVG(i.value), 2) AS value, 
                    m.buy_date AS buyDate
                FROM market_list m
                INNER JOIN itens i ON i.itens_id = m.id
                WHERE i.name = :name
                GROUP BY marketName, name, buyDate
            """, nativeQuery = true)
    List<ItemDTO> getItensDTO(@Param("name") String name);

    @Query(value = """
                SELECT  DISTINCT
                    i.name AS name               
                FROM  itens i
                
            """, nativeQuery = true)
    List<String> findNames();
}
