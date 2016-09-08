package com.example.cristianvillamil.pruebaspatrones.Fragments;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cristianvillamil.pruebaspatrones.commons.domain.Product;
import com.example.cristianvillamil.pruebaspatrones.R;
import com.example.cristianvillamil.pruebaspatrones.Singleton.SingletonShopCart;

/**
 * Created by Jiovany on 16/08/2016.
 */
public class ItemDetailFragment extends Fragment {
    Context context;
    Product currentProduct;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = getLayoutInflater(savedInstanceState).inflate(R.layout.item_detail_fragment, container, false);
        currentProduct = (Product) getArguments().get("product");
        renderView(v);
        return v;
    }

    /**
     * Put the data inside layout widgets
     *
     * @param v view contains widgets
     */
    private void renderView(View v) {
        TextView productTitle = (TextView) v.findViewById(R.id.product_title);
        productTitle.setText(currentProduct.getProductName());
        productTitle.setContentDescription(currentProduct.getProductName());
        TextView isSaleTextView = (TextView) v.findViewById(R.id.is_sale_text);
        isSaleTextView.setContentDescription("Is on sale");
        if (currentProduct.isOnSale()) isSaleTextView.setVisibility(View.VISIBLE);
        TextView itemPrice = (TextView) v.findViewById(R.id.item_price);
        itemPrice.setText("$" + currentProduct.getProductPrice());
        itemPrice.setContentDescription("The price of " + currentProduct.getProductName() + " is " + currentProduct.getProductPrice());
        TextView selectedProducts = (TextView) v.findViewById(R.id.count_selected_products);
        selectedProducts.setText(currentProduct.getQuantitySelectedItems() + "");
        selectedProducts.setContentDescription("You have " + currentProduct.getQuantitySelectedItems() + " of this product in shopping cart");
        TextView stockItemsTextView = (TextView) v.findViewById(R.id.stock_items_value);
        stockItemsTextView.setText(currentProduct.getStockItems() + "");
        stockItemsTextView.setContentDescription("There are " + currentProduct.getStockItems() + " available");
        TextView description = (TextView) v.findViewById(R.id.description);
        description.setText(currentProduct.getProductDescription());
        description.setContentDescription(currentProduct.getProductDescription());
        buyItemLogic(v);
    }

    /**
     * Makes buy button logic
     *
     * @param v view constains widgets
     */
    private void buyItemLogic(View v) {
        Button buyItem = (Button) v.findViewById(R.id.buy_item_button);
        buyItem.setContentDescription("Purchase one " + currentProduct.getProductName());
        buyItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SingletonShopCart.getInstance().addShopItem(currentProduct);
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.context = null;
    }
}
