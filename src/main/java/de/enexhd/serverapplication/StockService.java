package de.enexhd.serverapplication;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class StockService {

    private ArrayList<Stock> stocks;

    public StockService() {
        stocks = new ArrayList<>();
        stocks.add(new Stock("AAPL", 15482));
        stocks.add(new Stock("MSF", 39045));
        stocks.add(new Stock("0TL", 391));
        stocks.add(new Stock("BMW", 11445));
    }

    boolean hasStock(String stock) {
        return stocks.contains(stock);
    }

    ServiceResponse getStock(String symbol) {
        Optional<Stock> optStock = stocks.stream()
                .filter(stock -> stock.symbol.contentEquals(symbol))
                .findFirst();
        if(optStock.isPresent()) {
            return new ServiceResponse(0, "No Error!").setData(optStock.get().toJSON());
        } else {
            return new ServiceResponse(2, "The symbol doesn't fit any available stock!");
        }
    }

}
