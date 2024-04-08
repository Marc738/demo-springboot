package de.enexhd.serverapplication;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class APIHandler {

    private ArrayList<Stock> stocks;

    public APIHandler() {
        stocks = new ArrayList<>();
        stocks.add(new Stock("AAPL", 177.34));
    }

    boolean hasStock(String stock) {
        return stocks.contains(stock);
    }

    Optional<Stock> getStock(String symbol) {
        return stocks.stream().filter(stock -> stock.symbol.contentEquals(symbol)).findFirst();
    }

}
