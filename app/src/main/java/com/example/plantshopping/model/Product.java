package com.example.plantshopping.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable
{
    String product_name;
    String product_price;
    String product_description;
    Integer image_url;

    // default (zero argument) constructor
    public Product()
    {
        this.product_name = "Product not Found";
        this.product_price = "Price not Found";
        this.product_description = "N/A";
        this.image_url = null;
    }

    // 3 argument constructor
    public Product(String product_name, String product_price, Integer image_url)
    {
        this.product_name = product_name;
        this.product_price = product_price;
        this.image_url = image_url;
    }

    // 4 argument constructor
    public Product(String product_name, String product_price, String product_description, Integer image_url)
    {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_description = product_description;
        this.image_url = image_url;
    }

    // parcelable methods so that product objects can be passed through an intent
    protected Product(Parcel in)
    {
        product_name = in.readString();
        product_price = in.readString();
        product_description = in.readString();
        if (in.readByte() == 0)
        {
            image_url = null;
        }
        else
        {
            image_url = in.readInt();
        }
    }

    public static final Creator<Product> CREATOR = new Creator<Product>()
    {
        @Override
        public Product createFromParcel(Parcel in)
        {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size)
        {
            return new Product[size];
        }
    };

    public String getProduct_name()
    {
        return product_name;
    }

    public void setProduct_name(String product_name)
    {
        this.product_name = product_name;
    }

    public String getProduct_price()
    {
        return product_price;
    }

    public void setProduct_price(String product_price)
    {
        this.product_price = product_price;
    }

    public Integer getImage_url()
    {
        return image_url;
    }

    public void setImage_url(Integer image_url)
    {
        this.image_url = image_url;
    }

    public String getProduct_description()
    {
        return product_description;
    }

    public void setProduct_description(String product_description)
    {
        this.product_description = product_description;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(product_name);
        dest.writeString(product_price);
        dest.writeString(product_description);
        if (image_url == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(image_url);
        }
    }
}
