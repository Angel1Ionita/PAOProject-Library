package com.library.Services;

import com.library.Entities.Category;

public interface ICategoryService {
    String getAllCategories();

    String getCategoryById(int id);

    void addCategory(Category c);

    void deleteCategory(int id);
}
