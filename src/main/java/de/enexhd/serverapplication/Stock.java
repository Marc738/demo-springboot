package de.enexhd.serverapplication;

import org.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Stock {
    String symbol = "INIT";
    int price = 0;
    public Stock(String symbol, int price) {
        this.symbol = symbol;
        this.price = price;
    }
    public String getSymbol() {
        return symbol;
    }
    public int getPrice() {
        return price + (int) Math.round(Math.random() * 100);
    }

    public JSONObject toJSON() {
        return new JSONObject().put("symbol", symbol).put("price", price).put("timestamp", new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(Calendar.getInstance().getTime()));
    }

}
