package com.example.cristianvillamil.pruebaspatrones.productslist.view;

import com.example.cristianvillamil.pruebaspatrones.commons.domain.Product;

import java.util.List;

/**
 * Created by cristian.villamil on 06/09/2016.
 */
public interface ProductListView {

    void productsLoaded(List<Product> productList);

    void showMessage(String m);

}
