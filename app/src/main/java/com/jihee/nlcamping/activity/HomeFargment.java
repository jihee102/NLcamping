package com.jihee.nlcamping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jihee.nlcamping.Model.CampingAdmin;
import com.jihee.nlcamping.Model.Province;
import com.jihee.nlcamping.R;
import com.jihee.nlcamping.apdater.ProvinceAdapter;


import java.util.List;

public class HomeFargment extends Fragment {

    public static final String PROVINCE_POSITION = "provincePosition";
    private View view;
    private ListView listView;
    private List<Province> provinceList;
    private ProvinceAdapter adapter;


    public HomeFargment(){}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_home,container,false);
        provinceList = CampingAdmin.provinces;

        adapter = new ProvinceAdapter(getContext(),provinceList);
        listView = view.findViewById(R.id.homeListview);


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(),ParkListActivity.class);
                intent.putExtra(PROVINCE_POSITION,position);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        adapter.notifyDataSetChanged();
    }
}
