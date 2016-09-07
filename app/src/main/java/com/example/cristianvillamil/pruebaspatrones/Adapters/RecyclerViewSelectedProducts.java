package com.example.cristianvillamil.pruebaspatrones.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cristianvillamil.pruebaspatrones.Objects.Product;
import com.example.cristianvillamil.pruebaspatrones.R;
import com.example.cristianvillamil.pruebaspatrones.Singleton.SingletonShopCart;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author cristian.villamil
 *         Adapter that represent purchased items
 */
public class RecyclerViewSelectedProducts extends RecyclerView.Adapter<RecyclerViewSelectedProducts.SelectedProductViewHolder> {
    ArrayList<Product> data;
    Context context;

    public RecyclerViewSelectedProducts(ArrayList<Product> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public SelectedProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.selected_item, parent, false);
        SelectedProductViewHolder pvh = new SelectedProductViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final SelectedProductViewHolder holder, final int position) {
        final Product currentProduct = data.get(position);
        holder.productTitle.setText(currentProduct.getProductName());
        holder.productTitle.setContentDescription(currentProduct.getProductName());
        holder.price.setText("$" + currentProduct.getProductPrice());
        holder.price.setContentDescription("The price of " + currentProduct.getProductName() + " is " + currentProduct.getProductPrice());
        holder.itemQuantity.setText("" + currentProduct.getQuantitySelectedItems());
        holder.itemQuantity.setContentDescription("The quantity is " + currentProduct.getQuantitySelectedItems());
        holder.skipProduct.setContentDescription("Delete 1 quantity of this item");
        holder.skipProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SingletonShopCart.getInstance().deleteShopItem(currentProduct);
                notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class SelectedProductViewHolder extends RecyclerView.ViewHolder {
        TextView productTitle;
        ImageView photo;
        TextView price;
        TextView itemQuantity;
        Button skipProduct;

        public SelectedProductViewHolder(View itemView) {
            super(itemView);
            productTitle = (TextView) itemView.findViewById(R.id.item_name);
            itemQuantity = (TextView) itemView.findViewById(R.id.item_quantity);
            photo = (ImageView) itemView.findViewById(R.id.product_photo);
            price = (TextView) itemView.findViewById(R.id.item_price);
            skipProduct = (Button) itemView.findViewById(R.id.skip_product);
        }
    }
}
