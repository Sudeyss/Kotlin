package com.ahmetsudeys.fiyatdedektifi;

public class Product {
    private String name;
    private String price;
    private String imageUrl;
    private String oldPrice;  // Yeni alan eklendi

    public Product(String name, String price, String imageUrl, String oldPrice) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.oldPrice = oldPrice;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getOldPrice() {return oldPrice; }  // Getter metodu
}

