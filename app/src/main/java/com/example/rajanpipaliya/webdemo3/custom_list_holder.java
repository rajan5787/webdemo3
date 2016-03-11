package com.example.rajanpipaliya.webdemo3;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rajan pipaliya on 7/9/2015.
 */
public class custom_list_holder {
    TextView id,country,rigion;
    ImageView imageView;

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public TextView getId() {
        return id;
    }

    public void setId(TextView id) {
        this.id = id;
    }

    public TextView getCountry() {
        return country;
    }

    public void setCountry(TextView country) {
        this.country = country;
    }

    public TextView getRigion() {
        return rigion;
    }

    public void setRigion(TextView rigion) {
        this.rigion = rigion;
    }

    public custom_list_holder(TextView id, TextView country, TextView rigion,ImageView imageView) {
        this.imageView=imageView;
        this.id = id;
        this.country = country;
        this.rigion = rigion;
    }
}
