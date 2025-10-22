package br.com.gabsdev.market_list.controller.impl;

import br.com.gabsdev.market_list.controller.MarketListController;
import br.com.gabsdev.market_list.model.entity.Item;
import br.com.gabsdev.market_list.model.entity.MarketList;
import br.com.gabsdev.market_list.service.MarketlListService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "currentList")
@AllArgsConstructor
public class MarketListControllerImpl implements MarketListController {

    private final MarketlListService service;
    @Override
    public ResponseEntity<MarketList> closeMarketList(MarketList marketList) {
        return ResponseEntity.ok(service.closeMarketList(marketList));
    }

    @Override
    public ResponseEntity<BigDecimal> getTotalAmount() {
        return  ResponseEntity.ok(service.getTotalAmount());

    }

    @Override
    public ResponseEntity<List<MarketList>> getAllList() {
        return ResponseEntity.ok(service.getAllList());
    }


    @Override
    public ResponseEntity<MarketList> addItemToMarketList(Item item) {
        return ResponseEntity.ok(service.addToMarketList(item));
    }

    @Override
    public ResponseEntity<Void> removeToCart(Item item) {
        return ResponseEntity.ok(service.removeItem(item));
    }

    @Override
    public ResponseEntity<MarketList> getCurrentMarketList() {
        return ResponseEntity.ok(service.getCurrentMarketList());
    }
}
