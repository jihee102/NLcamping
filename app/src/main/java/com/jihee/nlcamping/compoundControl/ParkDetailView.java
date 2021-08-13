package com.jihee.nlcamping.compoundControl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.jihee.nlcamping.R;

public class ParkDetailView extends LinearLayout {
    private TextView address, phone, webstie;

    public ParkDetailView(Context context) {
        super(context);
        init();
    }

    public ParkDetailView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ParkDetailView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ParkDetailView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init(){
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.park_datail_view, this);
        address = findViewById(R.id.addressInCustom);
        phone = findViewById(R.id.phoneInCustom);
        webstie = findViewById(R.id.webInCustom);

    }

    public void setPhone(String p) {
        this.phone.setText(p);
    }

    public void setAddress(String a) {
        this.address.setText(a);
    }

    public void setWebstie(String w) {
        this.webstie.setText(w);
    }
}
