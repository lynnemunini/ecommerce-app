package com.munini.adibas;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.munini.adibas.adapter.ItemsRecyclerViewAdapter;
import com.munini.adibas.data.CategoriesGenerator;
import com.munini.adibas.model.ItemCategory;
import com.munini.adibas.model.StockItem;

import java.util.ArrayList;
import java.util.List;

public class DetailedActivity extends AppCompatActivity {

    public static final String CATEGORY_NAME_KEY = "categopry.name.key";
    private ItemCategory selectedCategory;
    private MaterialToolbar toolbar;
    private RecyclerView recyclerView;
    private ItemsRecyclerViewAdapter recyclerViewAdapter;
    private List<StockItem> stockItemList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String categoryName = getIntent().getStringExtra(CATEGORY_NAME_KEY);
        selectedCategory = CategoriesGenerator.findByName(categoryName);
        setContentView(R.layout.activity_detailed_activity);
        initializeResources();
    }

    private void initializeResources() {
        toolbar = findViewById(R.id.detailed_view_toolbar);
        recyclerView = findViewById(R.id.items_recycler_view);
        recyclerView.setLayoutManager( new LinearLayoutManager(DetailedActivity.this));
        stockItemList.addAll(CategoriesGenerator.findCategoryItemsByCategoryName(selectedCategory.getTitle()));
        recyclerViewAdapter = new ItemsRecyclerViewAdapter(DetailedActivity.this,stockItemList);
        recyclerView.setAdapter(recyclerViewAdapter);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            Toast.makeText(DetailedActivity.this,"Going back to available categories", Toast.LENGTH_LONG).show();
            startActivity( new Intent(DetailedActivity.this, MainActivity.class));
            finish();
        }
        return true;
    }
}
