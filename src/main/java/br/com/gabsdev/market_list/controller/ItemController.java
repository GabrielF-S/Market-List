package br.com.gabsdev.market_list.controller;

import br.com.gabsdev.market_list.model.dto.response.ItemDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ItemController {


    @GetMapping(value = "getList")
    ResponseEntity<List<String>> getAllItens();

    @GetMapping(value = "chartItem")
    ResponseEntity<List<ItemDTO>> getItensToChart(@RequestParam String itemName);
}
