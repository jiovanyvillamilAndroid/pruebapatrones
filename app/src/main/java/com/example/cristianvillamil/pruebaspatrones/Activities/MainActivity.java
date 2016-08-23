package com.example.cristianvillamil.pruebaspatrones.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cristianvillamil.pruebaspatrones.Fragments.ItemListFragment;
import com.example.cristianvillamil.pruebaspatrones.R;
import com.example.cristianvillamil.pruebaspatrones.Singleton.SingletonShopCart;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {
    TextView badgeShopProducts;
    SingletonShopCart singletonShopCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        badgeShopProducts = (TextView)findViewById(R.id.count_selected_products);
        singletonShopCart = SingletonShopCart.getInstance();
        singletonShopCart.addObserver(MainActivity.this);
        setCartButtonLogic();
        changeFragment(new ItemListFragment(),false);
        onNewIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String action = intent.getAction();
        String data = intent.getDataString();
        if (Intent.ACTION_VIEW.equals(action) && data != null) {
            Log.d("Entro al intent",data);
        }
    }

    /**
     * Create the logic of the shopping cart
     */
    public void setCartButtonLogic(){
        FrameLayout cartContentToolbar = (FrameLayout)findViewById(R.id.cart_content);
        cartContentToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(singletonShopCart.getSelectedItems()>0){
                    Intent i = new Intent(MainActivity.this,ShopCartActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"No purchased items",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * Change fragments inside MainActivity dynamically
     * @param f Fragment that are going to be change
     * @param addToBackStack true to add to backstack otherwise false
     */
    public void changeFragment(Fragment f,boolean addToBackStack){
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, f);
        if(addToBackStack)fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        changeCountItemsToolbar(singletonShopCart.getSelectedItems());
    }

    /**
     * change the toolbar item counter
     * @param productsSize cantidad de productos
     */
    private void changeCountItemsToolbar(int productsSize){
        if(productsSize>99){
            badgeShopProducts.setText("99");
        }else{
            badgeShopProducts.setText(""+productsSize);
        }
        badgeShopProducts.setContentDescription("You have "+productsSize+" items in shopping cart");
    }

    /**
     * Event of any change to observable object
     * @param observable object that we are observing
     * @param o object with parameters
     */
    @Override
    public void update(Observable observable, Object o) {
        SingletonShopCart singletonUpdated = (SingletonShopCart)observable;
        changeCountItemsToolbar(singletonUpdated.getSelectedItems());
    }
}
