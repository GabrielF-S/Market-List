package br.com.gabsdev.market_list.model.repository;

import br.com.gabsdev.market_list.model.entity.MarketList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface MarketListRepository extends JpaRepository<MarketList, UUID> {

    @Query(value = "Select m FROM MarketList WHERE m.current = true", nativeQuery = true)
    Optional<MarketList> findCurrentList();

    @Query(value = "Select m FROM MarketList WHERE m.current = false", nativeQuery = true)
    Optional<List<MarketList> >findAllOldList();
}
