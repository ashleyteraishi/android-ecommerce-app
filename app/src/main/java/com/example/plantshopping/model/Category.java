package com.example.plantshopping.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Category implements Parcelable
{
    String category_name;
    List<Product> category_list;

    public Category(String category_name, List<Product> category_list) {
        this.category_name = category_name;
        this.category_list = category_list;
    }

    protected Category(Parcel in) {
        category_name = in.readString();
        category_list = in.createTypedArrayList(Product.CREATOR);
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(category_name);
        dest.writeTypedList(category_list);
    }
}
