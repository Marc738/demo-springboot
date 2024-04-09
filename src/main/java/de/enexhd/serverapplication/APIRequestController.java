package de.enexhd.serverapplication;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIRequestController {
    @Autowired
    private APIHandler handler;
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/api/realtime")
    public String index(@RequestParam(defaultValue = "0") int token, @RequestParam(defaultValue = "") String symbol) {
        ServiceResponse authenticationResponse = authenticationService.authenticate(token);
        if(authenticationResponse.getErrorClass() != 0)
            return authenticationResponse.toJSON().toString();
        else
            return getStock(symbol).toString();
    }


    private JSONObject getStock(String symbol) {
        return handler.getStock(symbol).toJSON();
    }

}
