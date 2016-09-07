package com.example.cristianvillamil.pruebaspatrones.productslist.presenter;

import com.example.cristianvillamil.pruebaspatrones.Objects.Product;
import com.example.cristianvillamil.pruebaspatrones.productslist.interactor.ProductsListInteractor;
import com.example.cristianvillamil.pruebaspatrones.productslist.interactor.ProductsListInteractorImpl;
import com.example.cristianvillamil.pruebaspatrones.productslist.view.ProductsList;

import java.util.List;

/**
 * Created by cristian.villamil on 06/09/2016.
 */
public class ProductsListPresenterImpl implements ProductsListPresenter,ProductsListInteractor.onFinishListener {
    private ProductsList view;
    private ProductsListInteractor interactor;

    public ProductsListPresenterImpl(ProductsList view) {
        this.view = view;
        this.interactor = new ProductsListInteractorImpl();
    }

    @Override
    public void getProducts() {
        interactor.getProductsData(this);
    }

    @Override
    public void onDestroy() {

    }


    @Override
    public void onFinish(List<Product> products) {
        view.showProductsList(products);
    }

    @Override
    public void onFailure(String message) {

    }
}
