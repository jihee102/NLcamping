package com.jihee.nlcamping.spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jihee.nlcamping.R;

import java.util.List;

public class CountryAdapter extends ArrayAdapter<CountryItem> {
    public CountryAdapter(@NonNull Context context, @NonNull List objects) {
        super(context, 0, objects);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    private View initView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.country_spinner_row, parent,false);
        }

        ImageView countryFlag =convertView.findViewById(R.id.country_flag);
        TextView countryName = convertView.findViewById(R.id.country_name);

        CountryItem currentItem = getItem(position);

        if(currentItem != null) {
            countryFlag.setImageResource(currentItem.getFlagImage());
            countryName.setText(currentItem.getCountryLanguage());
        }

        return convertView;

    }
}
