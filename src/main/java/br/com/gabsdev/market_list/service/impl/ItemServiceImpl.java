package br.com.gabsdev.market_list.service.impl;

import br.com.gabsdev.market_list.model.dto.response.ItemDTO;
import br.com.gabsdev.market_list.model.repository.ItemRepository;
import br.com.gabsdev.market_list.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository repository;

    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ItemDTO> getItensToChart(String name) {
        return repository.getItensDTO(name);
    }

    @Override
    public List<String> getItensName() {
        return repository.findNames();
    }
}
