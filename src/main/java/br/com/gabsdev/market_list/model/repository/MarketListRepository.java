package br.com.gabsdev.market_list.model.repository;

import br.com.gabsdev.market_list.model.entity.MarketList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MarketListRepository extends JpaRepository<MarketList, Long> {

    Optional<MarketList> findByCurrentTrue();
    Optional<List<MarketList>> findByCurrentFalse();
}
