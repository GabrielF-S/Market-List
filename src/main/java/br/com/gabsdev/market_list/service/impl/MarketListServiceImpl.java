package br.com.gabsdev.market_list.service.impl;

import br.com.gabsdev.market_list.exception.MarketListException;
import br.com.gabsdev.market_list.model.entity.Item;
import br.com.gabsdev.market_list.model.entity.MarketList;
import br.com.gabsdev.market_list.model.repository.MarketListRepository;
import br.com.gabsdev.market_list.service.MarketlListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
public class MarketListServiceImpl implements MarketlListService {

    private final MarketListRepository repository;

    @Override
    public MarketList addToMarketList(Item item) {
        MarketList currentMarketList = repository.findByCurrentTrue().orElse(MarketList.getInstance());
        if(!currentMarketList.getItemsList().contains(item)){
            currentMarketList.getItemsList().add(item);
        }else {
            for(Item i : currentMarketList.getItemsList()){
                if (i.equals(item)){
                    int qtd = i.getQuantity() + item.getQuantity();
                    i.setQuantity(qtd);
                }
            }

        }
        repository.save(currentMarketList);
        return  currentMarketList;
    }

    @Override
    public MarketList getCurrentMarketList() {
        return repository.findByCurrentTrue().orElse(MarketList.getInstance());
    }

    @Override
    public MarketList closeMarketList(MarketList marketList) {
        if (marketList.getItemsList().isEmpty()){
            throw new MarketListException("Não é possivel concluir listas que não contenha nenhum item");
        }
        marketList.setCurrent(false);
        marketList.setBuyDate(LocalDate.now());
        repository.save(marketList);
        return marketList;
    }

    @Override
    public BigDecimal getTotalAmount() {
       return calculateTotalAmount();
    }

    @Override
    public List<MarketList> getAllList() {
        return repository.findByCurrentFalse().orElseThrow(() -> new MarketListException("Nenhuma Lista encontrada"));
    }

    @Override
    public MarketList removeItem(Item item) {
        MarketList marketList = repository.findByCurrentTrue().orElseThrow(() -> new MarketListException("Nenhuma Lista encontrada"));
        if (!marketList.getItemsList().contains(item)){
            throw new MarketListException("Item não localizado na lista");
        }else {
            marketList.getItemsList().remove(item);
        }
       return repository.save(marketList);

    }

    @Override
    public Item updateItem(Item item) {
        MarketList marketList = repository.findByCurrentTrue().orElseThrow(() -> new MarketListException("Nenhuma Lista encontrada"));
        Item itemToReturn = new Item();
        if (!marketList.getItemsList().contains(item)){
            throw new MarketListException("Item não localizado na lista");
        }else {
            for(Item i : marketList.getItemsList()){
                if (i.equals(item)){
                 i.setChecked(item.isChecked());
                 i.setRealdValue(item.getRealdValue());
                 i.setQuantity(item.getQuantity());
                 itemToReturn = i;
                }
            }
        }
        repository.save(marketList);
        return itemToReturn;

    }

    private BigDecimal calculateTotalAmount() {
        MarketList currentMarketList = repository.findByCurrentTrue().orElseThrow(() -> new MarketListException("Nenhuma Lista encontrada"));
        return  currentMarketList.getTotalAmounth();

    }
}
