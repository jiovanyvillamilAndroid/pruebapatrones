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

import com.example.cristianvillamil.pruebaspatrones.Activities.MainActivity;
import com.example.cristianvillamil.pruebaspatrones.Fragments.ItemDetailFragment;
import com.example.cristianvillamil.pruebaspatrones.Objects.Product;
import com.example.cristianvillamil.pruebaspatrones.R;
import com.example.cristianvillamil.pruebaspatrones.Singleton.SingletonShopCart;

import java.util.ArrayList;

/**
 * @author Cristian.Villamil
 *         Adapter that represent available products to shop
 */
public class RecyclerViewProducts extends RecyclerView.Adapter<RecyclerViewProducts.ProductViewHolder> {
    ArrayList<Product> data;
    Context context;

    public RecyclerViewProducts(ArrayList<Product> data, Context context) {
        this.data = data;
        this.context = context;
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
                ItemDetailFragment itemDetailFragment = new ItemDetailFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("product", currentProduct);
                itemDetailFragment.setArguments(bundle);
                switchFragment(itemDetailFragment);
            }
        });
    }

    /**
     * Switch the fragments on MainActivity
     *
     * @param newFragment fragment to be changed
     */
    private void switchFragment(Fragment newFragment) {
        if (context == null)
            return;
        if (context instanceof MainActivity) {
            MainActivity mainActivity = (MainActivity) context;
            mainActivity.changeFragment(newFragment, true);
        }
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
}