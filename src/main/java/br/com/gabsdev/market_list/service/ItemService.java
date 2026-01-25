package br.com.gabsdev.market_list.service;

import br.com.gabsdev.market_list.model.dto.response.ItemDTO;

import java.util.List;

public interface ItemService {


    List<ItemDTO> getItensToChart(String name);

    List<String> getItensName();
}
