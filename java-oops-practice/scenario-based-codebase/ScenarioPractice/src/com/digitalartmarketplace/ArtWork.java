package com.digitalartmarketplace;

public abstract class ArtWork implements IPurchasable {

    protected String title;
    protected String artist;
    protected double price;
    protected String licenseType;
    private String licensingTerms;     

    public ArtWork(String title, String artist, double price, String licenseType) {
        this(title, artist, price, licenseType, "Standard License");
    }

    public ArtWork(String title, String artist, double price,
                   String licenseType, String licensingTerms) {
        this.title = title;
        this.artist = artist;
        this.price = price;
        this.licenseType = licenseType;
        this.licensingTerms = licensingTerms;
    }

    protected String getLicensingTerms() {
        return licensingTerms;
    }

    public abstract void purchase(User user);
    public abstract void license(User user);
}
