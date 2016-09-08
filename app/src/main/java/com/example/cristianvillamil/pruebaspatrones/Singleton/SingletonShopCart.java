package com.example.cristianvillamil.pruebaspatrones.Singleton;

import com.example.cristianvillamil.pruebaspatrones.commons.domain.Product;

import java.util.ArrayList;
import java.util.Observable;

/**
 * @author cristian.villamil
 *         Class that represent purchased items in the current sesion
 */
public class SingletonShopCart extends Observable {
    private ArrayList<Product> selectedProducts;
    private static SingletonShopCart singletonShopCart;

    private SingletonShopCart() {
        selectedProducts = new ArrayList<>();
    }

    /**
     * Get the instance of shop cart
     *
     * @return instance of shop cart
     */
    public static SingletonShopCart getInstance() {
        if (singletonShopCart == null) {
            singletonShopCart = new SingletonShopCart();
        }
        return singletonShopCart;
    }

    /**
     * Add purchased item
     *
     * @param currentSelectedProduct purchased product
     */
    public void addShopItem(Product currentSelectedProduct) {
        if (selectedProducts.contains(currentSelectedProduct)) {
            currentSelectedProduct.addSelectedItem();
        } else {
            selectedProducts.add(currentSelectedProduct);
        }
        setChanged();
        notifyObservers();
    }

    /**
     * Drop a single shop item, if the product have 1 or more purchased products, the decrease the quantity,
     * when the product don't have more quantity objects, they auto delete them
     *
     * @param currentSelectedProduct product to decrease
     */
    public void deleteShopItem(Product currentSelectedProduct) {
        if (selectedProducts.contains(currentSelectedProduct)) {
            if (currentSelectedProduct.getQuantitySelectedItems() > 1) {
                currentSelectedProduct.deleteSelectedItem();
            } else {
                selectedProducts.remove(currentSelectedProduct);
            }
        }
        setChanged();
        notifyObservers();
    }


    /**
     * Get the current purchased producs
     *
     * @return current purchased products
     */
    public ArrayList<Product> getSelectedProducts() {
        return this.selectedProducts;
    }


    /**
     * Get all of selected items
     *
     * @return total quantity of selected products
     */
    public int getSelectedItems() {
        int allItems = 0;
        for (Product p : selectedProducts) {
            allItems += p.getQuantitySelectedItems();
        }
        return allItems;
    }

    /**
     * Get total price of current selected items
     *
     * @return total price
     */
    public double getTotalCostPurchasedItems() {
        float allPrice = 0;
        for (Product p : selectedProducts) {
            allPrice += p.getQuantitySelectedItems() * p.getProductPrice();
        }
        return allPrice;
    }
}
