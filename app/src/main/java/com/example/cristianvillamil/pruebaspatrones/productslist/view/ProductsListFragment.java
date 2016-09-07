package com.example.cristianvillamil.pruebaspatrones.productslist.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cristianvillamil.pruebaspatrones.Objects.Product;

import java.util.List;

/**
 * Created by cristian.villamil on 06/09/2016.
 */
public class ProductsListFragment extends Fragment implements ProductsList{



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showProductsList(List<Product> productList) {

    }


    @Override
    public void showMessage() {

    }

    @Override
    public void getUIElements() {

    }

    @Override
    public void setClickLogics() {

    }
}
