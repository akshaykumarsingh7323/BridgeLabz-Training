package com.digitalartmarketplace;

public class UseDigitalMarket {

    public static void main(String[] args) {

        User user = new User("Akshay", 5000);

        ArtWork digitalArt = new DigitalArt(
                "Sunset Bliss", "Ravi", 1500, "Commercial");

        ArtWork printArt = new PrintArt(
                "Vintage Portrait", "Anita", 2000,
                "Personal", "Single-use print license");

        digitalArt.purchase(user);
        digitalArt.license(user);

        printArt.purchase(user);
        printArt.license(user);

        System.out.println("Wallet Balance Left: Rs " + user.getWalletBalance());
    }
}
