package com.example.rajanpipaliya.webdemo3;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by rajan pipaliya on 7/9/2015.
 */
public class data {
    int id;
    String country,rigion,image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRigion() {
        return rigion;
    }

    public void setRigion(String rigion) {
        this.rigion = rigion;
    }

    public data(int id, String country, String rigion,String image) {
        this.image=image;
        this.id = id;
        this.country = country;
        this.rigion = rigion;
    }
}
