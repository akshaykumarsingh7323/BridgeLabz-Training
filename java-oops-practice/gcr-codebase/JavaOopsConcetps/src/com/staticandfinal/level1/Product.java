package com.staticandfinal.level1;

public class Product {

	private static double discount = 0.0;

	private final String productID; 
    private String productName;
    private double price;
    private int quantity;

    public Product(String productID, String productName, double price, int quantity) {
	     this.productID = productID;
	     this.productName = productName;
	     this.price = price;
	     this.quantity = quantity;
	   }

    public static void updateDiscount(double newDiscount) {
        if (newDiscount >= 0.0 && newDiscount <= 100.0) {
            discount = newDiscount;
        } else {
            System.out.println("Invalid discount percentage. Please enter a value between 0 and 100.");
        }
    }

	  public double getDiscountedPrice() {
	      return price - (price * discount / 100);
	  }

	  public void displayProductDetails() {

		  if (this instanceof Product) {
	          System.out.println("Product ID: " + productID);
	          System.out.println("Product Name: " + productName);
	          System.out.println("Price: $" + price);
	          System.out.println("Quantity: " + quantity);
	          System.out.println("Discount: " + discount + "%");
	          System.out.println("Price after Discount: $" + getDiscountedPrice());
	      } else {
	          System.out.println("The object is not an instance of the Product class.");
	      }
	  }

	  public String getProductID() {
          return productID;
	  }
	  public String getProductName() {
	      return productName;
	  }
	  public void setProductName(String productName) {
	      this.productName = productName;
	  }
	  public double getPrice() {
	      return price;
      }
	  public void setPrice(double price) {
	      this.price = price;
	  }
	  public int getQuantity() {
	      return quantity;
	  }
	  public void setQuantity(int quantity) {
	      this.quantity = quantity;
	  }
}
