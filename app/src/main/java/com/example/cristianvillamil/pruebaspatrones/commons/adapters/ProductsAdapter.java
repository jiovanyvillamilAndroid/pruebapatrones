package com.example.cristianvillamil.pruebaspatrones.commons.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.cristianvillamil.pruebaspatrones.commons.domain.Product;

import java.util.List;

/**
 * @author Cristian.Villamil
 *         Adapter that represent available products to shop
 */
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapterViewHolder> {

    List<Product> data;
    OnClickEvent listener;

    public ProductsAdapter(List<Product> data) {
        this.data = data;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ProductsAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductsAdapterViewHolder(parent, listener);
    }

    @Override
    public void onBindViewHolder(final ProductsAdapterViewHolder holder, int position) {
        holder.bind(data.get(position));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public void setListener(OnClickEvent listener) {
        this.listener = listener;
    }

    public interface OnClickEvent {
        void onProductClick(Product product);
    }
}