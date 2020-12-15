package com.example.plantshopping.model;

import java.util.List;

public class Category {
    String category_name;
    List<Product> category_list;

    public Category(String category_name, List<Product> category_list) {
        this.category_name = category_name;
        this.category_list = category_list;
    }

    public String getCategoryName() {
        return category_name;
    }

    public void setCategoryName(String category_name) {
        this.category_name = category_name;
    }

    public List<Product> getCategory_list()
    {
        return category_list;
    }

    public void setCategory_list(List<Product> category_list) {
        this.category_list = category_list;
    }

    @Override
    public String toString() {
        String result = "Error";
        if (category_name != null) {
            result = category_name;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category that = (Category) o;
        return category_name.equals(that.category_name);
    }

}
