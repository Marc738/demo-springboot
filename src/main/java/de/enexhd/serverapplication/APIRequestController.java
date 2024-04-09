package de.enexhd.serverapplication;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class APIRequestController {
    @Autowired
    private StockService stockService;
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/api/realtime")
    public Map<String, Object> getRealtime(@RequestParam(defaultValue = "0") int token, @RequestParam(defaultValue = "") String symbol) {
        ServiceResponse authenticationResponse = authenticationService.authenticate(token);
        if(authenticationResponse.getErrorClass() != 0) {
            return authenticationResponse.toJSON().toMap();
        } else {
            return stockService.getStock(symbol).toJSON().toMap();
        }
    }

    @GetMapping("/api/historical")
    public Map<String, Object> getHistorical(@RequestParam(defaultValue = "0") int token, @RequestParam(defaultValue = "") String symbol, @RequestParam(defaultValue = "1") int period) {
        // Return stock prices in given time period
        return new JSONObject().put("error-class", -1).put("error-info", "No service!").toMap();
    }

}
