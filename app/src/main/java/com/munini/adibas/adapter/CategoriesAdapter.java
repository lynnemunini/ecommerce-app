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
import com.munini.adibas.model.ItemCategory;

import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private Context context;
    private List<ItemCategory> itemCategoryList;
    private OnCategoryClickedListener categoryClickedListener;

    public CategoriesAdapter(Context context, List<ItemCategory> itemCategoryList, OnCategoryClickedListener categoryClickedListener) {
        this.context = context;
        this.itemCategoryList = itemCategoryList;
        this.categoryClickedListener = categoryClickedListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryitemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_layout, parent, false);
        return new ViewHolder(categoryitemView, categoryClickedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemCategory category = itemCategoryList.get(position);
        holder.circleImageView.setImageDrawable(ContextCompat.getDrawable(context, category.getCoverImageDrawableId()));
        holder.categoryNameTextView.setText(category.getTitle());
        holder.numberOfItemsTextView.setText(String.format(Locale.getDefault(),"%d Items", category.getItems()));
        holder.showCaseImage1.setImageDrawable(ContextCompat.getDrawable(context, category.getShowCaseImage1DrawableId()));
        holder.showCaseImage2.setImageDrawable(ContextCompat.getDrawable(context, category.getShowCaseImage2DrawableId()));
        holder.showCaseImage3.setImageDrawable(ContextCompat.getDrawable(context, category.getShowCaseImage3DrawableId()));
    }

    @Override
    public int getItemCount() {
        return itemCategoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private OnCategoryClickedListener categoryClickedListener;
        public final View containerView;
        public final CircleImageView circleImageView;
        public final TextView categoryNameTextView;
        public final TextView numberOfItemsTextView;
        public final ImageView showCaseImage1;
        public final ImageView showCaseImage2;
        public final ImageView showCaseImage3;

        public ViewHolder(@NonNull View itemView, OnCategoryClickedListener categoryClickedListener) {
            super(itemView);

            this.containerView = itemView.findViewById(R.id.item_category_container_view);
            this.categoryNameTextView = itemView.findViewById(R.id.item_category_title_text_view);
            this.circleImageView = itemView.findViewById(R.id.item_category_cover_image);
            this.numberOfItemsTextView = itemView.findViewById(R.id.item_category_item_count_text_view);
            this.showCaseImage1 = itemView.findViewById(R.id.showCaseImage1);
            this.showCaseImage2 = itemView.findViewById(R.id.showCaseImage2);
            this.showCaseImage3 = itemView.findViewById(R.id.showCaseImage3);

            this.categoryClickedListener = categoryClickedListener;

            this.containerView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.categoryClickedListener.onCategoryClicked(getAdapterPosition());
        }
    }

    public interface OnCategoryClickedListener {
        void onCategoryClicked(int position);
    }
}
