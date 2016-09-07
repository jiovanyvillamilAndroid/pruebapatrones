package com.example.cristianvillamil.pruebaspatrones.productslist.interactor;

import com.example.cristianvillamil.pruebaspatrones.Objects.Product;

import java.util.ArrayList;

/**
 * Created by cristian.villamil on 06/09/2016.
 */
public class ProductsListInteractorImpl implements ProductsListInteractor{

    @Override
    public void getProductsData(onFinishListener listener) {
        ArrayList<Product> productsList = new ArrayList<>();
        for (int i=0;i<100;i++){
            Product p = new Product.ProductBuilder()
                    .onSale(false)
                    .productDescription("Description "+i)
                    .build();
            productsList.add(p);
        }
        listener.onFinish(productsList);
    }
}
