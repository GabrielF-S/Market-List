package br.com.gabsdev.market_list.controller.impl;

import br.com.gabsdev.market_list.controller.ItemController;
import br.com.gabsdev.market_list.model.dto.response.ItemDTO;
import br.com.gabsdev.market_list.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "api/itens")
@RestController
public class ItemControllerImpl implements ItemController {

    private final ItemService service;

    public ItemControllerImpl(ItemService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<String>> getAllItens() {
        return ResponseEntity.ok(service.getItensName());
    }

    @Override
    public ResponseEntity<List<ItemDTO>> getItensToChart(String itemName) {
        return ResponseEntity.ok(service.getItensToChart(itemName));
    }
}
