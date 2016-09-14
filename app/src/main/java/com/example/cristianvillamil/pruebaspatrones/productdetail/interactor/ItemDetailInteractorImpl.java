package com.example.cristianvillamil.pruebaspatrones.productdetail.interactor;

import com.example.cristianvillamil.pruebaspatrones.commons.domain.Product;

/**
 * Created by cristian.villamil on 14/09/2016.
 */
public class ItemDetailInteractorImpl implements ItemDetailInteractor {
    @Override
    public void getItemDetail(int productId,onFinishListener listener) {
        Product product = new Product.ProductBuilder()
                .productId(productId)
                .productDescription("Long description")
                .productImage("")
                .productName("Name product detail")
                .productPrice(1234567)
                .productRating(3)
                .onSale(false)
                .quantitySelectedItems(0)
                .stockItems(12)
                .build();
        listener.onFinish(product);
    }
}
