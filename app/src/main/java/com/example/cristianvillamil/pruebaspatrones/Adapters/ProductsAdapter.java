package com.example.cristianvillamil.pruebaspatrones.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cristianvillamil.pruebaspatrones.activitycontainer.MainActivity;
import com.example.cristianvillamil.pruebaspatrones.Fragments.ItemDetailFragment;
import com.example.cristianvillamil.pruebaspatrones.commons.domain.Product;
import com.example.cristianvillamil.pruebaspatrones.R;

import java.util.List;

/**
 * @author Cristian.Villamil
 *         Adapter that represent available products to shop
 */
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {
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
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        ProductViewHolder pvh = new ProductViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        final Product currentProduct = data.get(position);
        holder.productTitle.setText(currentProduct.getProductName());
        holder.productTitle.setContentDescription(currentProduct.getProductName());
        if (currentProduct.isOnSale()) {
            holder.saleText.setVisibility(View.VISIBLE);
            holder.saleText.setContentDescription(currentProduct.getProductName() + " is on sale");
        } else {
            holder.saleText.setVisibility(View.INVISIBLE);
        }
        holder.price.setText("$" + currentProduct.getProductPrice());
        holder.price.setContentDescription("The price of " + currentProduct.getProductName() + " is " + currentProduct.getProductPrice());
        holder.stockItems.setText("" + currentProduct.getStockItems());
        holder.stockItems.setContentDescription("Are " + currentProduct.getStockItems() + " items in stock");
        holder.rating.setText("" + currentProduct.getProductRating());
        holder.rating.setContentDescription("The rating of " + currentProduct.getProductName() + " is " + currentProduct.getProductRating());
        holder.itemContainer.setContentDescription("Go to " + currentProduct.getProductName() + " detail");
        holder.itemContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onProductClick(currentProduct);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView productTitle;
        TextView saleText;
        ImageView photo;
        TextView price;
        TextView stockItems;
        TextView rating;
        View itemContainer;

        public ProductViewHolder(View itemView) {
            super(itemView);
            productTitle = (TextView) itemView.findViewById(R.id.productTitle);
            saleText = (TextView) itemView.findViewById(R.id.saleTextView);
            photo = (ImageView) itemView.findViewById(R.id.photo_item);
            price = (TextView) itemView.findViewById(R.id.productPrice);
            stockItems = (TextView) itemView.findViewById(R.id.stock_items_value);
            rating = (TextView) itemView.findViewById(R.id.rating_text);
            itemContainer = itemView;
        }
    }

    public void setListener(OnClickEvent listener){
        this.listener = listener;
    }

    public interface OnClickEvent{
        void onProductClick(Product product);
    }
}