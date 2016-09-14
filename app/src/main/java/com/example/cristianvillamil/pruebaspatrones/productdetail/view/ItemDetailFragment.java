package com.example.cristianvillamil.pruebaspatrones.productdetail.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cristianvillamil.pruebaspatrones.R;
import com.example.cristianvillamil.pruebaspatrones.Singleton.SingletonShopCart;
import com.example.cristianvillamil.pruebaspatrones.commons.activities.BaseFragment;
import com.example.cristianvillamil.pruebaspatrones.commons.domain.Product;

/**
 * Created by Jiovany on 16/08/2016.
 */
public class ItemDetailFragment extends BaseFragment implements ItemDetail {

    Product currentProduct;
    TextView productTitle;
    TextView isSaleTextView;
    TextView itemPrice;
    TextView selectedProducts;
    TextView stockItemsTextView;
    TextView description;
    Button buyItem;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = getLayoutInflater(savedInstanceState).inflate(R.layout.item_detail_fragment, container, false);
        currentProduct = (Product) getArguments().get("product");
        initUI(v);
        setEventsLogics();
        showDetail();
        return v;
    }


    @Override
    public void showDetail() {
        buyItem.setContentDescription("Purchase one " + currentProduct.getProductName());
        productTitle.setText(currentProduct.getProductName());
        productTitle.setContentDescription(currentProduct.getProductName());
        isSaleTextView.setContentDescription("Is on sale");
        if (currentProduct.isOnSale()) isSaleTextView.setVisibility(View.VISIBLE);
        itemPrice.setText("$" + currentProduct.getProductPrice());
        itemPrice.setContentDescription("The price of " + currentProduct.getProductName() + " is " + currentProduct.getProductPrice());
        selectedProducts.setText(currentProduct.getQuantitySelectedItems() + "");
        selectedProducts.setContentDescription("You have " + currentProduct.getQuantitySelectedItems() + " of this product in shopping cart");
        stockItemsTextView.setText(currentProduct.getStockItems() + "");
        stockItemsTextView.setContentDescription("There are " + currentProduct.getStockItems() + " available");
        description.setText(currentProduct.getProductDescription());
        description.setContentDescription(currentProduct.getProductDescription());
    }

    @Override
    public void initUI(@Nullable View view) {
        if (view != null) {
            productTitle = (TextView) view.findViewById(R.id.product_title);
            isSaleTextView = (TextView) view.findViewById(R.id.is_sale_text);
            itemPrice = (TextView) view.findViewById(R.id.item_price);
            selectedProducts = (TextView) view.findViewById(R.id.count_selected_products);
            stockItemsTextView = (TextView) view.findViewById(R.id.stock_items_value);
            description = (TextView) view.findViewById(R.id.description);
            buyItem = (Button) view.findViewById(R.id.buy_item_button);
        }
    }

    public void setEventsLogics() {
        buyItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SingletonShopCart.getInstance().addShopItem(currentProduct);
            }
        });
    }
}
