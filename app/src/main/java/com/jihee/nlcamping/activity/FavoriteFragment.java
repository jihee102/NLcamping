package com.jihee.nlcamping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jihee.nlcamping.Model.CampingAdmin;
import com.jihee.nlcamping.Model.CampingPark;
import com.jihee.nlcamping.Model.Province;
import com.jihee.nlcamping.R;
import com.jihee.nlcamping.apdater.ExpandableListAdapter;
import com.jihee.nlcamping.customDraw.GraphView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FavoriteFragment extends Fragment {
    private List<CampingPark> favoriteParks;
    private View view;
    private ExpandableListAdapter expandableListAdapter;
    private ExpandableListView expListView;
    private List<Province> provinceList;
    private TextView storageAlert;
    private int favoriteCount;
    private HashMap<String,List<CampingPark>> child = new HashMap<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_favorite,container,false);

        prepareFavoriteData();

        storageAlert = view.findViewById(R.id.storageAlertText);
        expListView= view.findViewById(R.id.expList);

        storageAlert.setText("My Favorite list storage( "+favoriteCount+"/10 )");
        expandableListAdapter = new ExpandableListAdapter(getContext(),provinceList,child);
        expListView.setAdapter(expandableListAdapter);

        return view;

    }


    private void prepareFavoriteData() {
        provinceList=new ArrayList<>();
        for (Province p : CampingAdmin.provinces){
            if(p.getSelectedParks() != null){
                provinceList.add(p);
                favoriteParks= new ArrayList<>();
                for(CampingPark c: p.getSelectedParks()){
                    favoriteParks.add(c);
                    favoriteCount++;
                }
                child.put(p.getProvinceName(),favoriteParks);
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        expandableListAdapter.notifyDataSetChanged();
    }


}
