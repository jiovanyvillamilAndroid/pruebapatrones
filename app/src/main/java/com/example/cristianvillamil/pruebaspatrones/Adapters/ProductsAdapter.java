package com.example.cristianvillamil.pruebaspatrones.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        return new ProductViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        holder.bind(data.get(position));
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

        public ProductViewHolder (ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false));
            productTitle = (TextView) itemView.findViewById(R.id.productTitle);
            saleText = (TextView) itemView.findViewById(R.id.saleTextView);
            photo = (ImageView) itemView.findViewById(R.id.photo_item);
            price = (TextView) itemView.findViewById(R.id.productPrice);
            stockItems = (TextView) itemView.findViewById(R.id.stock_items_value);
            rating = (TextView) itemView.findViewById(R.id.rating_text);
            itemContainer = itemView;
        }

        public void bind (final Product currentProduct) {
            productTitle.setText(currentProduct.getProductName());
            productTitle.setContentDescription(currentProduct.getProductName());
            if (currentProduct.isOnSale()) {
                saleText.setVisibility(View.VISIBLE);
                saleText.setContentDescription(currentProduct.getProductName() + " is on sale");
            } else {
                saleText.setVisibility(View.INVISIBLE);
            }
            price.setText("$" + currentProduct.getProductPrice());
            price.setContentDescription("The price of " + currentProduct.getProductName() + " is " + currentProduct.getProductPrice());
            stockItems.setText("" + currentProduct.getStockItems());
            stockItems.setContentDescription("Are " + currentProduct.getStockItems() + " items in stock");
            rating.setText(String.valueOf(currentProduct.getProductRating()));
            rating.setContentDescription("The rating of " + currentProduct.getProductName() + " is " + currentProduct.getProductRating());
            itemContainer.setContentDescription("Go to " + currentProduct.getProductName() + " detail");
            itemContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onProductClick(currentProduct);
                    }
                }
            });
        }

    }

    public void setListener(OnClickEvent listener){
        this.listener = listener;
    }

    public interface OnClickEvent{
        void onProductClick(Product product);
    }
}