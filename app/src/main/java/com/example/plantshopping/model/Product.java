package com.example.plantshopping.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Product implements Parcelable
{
    String product_name;
    String product_price;
    Integer image_url;

    public Product(String product_name, String product_price, Integer image_url) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.image_url = image_url;
    }

    protected Product(Parcel in) {
        product_name = in.readString();
        product_price = in.readString();
        if (in.readByte() == 0) {
            image_url = null;
        } else {
            image_url = in.readInt();
        }
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public Integer getImage_url() {
        return image_url;
    }

    public void setImage_url(Integer image_url) {
        this.image_url = image_url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(product_name);
        dest.writeString(product_price);
        if (image_url == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(image_url);
        }
    }
}
