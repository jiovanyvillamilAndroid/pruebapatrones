package com.example.cristianvillamil.pruebaspatrones.productdetail.presenter;

import com.example.cristianvillamil.pruebaspatrones.commons.domain.Product;
import com.example.cristianvillamil.pruebaspatrones.productdetail.interactor.ItemDetailInteractor;

import java.util.List;

/**
 * Created by cristian.villamil on 14/09/2016.
 */
public class ItemDetailPresenterImpl implements ItemDetailPresenter,ItemDetailInteractor.onFinishListener {

    @Override
    public void getItemDetail() {

    }

    @Override
    public void onFinish(Product product) {

    }

    @Override
    public void onFailure(String message) {

    }
}
