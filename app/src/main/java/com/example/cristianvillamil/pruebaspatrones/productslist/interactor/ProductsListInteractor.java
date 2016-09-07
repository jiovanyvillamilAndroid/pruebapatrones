package com.example.cristianvillamil.pruebaspatrones.productslist.interactor;

import com.example.cristianvillamil.pruebaspatrones.Objects.Product;

import java.util.List;

/**
 * Created by cristian.villamil on 06/09/2016.
 */
public interface ProductsListInteractor {

    interface onFinishListener{
        void onFinish(List<Product> products);
        void onFailure(String message);
    }

    void getProductsData(final onFinishListener listener);
}
