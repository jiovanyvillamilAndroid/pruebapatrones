package com.example.cristianvillamil.pruebaspatrones.productdetail.interactor;

import com.example.cristianvillamil.pruebaspatrones.commons.domain.Product;

import java.util.List;

/**
 * Created by cristian.villamil on 14/09/2016.
 */
public interface ItemDetailInteractor {

    interface onFinishListener {

        void onFinish(Product product);

        void onFailure(String message);

    }

    void getItemDetail(int productId,final onFinishListener listener);

}
