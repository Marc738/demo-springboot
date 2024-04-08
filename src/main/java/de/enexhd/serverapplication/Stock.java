package de.enexhd.serverapplication;

public class Stock {
    String symbol = "INIT";
    double price = 0.0;
    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
    public String getSymbol() {
        return symbol;
    }
    public double getPrice() {
        return price + (Math.random() - 0.5) * 3;
    }

}
