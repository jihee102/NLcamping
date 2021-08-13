package com.jihee.nlcamping.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jihee.nlcamping.Model.CampingAdmin;
import com.jihee.nlcamping.Model.Province;
import com.jihee.nlcamping.R;
import com.jihee.nlcamping.compoundControl.ProvinceColorView;
import com.jihee.nlcamping.customDraw.PieChartView;


public class OverviewFragment extends Fragment {
    private View view;
    private LinearLayout linear;
    private int [] parkCount;
    private ProvinceColorView provinceColorView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_overview,container,false);
        float[] parkCountPerProvince= getDataForFieChart();
        provinceColorView = view.findViewById(R.id.provinceSection);
        provinceColorView.setNorthH("North Holland ("+parkCount[0]+")");
        provinceColorView.setDrenthe("Drenthe("+parkCount[1]+")");
        provinceColorView.setFlevoland("Flevoland ("+parkCount[2]+")");
        provinceColorView.setFrisland("Frisland ("+parkCount[3]+")");
        provinceColorView.setGelderland("Gelderland ("+parkCount[4]+")");
        provinceColorView.setGroningen("Groningen ("+parkCount[5]+")");
        provinceColorView.setLimburg("Limburg ("+parkCount[6]+")");
        provinceColorView.setNorthB("North Brbant ("+parkCount[7]+")");
        provinceColorView.setSouthH("South Holland ("+parkCount[8]+")");
        provinceColorView.setOverijssel("Overijssel ("+parkCount[9]+")");
        provinceColorView.setUtrecht("Utrecht ("+parkCount[10]+")");
        provinceColorView.setZeeland("Zeeland ("+parkCount[11]+")");


        parkCountPerProvince = calculateData(parkCountPerProvince);
        linear = view.findViewById(R.id.testLinear);
        linear.addView(new PieChartView(getContext(),parkCountPerProvince));


        return view;
    }

    private float[] getDataForFieChart() {
        parkCount= new int[12];
        float []data = new float[12];
        for (int i = 0; i <CampingAdmin.provinces.size() ; i++) {
            int size = CampingAdmin.provinces.get(i).getCampingParks().size();
            parkCount[i]= size;
            data[i] = size;
        }
        return data;
    }




    private float[] calculateData(float[] data) {
        float total=0;
        for(int i=0;i<data.length;i++)
        {
            total+=data[i];
        }
        for(int i=0;i<data.length;i++)
        {
            data[i]=360*(data[i]/total);
        }
        return data;

    }
}
