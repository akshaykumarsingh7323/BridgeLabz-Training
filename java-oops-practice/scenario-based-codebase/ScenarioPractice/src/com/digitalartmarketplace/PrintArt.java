package com.digitalartmarketplace;

public class PrintArt extends ArtWork {

    public PrintArt(String title, String artist, double price,
                    String licenseType, String licensingTerms) {
        super(title, artist, price, licenseType, licensingTerms);
    }

    @Override
    public void purchase(User user) {
        double printCost = price + 500;  
        if (user.deductBalance(printCost)) {
            System.out.println(user.getName() + " purchased print art: " + title);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    @Override
    public void license(User user) {
        System.out.println("Limited print license for " + title);
        System.out.println("Terms: " + getLicensingTerms());
    }
}
