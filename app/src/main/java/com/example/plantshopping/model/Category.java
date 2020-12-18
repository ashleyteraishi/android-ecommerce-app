package com.example.plantshopping.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

import java.util.List;

public class Category implements Parcelable
{
    // name of the category (Shop All, Flowers, House Plants, etc.)
    String category_name;
    // ArrayList of all products in the category
    List<Product> category_list;

    // 2 argument constructor - set the category with the given name and list
    public Category(String category_name, List<Product> category_list)
    {
        this.category_name = category_name;
        this.category_list = category_list;
    }

    // parcelable methods to allow category objects to be passed through an intent
    protected Category(Parcel in) {
        category_name = in.readString();
        category_list = in.createTypedArrayList(Product.CREATOR);
    }

    public static final Creator<Category> CREATOR = new Creator<Category>()
    {
        @Override
        public Category createFromParcel(Parcel in)
        {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size)
        {
            return new Category[size];
        }
    };

    public String getCategory_name()
    {
        return category_name;
    }

    public void setCategory_name(String category_name)
    {
        this.category_name = category_name;
    }

    public List<Product> getCategory_list()
    {
        return category_list;
    }

    public void setCategory_list(List<Product> category_list)
    {
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
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
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
