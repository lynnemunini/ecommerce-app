package com.munini.adibas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.munini.adibas.adapter.CategoriesAdapter;
import com.munini.adibas.data.CategoriesGenerator;
import com.munini.adibas.model.ItemCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CategoriesFragment extends Fragment {
    private Activity mainActivity;
    private RecyclerView categoryItemsRecyclerView;
    private CategoriesAdapter categoriesAdapter;
    private MaterialButton closeAppButton;
    private List<ItemCategory> categories = new ArrayList<>();

    public CategoriesFragment(Activity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_categories_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initializeResources(view);
    }

    private void initializeResources(View view) {
        categoryItemsRecyclerView = view.findViewById(R.id.category_items_recycler_view);
        closeAppButton = view.findViewById(R.id.close_app_button);
        categoryItemsRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        categories.addAll(CategoriesGenerator.categoryList());
        categoriesAdapter = new CategoriesAdapter(requireContext(), categories, new CategoriesAdapter.OnCategoryClickedListener() {
            @Override
            public void onCategoryClicked(int position) {
                ItemCategory selectedCategory = categories.get(position);
                Toast.makeText(requireContext(),
                        String.format(Locale.getDefault(), "You've selected to view %s category", selectedCategory.getTitle()),
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(mainActivity, DetailedActivity.class);
                intent.putExtra(DetailedActivity.CATEGORY_NAME_KEY, selectedCategory.getTitle());
                mainActivity.startActivity(intent);
                mainActivity.finish();
            }
        });
        closeAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mainActivity,
                        String.format(Locale.getDefault(), "Closed  %s App", getResources().getString(R.string.app_name)),
                        Toast.LENGTH_LONG).show();

                mainActivity.finishAffinity();
            }
        });
        categoryItemsRecyclerView.setAdapter(categoriesAdapter);
    }
}
