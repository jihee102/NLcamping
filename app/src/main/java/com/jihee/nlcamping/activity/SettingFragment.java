package com.jihee.nlcamping.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jihee.nlcamping.R;
import com.jihee.nlcamping.spinner.CountryAdapter;
import com.jihee.nlcamping.spinner.CountryItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SettingFragment extends Fragment {
    private View view;
    private Locale locale;
    private List<CountryItem> countryList;
    private CountryAdapter countryAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_setting,container,false);

        initList();

        Spinner spinnerCountries = view.findViewById(R.id.spinnerCountries);
        countryAdapter = new CountryAdapter(getContext(),countryList);
        spinnerCountries.setAdapter(countryAdapter);

        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CountryItem clickedItem = (CountryItem) parent.getItemAtPosition(position);
                String clickedCountryLanguage = clickedItem.getCountryLanguage();
                switch (clickedCountryLanguage){
                    case "English":
                        changeLang("en");
                        break;
                    case "Dutch":
                        changeLang("nl");
                        break;
                    case "Korean":
                        changeLang("ko");
                        break;
                }
                Toast.makeText(getContext(), "Language is changed to "+clickedCountryLanguage, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    private void initList() {
        countryList = new ArrayList<>();
        countryList.add(new CountryItem("English",R.drawable.flag_uk));
        countryList.add(new CountryItem("Dutch",R.drawable.flag_netherlands));
        countryList.add(new CountryItem("Korean",R.drawable.flag_south_korea));
    }

    public void changeLang(String lang){
        Configuration config = getActivity().getBaseContext().getResources().getConfiguration();
        if(!"".equals(lang) && !config.locale.getLanguage().equals(lang)){
            locale = new Locale(lang);
            Locale.setDefault(locale);
            Configuration conf = new Configuration(config);
            conf.locale = locale;
            getActivity().getBaseContext().getResources().updateConfiguration(conf, getActivity().getBaseContext().getResources().getDisplayMetrics());
        }

    }
}
