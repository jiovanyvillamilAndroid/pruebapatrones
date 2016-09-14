package com.example.cristianvillamil.pruebaspatrones.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cristianvillamil.pruebaspatrones.R;
import com.example.cristianvillamil.pruebaspatrones.commons.adapters.ProductsAdapter;
import com.example.cristianvillamil.pruebaspatrones.commons.domain.Product;

import java.util.ArrayList;

public class ItemListFragment extends Fragment {
    Context context = null;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = getLayoutInflater(savedInstanceState).inflate(R.layout.fragment_item_list, container, false);
        RecyclerView productsRecycler = (RecyclerView) v.findViewById(R.id.recycler_view_products);
        ProductsAdapter adapter = new ProductsAdapter(getData());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        productsRecycler.setLayoutManager(mLayoutManager);
        productsRecycler.setAdapter(adapter);
        return v;
    }

    /**
     * Get data to show in fragment
     *
     * @return list of products
     */
    private ArrayList<Product> getData() {
        ArrayList<Product> data = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            //Product dummy = new Product(i,"name "+i,i*1000,"https://unsplash.it/300/300/?random","Una descripción larga",i,true,i*200);
            Product dummy = new Product.ProductBuilder()
                    .onSale(true)
                    .productId(i)
                    .productName("Name " + i)
                    .productPrice(i * 1000)
                    .productImage("https://unsplash.it/300/300/?random")
                    .productDescription("Una descripción")
                    .productRating(4)
                    .stockItems(20)
                    .quantitySelectedItems(1)
                    .build();
            data.add(dummy);
        }
        return data;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        this.context = null;
    }

}
