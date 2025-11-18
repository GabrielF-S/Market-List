package br.com.gabsdev.market_list.controller.impl;

import br.com.gabsdev.market_list.controller.MarketListController;
import br.com.gabsdev.market_list.model.entity.Item;
import br.com.gabsdev.market_list.model.entity.MarketList;
import br.com.gabsdev.market_list.service.MarketlListService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/currentList")
@AllArgsConstructor
public class MarketListControllerImpl implements MarketListController {

    private final MarketlListService service;
    @Override
    public ResponseEntity<MarketList> closeMarketList(MarketList marketList) {
        log.info("Recebido Lista: " + marketList.toString());
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
        log.info("Recebido Item: " + item.getName());
        return ResponseEntity.ok(service.addToMarketList(item));
    }

    @Override
    public ResponseEntity<Item> updateItem(Item item) {
        log.info("Atualizado :: Item: " + item.getName() );
            return ResponseEntity.ok(service.updateItem(item));

    }

    @Override
    public ResponseEntity<MarketList> removeToCart(Item item) {
        return ResponseEntity.ok(service.removeItem(item));
    }

    @Override
    public ResponseEntity<MarketList> getCurrentMarketList() {
        return ResponseEntity.ok(service.getCurrentMarketList());
    }
}
