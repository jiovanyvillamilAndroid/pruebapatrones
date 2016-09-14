package com.example.cristianvillamil.pruebaspatrones.productslist.interactor;

import com.example.cristianvillamil.pruebaspatrones.commons.domain.Product;

import java.util.ArrayList;

/**
 * Created by cristian.villamil on 06/09/2016.
 */
public class ProductsListInteractorImpl implements ProductsListInteractor {

    @Override
    public void getProductsData(onFinishListener listener) {
        ArrayList<Product> productsList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Product p = new Product.ProductBuilder()
                    .onSale((i & 1) == 0)
                    .productId(i)
                    .productName("Name " + i)
                    .productRating(5)
                    .stockItems(20)
                    .productPrice(i * 200)
                    .productDescription("Description " + i)
                    .build();
            productsList.add(p);
        }
        listener.onFinish(productsList);
    }
}
