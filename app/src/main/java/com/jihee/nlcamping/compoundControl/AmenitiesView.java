package com.jihee.nlcamping.compoundControl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.annotation.Nullable;

import com.jihee.nlcamping.R;

public class AmenitiesView extends LinearLayout {
    private Switch swTent, swCaravan, swBungalow, swRestuarant, swPool, swWifi, swDog;

    public AmenitiesView(Context context) {
        super(context);
        init();
    }

    public AmenitiesView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AmenitiesView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public AmenitiesView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init(){
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.amenitiesview, this);

        swTent = findViewById(R.id.switchTent);
        swCaravan = findViewById(R.id.switchCaravan);
        swBungalow = findViewById(R.id.switchBungalow);
        swPool = findViewById(R.id.switchPool);
        swRestuarant = findViewById(R.id.switchRestaurant);
        swWifi = findViewById(R.id.switchWifi);
        swDog = findViewById(R.id.switchDog);

    }

    public boolean getSwBungalow() {
        if(swBungalow.isChecked()){
            return true;
        }
        return false;
    }

    public boolean getSwCaravan() {
        if(swCaravan.isChecked()){
            return true;
        }
        return false;
    }

    public boolean getSwDog() {
        if(swDog.isChecked()){
            return true;
        }
        return false;
    }

    public boolean getSwPool() {
        if(swPool.isChecked()){
            return true;
        }
        return false;
    }

    public boolean getSwRestaurant() {
        if(swRestuarant.isChecked()){
            return true;
        }
        return false;
    }

    public boolean getSwTent() {
        if(swTent.isChecked()){
            return true;
        }
        return false;
    }

    public boolean getSwWifi() {
        if(swWifi.isChecked()){
            return true;
        }
        return false;
    }
}
