package com.example.cristianvillamil.pruebaspatrones.commons.domain;

import java.io.Serializable;

/**
 * @author cristian.villamil
 *         This class represent Product abstraction
 */
public class Product implements Serializable {
    private final int productId;
    private final String productName;
    private final double productPrice;
    private final String productImage;
    private final String productDescription;
    private final int productRating;
    private final boolean onSale;
    private int stockItems;
    private int quantitySelectedItems;

    private Product(ProductBuilder builder) {
        this.productId = builder.productId;
        this.productName = builder.productName;
        this.productPrice = builder.productPrice;
        this.productImage = builder.productImage;
        this.productDescription = builder.productDescription;
        this.productRating = builder.productRating;
        this.onSale = builder.onSale;
        this.stockItems = builder.stockItems;
        this.quantitySelectedItems = builder.quantitySelectedItems;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public int getProductRating() {
        return productRating;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public int getStockItems() {
        return stockItems;
    }

    public int getQuantitySelectedItems() {
        return quantitySelectedItems;
    }

    /**
     * increase quantity of selected items
     */
    public void addSelectedItem() {
        this.quantitySelectedItems++;
    }

    /**
     * decrease quantity of selected items
     */
    public void deleteSelectedItem() {
        this.quantitySelectedItems--;
    }


    public static class ProductBuilder {
        private int productId;
        private String productName;
        private double productPrice;
        private String productImage;
        private String productDescription;
        private int productRating;
        private boolean onSale;
        private int stockItems;
        private int quantitySelectedItems;

        public ProductBuilder productId(int productId) {
            this.productId = productId;
            return this;
        }

        public ProductBuilder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public ProductBuilder productPrice(double productPrice) {
            this.productPrice = productPrice;
            return this;
        }

        public ProductBuilder productImage(String productImage) {
            this.productImage = productImage;
            return this;
        }

        public ProductBuilder productDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;
        }

        public ProductBuilder productRating(int productRating) {
            this.productRating = productRating;
            return this;
        }

        public ProductBuilder onSale(boolean onSale) {
            this.onSale = onSale;
            return this;
        }

        public ProductBuilder stockItems(int stockItems) {
            this.stockItems = stockItems;
            return this;
        }

        public ProductBuilder quantitySelectedItems(int quantitySelectedItems) {
            this.quantitySelectedItems = quantitySelectedItems;
            return this;
        }

        public Product build() {
            Product user = new Product(this);
            return user;
        }

    }
}
