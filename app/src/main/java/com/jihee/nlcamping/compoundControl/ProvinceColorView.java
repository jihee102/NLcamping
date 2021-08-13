package com.jihee.nlcamping.compoundControl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.jihee.nlcamping.R;

public class ProvinceColorView extends LinearLayout {
    TextView northH, drenthe, flevoland, frisland, gelderland, groningen, limburg, northB, southH, overijssel, utrecht, zeeland;
    public ProvinceColorView(Context context) {
        super(context);
        init();
    }

    public ProvinceColorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProvinceColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ProvinceColorView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init() {
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.province_color_view, this);
        northH = findViewById(R.id.northHollandC);
        drenthe = findViewById(R.id.drentheC);
        flevoland = findViewById(R.id.flevolandC);
        frisland = findViewById(R.id.frislandC);
        gelderland = findViewById(R.id.gelderlandC);
        groningen = findViewById(R.id.groningenC);
        limburg = findViewById(R.id.limburgC);
        northB = findViewById(R.id.northBrabantC);
        southH = findViewById(R.id.southHollandC);
        overijssel = findViewById(R.id.overijsselC);
        utrecht = findViewById(R.id.utrechtC);
        zeeland = findViewById(R.id.zeelandC);

    }

    public void setDrenthe(String drenthe) {
        this.drenthe.setText(drenthe);
    }

    public void setFlevoland(String flevoland) {
        this.flevoland .setText(flevoland);
    }

    public void setFrisland(String frisland) {
        this.frisland.setText(frisland);
    }

    public void setGelderland(String gelderland) {
        this.gelderland.setText(gelderland);
    }

    public void setGroningen(String groningen) {
        this.groningen.setText(groningen);
    }

    public void setLimburg(String limburg) {
        this.limburg.setText(limburg);
    }

    public void setNorthB(String northB) {
        this.northB.setText(northB);
    }

    public void setNorthH(String northH) {
        this.northH.setText(northH);
    }

    public void setOverijssel(String overijssel) {
        this.overijssel.setText(overijssel);
    }

    public void setSouthH(String  southH) {
        this.southH.setText(southH);
    }

    public void setUtrecht(String utrecht) {
        this.utrecht.setText(utrecht);
    }

    public void setZeeland(String zeeland) {
        this.zeeland.setText(zeeland);
    }
}
