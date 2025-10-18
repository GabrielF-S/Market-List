package br.com.gabsdev.market_list.service;

import br.com.gabsdev.market_list.model.entity.Item;
import br.com.gabsdev.market_list.model.entity.MarketList;

import java.math.BigDecimal;
import java.util.List;

public interface MarketlListService {

    MarketList addToMarketList(Item item);

    MarketList getCurrentMarketList();

    MarketList claseMarketList(MarketList marketList);

    BigDecimal getTotalAmount();

    List<MarketList> getAllList();
}
