package com.ahmetsudeys.fiyatdedektifi;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private ArrayList<Product> productList;  // ArrayList<String> yerine ArrayList<Product> kullanıyoruz
    private Context context;

    // Constructor
    public ProductAdapter(Context context, ArrayList<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // product_item layout dosyasını bağlar
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Her bir ürünü ViewHolder'a bağlar
        Product product = productList.get(position);  // Product modelini kullanıyoruz
        holder.productName.setText(product.getName()); // Ürün ismi
        holder.productPrice.setText(product.getPrice()); // Ürün fiyatı

        // Eski fiyat varsa göster, yoksa gizle
        if (product.getOldPrice() != null && !product.getOldPrice().isEmpty()) {
            holder.productOldPrice.setText(product.getOldPrice());
            holder.productOldPrice.setVisibility(View.VISIBLE);
            holder.productOldPrice.setPaintFlags(holder.productOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            holder.productOldPrice.setVisibility(View.GONE);
        }

        // Resmi Glide ile yükle
        Glide.with(context)
                .load(product.getImageUrl()) // Resim URL'sini kullanarak yükle
                .into(holder.productImage);  // Resmi holder'a bağla
    }

    @Override
    public int getItemCount() {
        return productList.size(); // Liste boyutunu döner
    }

    // ViewHolder: Ürünlerin görsel, isim ve fiyatını gösterecek
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView productImage;
        public TextView productName;
        public TextView productPrice;
        public TextView productOldPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);  // Ürün resmi
            productName = itemView.findViewById(R.id.productName);    // Ürün ismi
            productPrice = itemView.findViewById(R.id.productPrice);  // Ürün fiyatı
            productOldPrice = itemView.findViewById(R.id.productOldPrice);  // Eski fiyat
        }
    }
}
