package br.com.gabsdev.market_list.controller;

import br.com.gabsdev.market_list.model.entity.Item;
import br.com.gabsdev.market_list.model.entity.MarketList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

public interface MarketListController {

    @GetMapping
    ResponseEntity<MarketList> getCurrentMarketList();

    @GetMapping(value ="totalAmount")
    ResponseEntity<BigDecimal> getTotalAmount();

    @GetMapping(value = "allList")
    ResponseEntity<List<MarketList>> getAllList();

    @PostMapping
    ResponseEntity<MarketList> closeMarketList(@RequestBody MarketList marketList);

    @PostMapping(value = "addItem")
    ResponseEntity<MarketList> addItemToMarketList(@RequestBody Item item);


}
