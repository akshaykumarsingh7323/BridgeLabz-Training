package com.foreach.stockpricelogger;

import java.util.*;

public class ShowStockPrice {

    public static void main(String[] args) {

        List<Double> stockPrices = Arrays.asList(
                1250.50,
                1265.75,
                1240.30,
                1278.90
        );

        stockPrices.forEach(price -> System.out.println("Live Stock Price: Rs " + price)
        );
    }
}

