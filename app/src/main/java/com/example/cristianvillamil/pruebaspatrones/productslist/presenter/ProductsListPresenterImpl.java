package com.example.cristianvillamil.pruebaspatrones.productslist.presenter;

import com.example.cristianvillamil.pruebaspatrones.commons.domain.Product;
import com.example.cristianvillamil.pruebaspatrones.productslist.interactor.ProductsListInteractor;
import com.example.cristianvillamil.pruebaspatrones.productslist.interactor.ProductsListInteractorImpl;
import com.example.cristianvillamil.pruebaspatrones.productslist.view.ProductListView;

import java.util.List;

/**
 * Created by cristian.villamil on 06/09/2016.
 */
public class ProductsListPresenterImpl implements ProductsListPresenter, ProductsListInteractor.onFinishListener {
    private ProductListView view;
    private ProductsListInteractor interactor;

    public ProductsListPresenterImpl(ProductListView view) {
        this.view = view;
        this.interactor = new ProductsListInteractorImpl();
    }

    @Override
    public void getProducts() {
        interactor.getProductsData(this);
    }


    @Override
    public void onFinish(List<Product> products) {
        view.productsLoaded(products);
    }

    @Override
    public void onFailure(String message) {
        view.showMessage(message);
    }
}
