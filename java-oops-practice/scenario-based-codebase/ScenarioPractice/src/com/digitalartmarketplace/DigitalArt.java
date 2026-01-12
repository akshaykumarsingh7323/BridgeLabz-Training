package com.digitalartmarketplace;

public class DigitalArt extends ArtWork {

    public DigitalArt(String title, String artist, double price, String licenseType) {
        super(title, artist, price, licenseType);
    }

    @Override
    public void purchase(User user) {
        if (user.deductBalance(price)) {
            System.out.println(user.getName() + " purchased digital art: " + title);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    @Override
    public void license(User user) {
        System.out.println("Digital license granted for " + title);
        System.out.println("Terms: " + getLicensingTerms());
    }
}
