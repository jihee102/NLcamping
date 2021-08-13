package com.jihee.nlcamping.compoundControl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.annotation.Nullable;

import com.jihee.nlcamping.R;

public class AmenitiesSettingView extends LinearLayout {
    private AmenitiesBarView amenitiesBarView;
    private Switch tent,caravan, bungalow, restaurant, pool, wifi, dog;

    public AmenitiesSettingView(Context context) {
        super(context);
        init();
    }

    public AmenitiesSettingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AmenitiesSettingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public AmenitiesSettingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    public void init(){
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.amenities_setting_view, this);

        amenitiesBarView = findViewById(R.id.abView);
        tent= findViewById(R.id.tentSetting);
        caravan = findViewById(R.id.caravanSetting);
        bungalow = findViewById(R.id.bungalowSetting);
        restaurant = findViewById(R.id.restauSetting);
        pool = findViewById(R.id.poolSetting);
        wifi = findViewById(R.id.wifiSetting);
        dog = findViewById(R.id.dogSetting);

    }

    public void setTent(boolean what) {
        amenitiesBarView.setTent(what);
        this.tent.setChecked(what);
    }

    public void setCaravan(boolean what) {
        amenitiesBarView.setCaravan(what);
        this.caravan.setChecked(what);
    }

    public void setBungalow(boolean what) {
        amenitiesBarView.setBungalow(what);
        this.bungalow.setChecked(what);
    }

    public void setRestaurant(boolean what) {
        amenitiesBarView.setRestaurant(what);
        this.restaurant.setChecked(what);
    }

    public void setPool(boolean what) {
        amenitiesBarView.setPool(what);
        this.pool.setChecked(what);
    }

    public void setWifi(boolean what) {
        amenitiesBarView.setWifi(what);
        this.wifi.setChecked(what);
    }

    public void setDog(boolean what) {
        amenitiesBarView.setDog(what);
        this.dog.setChecked(what);
    }
    public boolean getSwBungalow() {
        if(bungalow.isChecked()){
            return true;
        }
        return false;
    }

    public boolean getSwCaravan() {
        if(caravan.isChecked()){
            return true;
        }
        return false;
    }

    public boolean getSwDog() {
        if(dog.isChecked()){
            return true;
        }
        return false;
    }

    public boolean getSwPool() {
        if(pool.isChecked()){
            return true;
        }
        return false;
    }

    public boolean getSwRestaurant() {
        if(restaurant.isChecked()){
            return true;
        }
        return false;
    }

    public boolean getSwTent() {
        if(tent.isChecked()){
            return true;
        }
        return false;
    }

    public boolean getSwWifi() {
        if(wifi.isChecked()){
            return true;
        }
        return false;
    }

}
