package com.example.cristianvillamil.pruebaspatrones.productslist.view;

import com.example.cristianvillamil.pruebaspatrones.commons.domain.Product;
import com.example.cristianvillamil.pruebaspatrones.commons.interfaces.BaseActivity;

import java.util.List;

/**
 * Created by cristian.villamil on 06/09/2016.
 */
public interface ProductsList extends BaseActivity {

    void showProgress();

    void hideProgress();

    void showProductsList(List<Product> productList);

    void showMessage(String m);

}
