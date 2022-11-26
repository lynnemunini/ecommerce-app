package com.munini.adibas.data;

import com.munini.adibas.R;
import com.munini.adibas.model.ItemCategory;
import com.munini.adibas.model.StockItem;

import java.util.Arrays;
import java.util.List;

public class CategoriesGenerator {

    public static List<ItemCategory> categoryList() {
        return Arrays.asList(
                new ItemCategory("Clothings", 4, R.drawable.clothings_main, R.drawable.clothings2, R.drawable.clothings3, R.drawable.clothings_main),
                new ItemCategory("Gadgets", 4, R.drawable.gadgets_main, R.drawable.gadgets2, R.drawable.gadgets3, R.drawable.gadgets4),
                new ItemCategory("Shoes", 4, R.drawable.shoes_main, R.drawable.shoes2, R.drawable.shoes3, R.drawable.shoes4),
                new ItemCategory("Accessories", 4, R.drawable.accessories_main, R.drawable.accessories2, R.drawable.accessories3, R.drawable.accessories4)
        );
    }

    public static ItemCategory findByName(String categoryName) {
        List<ItemCategory> categories = categoryList();
        for (ItemCategory category : categories) {
            if (category.getTitle().equalsIgnoreCase(categoryName)) {
                return category;
            }
        }
        throw new AssertionError("This category does not exist");
    }

    public static List<StockItem> findCategoryItemsByCategoryName(String categoryName) {
        if (categoryName.equalsIgnoreCase("Clothings")) {
            return Arrays.asList(
                    new StockItem(R.drawable.clothings4, "Men's Shirts", "Clothings"),
                    new StockItem(R.drawable.clothings_main, "Baby Clothes", "Clothings"),
                    new StockItem(R.drawable.clothings3, "Jacket", "Clothings"),
                    new StockItem(R.drawable.clothings2, "Baby Clothes", "Clothings")
            );
        } else if (categoryName.equalsIgnoreCase("Gadgets")) {
            return Arrays.asList(
                    new StockItem(R.drawable.gadgets_main, "Oraimo Smart Watch", "Gadgets"),
                    new StockItem(R.drawable.gadgets2, "Oraimo Ear Piece", "Gadgets"),
                    new StockItem(R.drawable.gadgets3, "Oraimo Ear Phones", "Gadgets"),
                    new StockItem(R.drawable.gadgets4, "Smart Phone", "Gadgets")
            );
        } else if (categoryName.equalsIgnoreCase("Shoes")) {
            return Arrays.asList(
                    new StockItem(R.drawable.shoes_main, "Men's Sneakers", "Shoes"),
                    new StockItem(R.drawable.shoes2, "Sneakers ", "Shoes"),
                    new StockItem(R.drawable.shoes3, "Men's Loafers", "Shoes"),
                    new StockItem(R.drawable.shoes4, "Breathable Sneakers", "Shoes")
            );
        } else {
            return Arrays.asList(
                    new StockItem(R.drawable.accessories_main, "Bracelets", "Shoes"),
                    new StockItem(R.drawable.accessories2, "Sunglasses", "Shoes"),
                    new StockItem(R.drawable.accessories3, "Necklaces with watch", "Shoes"),
                    new StockItem(R.drawable.accessories4, "Pant Chains", "Shoes")
            );
        }
    }
}
