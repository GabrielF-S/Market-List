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
        MarketList currentMarketList = repository.findByCurrentTrue().orElse(new MarketList());
        currentMarketList.getItemsList().add(item);
        repository.save(currentMarketList);
        return  currentMarketList;
    }

    @Override
    public MarketList getCurrentMarketList() {
        return repository.findByCurrentTrue().orElse(new MarketList());
    }

    @Override
    public MarketList claseMarketList(MarketList marketList) {
        marketList.setCurrent(false);
        marketList.setBuyDate(LocalDate.now());
        repository.save(marketList);
        return null;
    }

    @Override
    public BigDecimal getTotalAmount() {
       return calculateTotalAmount();
    }

    @Override
    public List<MarketList> getAllList() {
        return repository.findByCurrentFalse().orElseThrow(() -> new MarketListException("Nenhuma Lista encontrada"));
    }

    private BigDecimal calculateTotalAmount() {
        MarketList currentMarketList = repository.findByCurrentTrue().orElseThrow(() -> new MarketListException("Nenhuma Lista encontrada"));

//        BigDecimal total = BigDecimal.ZERO;
//
//        for( Item item : currentMarketList.getItemsList()){
//            total= total.add(new BigDecimal(item.getValue().toString()));
//        }
//        currentMarketList.setTotalAmounth(total);
        return  currentMarketList.getTotalAmounth();

    }
}
