package de.enexhd.serverapplication;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class APIRequestController {
    @Autowired
    private APIHandler handler;

    @GetMapping("/api/realtime")
    public String index(@RequestParam(defaultValue = "0") int token, @RequestParam(defaultValue = "") String symbol) {
        if(token == 123) {
            return getStock(symbol).toString();
        } else {
            return new JSONObject().put("error-class", 0).toString();
        }
    }

    private JSONObject getStock(String symbol) {
        Optional<Stock> optStock = handler.getStock(symbol);
        if(optStock.isPresent()) {
            Stock stock = optStock.get();
            return new JSONObject().put("error-class", 0).put("symbol", stock.getSymbol()).put("price", stock.getPrice());
        } else {
            return new JSONObject().put("error-class", 1);
        }
    }

}
