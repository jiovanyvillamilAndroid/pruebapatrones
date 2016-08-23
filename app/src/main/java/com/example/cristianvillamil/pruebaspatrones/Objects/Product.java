package com.example.cristianvillamil.pruebaspatrones.Objects;

import java.io.Serializable;

/**
 * @author cristian.villamil
 * This class represent Product abstraction
 */
public class Product implements Serializable{
    private int productId;
    private String productName;
    private double productPrice;
    private String productImage;
    private String productDescription;
    private int productRating;
    private boolean onSale;
    private int stockItems;
    private int quantitySelectedItems;

    public Product(int productId, String productName, double productPrice, String productImage, String productDescription, int productRating, boolean onSale, int stockItems) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productDescription = productDescription;
        this.productRating = productRating;
        this.onSale = onSale;
        this.stockItems = stockItems;
        quantitySelectedItems = 1;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductRating() {
        return productRating;
    }

    public void setProductRating(int productRating) {
        this.productRating = productRating;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public int getStockItems() {
        return stockItems;
    }

    public void setStockItems(int stockItems) {
        this.stockItems = stockItems;
    }

    public int getQuantitySelectedItems() {
        return quantitySelectedItems;
    }

    public void setQuantitySelectedItems(int quantitySelectedItems) {
        this.quantitySelectedItems = quantitySelectedItems;
    }

    /**
     * increase quantity of selected items
     */
    public void addSelectedItem(){
        this.quantitySelectedItems++;
    }

    /**
     * decrease quantity of selected items
     */
    public void deleteSelectedItem(){
        this.quantitySelectedItems--;
    }
}
