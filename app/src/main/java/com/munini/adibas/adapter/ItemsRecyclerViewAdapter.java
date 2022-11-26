package com.munini.adibas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.munini.adibas.R;
import com.munini.adibas.model.StockItem;

import java.util.List;

public class ItemsRecyclerViewAdapter extends RecyclerView.Adapter<ItemsRecyclerViewAdapter.ViewHolder>{

    private Context context;
    private List<StockItem> stockItemList;

    public ItemsRecyclerViewAdapter(Context context, List<StockItem> stockItemList) {
        this.context = context;
        this.stockItemList = stockItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stock_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StockItem stockItem = stockItemList.get(position);
        holder.itemNameTextView.setText(stockItem.getTitle());
        holder.categoryNameTextView.setText(stockItem.getCategoryName());
        holder.itemImageView.setImageDrawable(ContextCompat.getDrawable(context, stockItem.getCoverImageDrawableId()));
    }

    @Override
    public int getItemCount() {
        return stockItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView itemImageView;
        public final TextView categoryNameTextView;
        public final TextView itemNameTextView;
        public final View buyActionView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImageView = itemView.findViewById(R.id.stock_item_image_view);
            categoryNameTextView = itemView.findViewById(R.id.stock_item_category_view);
            itemNameTextView = itemView.findViewById(R.id.stock_item_title_view);

            this.buyActionView = itemView.findViewById(R.id.stock_item_buy_view);

            this.buyActionView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"Processing payment... please wait", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
