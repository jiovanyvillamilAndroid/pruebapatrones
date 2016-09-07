package com.example.cristianvillamil.pruebaspatrones.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.cristianvillamil.pruebaspatrones.R;
import com.example.cristianvillamil.pruebaspatrones.Singleton.SingletonShopCart;
import com.example.cristianvillamil.pruebaspatrones.commons.interfaces.BaseActivity;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by cristian.villamil on 06/09/2016.
 */

//MainActivity
public class MainViewImpl extends AppCompatActivity implements BaseActivity, Observer {

    private RecyclerView recyclerViewItems;
    private ProgressBar progressBar;
    private TextView badgeShopProducts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getUIElements();
        setClickLogics();
        addObserver();
        // TODO: 06/09/2016
    }

    private void switchFragment(Fragment fragment) {

    }

    private void updateBadge(int number) {
        // TODO: 06/09/2016
    }

    private void addObserver() {
        SingletonShopCart.getInstance().addObserver(this);
    }


    @Override
    public void getUIElements() {
        badgeShopProducts = (TextView) findViewById(R.id.count_selected_products);
    }

    @Override
    public void setClickLogics() {

    }


    @Override
    public void update(Observable observable, Object o) {
        SingletonShopCart singletonUpdated = (SingletonShopCart) observable;
        updateBadge(singletonUpdated.getSelectedItems());
    }
}
