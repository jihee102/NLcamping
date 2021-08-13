package com.jihee.nlcamping.apdater;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jihee.nlcamping.Model.Province;
import com.jihee.nlcamping.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ProvinceAdapter extends ArrayAdapter<Province> {
    private List<Province> mProvinceList;
    private LayoutInflater mInflater;


    public ProvinceAdapter(@NonNull Context context, @NonNull List<Province> objects) {
        super(context, R.layout.province_list, objects);
        mProvinceList = objects;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView ==null){
            convertView = mInflater.inflate(R.layout.province_list,parent,false);
        }
        TextView provinceName = convertView.findViewById(R.id.provinceTextView);
        ImageView locationMap = convertView.findViewById(R.id.locationMap);
        ImageView flag = convertView.findViewById(R.id.flag);

        Province province = mProvinceList.get(position);
        provinceName.setTypeface(null, Typeface.BOLD);
        provinceName.setText(province.getProvinceName());


        InputStream inputStream =null;
        try {
            String imageFile = province.getLocationMap();
            inputStream = getContext().getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            locationMap.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(inputStream != null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        InputStream flagInputSteam = null;
        try {
            String sFlagImage = province.getFlagImage();
            flagInputSteam = getContext().getAssets().open(sFlagImage);
            Drawable f = Drawable.createFromStream(flagInputSteam, null);
            flag.setImageDrawable(f);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(flagInputSteam != null) {
                    flagInputSteam.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return convertView;

    }
}

