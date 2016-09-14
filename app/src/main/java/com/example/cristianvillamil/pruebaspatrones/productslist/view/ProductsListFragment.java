package com.example.cristianvillamil.pruebaspatrones.productslist.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cristianvillamil.pruebaspatrones.R;
import com.example.cristianvillamil.pruebaspatrones.commons.activities.BaseFragment;
import com.example.cristianvillamil.pruebaspatrones.commons.adapters.ProductsAdapter;
import com.example.cristianvillamil.pruebaspatrones.commons.domain.Product;
import com.example.cristianvillamil.pruebaspatrones.commons.interfaces.TransactionFragments;
import com.example.cristianvillamil.pruebaspatrones.productdetail.view.ItemDetailFragment;
import com.example.cristianvillamil.pruebaspatrones.productslist.presenter.ProductsListPresenterImpl;

import java.util.List;

/**
 * Created by cristian.villamil on 06/09/2016.
 */
public class ProductsListFragment extends BaseFragment implements ProductListView {

    RecyclerView recyclerView;
    ProductsListPresenterImpl presenter;
    ProductsAdapter adapter;
    TransactionFragments transactionFragments;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater(savedInstanceState).inflate(R.layout.fragment_item_list, container, false);
        presenter = new ProductsListPresenterImpl(this);
        presenter.getProducts();
        initUI(view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TransactionFragments) {
            this.addTransactionInterface((TransactionFragments) context);
        } else {
            throw new RuntimeException("The context is invalid");
        }
    }

    public void addTransactionInterface(TransactionFragments transactionFragments) {
        this.transactionFragments = transactionFragments;
    }

    private void initializeRecyclerView(List<Product> products) {
        adapter = new ProductsAdapter(products);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
        addProductAdapterClickEvent();
    }

    private void addProductAdapterClickEvent() {
        adapter.setListener(new ProductsAdapter.OnClickEvent() {
            @Override
            public void onProductClick(Product product) {
                ItemDetailFragment itemDetailFragment = new ItemDetailFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("product", product);
                itemDetailFragment.setArguments(bundle);
                transactionFragments.switchFragment(itemDetailFragment, true);
            }
        });
    }

    @Override
    public void productsLoaded(List<Product> productList) {
        initializeRecyclerView(productList);
    }


    @Override
    public void showMessage(String m) {
        new AlertDialog.Builder(getContext())
                .setMessage(m)
                .setNeutralButton("Ok", null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


    @Override
    public void initUI(View view) {
        if(view != null){
            recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_products);
        }
    }
}
