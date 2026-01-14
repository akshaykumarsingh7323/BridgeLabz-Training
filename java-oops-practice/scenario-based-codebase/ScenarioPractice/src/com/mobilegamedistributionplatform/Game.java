package com.mobilegamedistributionplatform;

abstract class Game implements IDownloadable {

    protected String title;
    protected String genre;
    protected double price;
    protected double rating;

    public Game(String title, String genre, double price) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.rating = 0.0;
    }

    public Game(String title, String genre) {
        this(title, genre, 0.0);
    }

    public void applyDiscount(double percent) {
        price = price - (price * percent / 100); 
    }

    public String getTitle() {
        return title;
    }
}
