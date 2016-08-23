package com.example.cristianvillamil.pruebaspatrones.Activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.cristianvillamil.pruebaspatrones.Adapters.RecyclerViewSelectedProducts;
import com.example.cristianvillamil.pruebaspatrones.R;
import com.example.cristianvillamil.pruebaspatrones.Singleton.SingletonShopCart;

import java.util.Observable;
import java.util.Observer;

public class ShopCartActivity extends AppCompatActivity implements Observer{
    TextView totalQuantity;
    TextView totalPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_cart);
        totalQuantity = (TextView)findViewById(R.id.total_quantity);
        totalPrice = (TextView)findViewById(R.id.total_price);
        configurateToolbar();
        checkSelectedProducts();
        SingletonShopCart.getInstance().addObserver(ShopCartActivity.this);
    }
    /**
     * check if the user have purchased items
     */
    private void checkSelectedProducts(){
        if(SingletonShopCart.getInstance().getSelectedProducts().size()>0){
            makeRecyclerView();
            showResumedInfo();
        }else{
            Toast.makeText(this,"No purchased items",Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Config toolbar title and back event
     */
    private void configurateToolbar(){
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle("Puerchased Items");
        supportActionBar.setHomeButtonEnabled(true);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
    }

    /**
     * Make the Recyclerview to show purchased items
     */
    private void makeRecyclerView(){
        RecyclerView listSelectedItems = (RecyclerView)findViewById(R.id.list_selected_items);
        RecyclerViewSelectedProducts recyclerViewSelectedProducts = new RecyclerViewSelectedProducts(SingletonShopCart.getInstance().getSelectedProducts(),this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        listSelectedItems.setAdapter(recyclerViewSelectedProducts);
        listSelectedItems.setLayoutManager(layoutManager);
    }

    /**
     * Show total price and total quantity in the current sesion
     */
    private void showResumedInfo(){
        SingletonShopCart singletonShopCart = SingletonShopCart.getInstance();
        totalQuantity.setText(singletonShopCart.getSelectedItems()+"");
        totalPrice.setText(singletonShopCart.getTotalCostPurchasedItems()+"");
    }

    @Override
    public void update(Observable observable, Object o) {
        showResumedInfo();
        if(SingletonShopCart.getInstance().getSelectedItems()==0){
            Toast.makeText(this,"No more purchased items",Toast.LENGTH_LONG).show();
            finish();
        }
    }
}
