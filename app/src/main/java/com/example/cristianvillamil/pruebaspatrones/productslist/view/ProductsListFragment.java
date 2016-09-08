package com.example.cristianvillamil.pruebaspatrones.productslist.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cristianvillamil.pruebaspatrones.Adapters.ProductsAdapter;
import com.example.cristianvillamil.pruebaspatrones.Fragments.ItemDetailFragment;
import com.example.cristianvillamil.pruebaspatrones.commons.domain.Product;
import com.example.cristianvillamil.pruebaspatrones.R;
import com.example.cristianvillamil.pruebaspatrones.commons.interfaces.TransactionFragments;
import com.example.cristianvillamil.pruebaspatrones.productslist.presenter.ProductsListPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristian.villamil on 06/09/2016.
 */
public class ProductsListFragment extends Fragment implements ProductsList{

    RecyclerView recyclerView;
    ProductsListPresenterImpl presenter;
    ProductsAdapter adapter;
    TransactionFragments transactionFragments;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = getLayoutInflater(savedInstanceState).inflate(R.layout.fragment_item_list, container, false);
        getUIElements(v);
        presenter = new ProductsListPresenterImpl(this);
        presenter.getProducts();
        return v;
    }

    public void addTransactionInterface(TransactionFragments transactionFragments) {
        this.transactionFragments = transactionFragments;
    }

    private void initializeRecyclerView(List<Product> products){
        adapter = new ProductsAdapter(products);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
        addProductAdapterClickEvent();
    }

    private void addProductAdapterClickEvent(){
        adapter.setListener(new ProductsAdapter.OnClickEvent() {
            @Override
            public void onProductClick(Product product) {
                ItemDetailFragment itemDetailFragment = new ItemDetailFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("product", product);
                itemDetailFragment.setArguments(bundle);
                transactionFragments.switchFragment(itemDetailFragment,true);
            }
        });
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showProductsList(List<Product> productList) {
        initializeRecyclerView(productList);
    }


    @Override
    public void showMessage(String m) {
        new AlertDialog.Builder(getContext())
                .setMessage(m)
                .setNeutralButton("Ok",null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    @Override
    public void getUIElements(@Nullable View v) {
        if (v != null) {
            recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_products);
        }
    }

    @Override
    public void setEventsLogics() {

    }
}
