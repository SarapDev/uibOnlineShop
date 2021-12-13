package com.example.uibonlineshop.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uibonlineshop.ProductActivity;
import com.example.uibonlineshop.R;
import com.example.uibonlineshop.models.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private List<Product> products;

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        CardView card;
        EditText id;
        TextView infoText;
//        ImageView imageView;

        public ProductViewHolder(View view) {
            super(view);
            card = (CardView)view.findViewById(R.id.card_view);
            infoText = (TextView)view.findViewById(R.id.info_text);
            id = (EditText)view.findViewById(R.id.product_id);
//            imageView = (ImageView)view.findViewById(R.id.image_view);

            view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent i = new Intent(context, ProductActivity.class);
                    EditText productId = (EditText) v.findViewById(R.id.product_id);
                    String id = productId.getText().toString();
                    i.putExtra("product_id", id);
                    context.startActivity(i);
                }
            });
        }
    }

    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        ProductViewHolder pvh = new ProductViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        holder.id.setText(products.get(position).id);
        holder.infoText.setText(products.get(position).title);
//        holder.imageView.setImageResource(products.get(position).imageId);
    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
