package com.jihee.nlcamping.compoundControl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.jihee.nlcamping.R;

public class AmenitiesBarView extends LinearLayout {
    ImageView tent, caravan, bungalow, restaurant, pool, wifi, dog;

    public AmenitiesBarView(Context context) {
        super(context);
        init();
    }

    public AmenitiesBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AmenitiesBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public AmenitiesBarView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }



    public void init(){
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.amenities_bar_view, this);

        tent = findViewById(R.id.tentImage);
        caravan = findViewById(R.id.caravanImage);
        bungalow = findViewById(R.id.bungalowImage);
        pool = findViewById(R.id.poolImage);
        restaurant = findViewById(R.id.restaurantImage);
        wifi = findViewById(R.id.wifiImage);
        dog = findViewById(R.id.dogImage);

    }

    public void setTent(boolean what) {
        if(what){
            this.tent.setBackground(getResources().getDrawable(R.drawable.custom_background5));
        }
    }

    public void setCaravan(boolean what) {
        if(what){
            this.caravan.setBackground(getResources().getDrawable(R.drawable.custom_background5));
        }
    }

    public void setBungalow(boolean what) {
        if(what){
            this.bungalow.setBackground(getResources().getDrawable(R.drawable.custom_background5));
        }
    }

    public void setRestaurant(boolean what) {
        if(what){
            this.restaurant.setBackground(getResources().getDrawable(R.drawable.custom_background5));
        }
    }

    public void setPool(boolean what) {
        if(what){
            this.pool.setBackground(getResources().getDrawable(R.drawable.custom_background5));
        }
    }

    public void setWifi(boolean what) {
        if(what){
            this.wifi.setBackground(getResources().getDrawable(R.drawable.custom_background5));
        }
    }

    public void setDog(boolean what) {
        if(what){
            this.dog.setBackground(getResources().getDrawable(R.drawable.custom_background5));
        }
    }
}
