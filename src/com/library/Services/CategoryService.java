package com.library.Services;

import com.library.Entities.Category;

import static com.library.Database.categories;

public class CategoryService extends Category implements ICategoryService {

    @Override
    public String getAllCategories() {
        return categories.toString();
    }

    @Override
    public String getCategoryById(int id) {
        for (Category c : categories)
            if (c.getId() == id)
                return c.toString();
        return "No category found with the given id";
    }

    @Override
    public void addCategory(Category c) {
        categories.add(c);
    }

    @Override
    public void deleteCategory(int id) {
        for (Category c : categories)
            if (c.getId() == id) {
                categories.remove(c);
                break;
            }

    }
}
