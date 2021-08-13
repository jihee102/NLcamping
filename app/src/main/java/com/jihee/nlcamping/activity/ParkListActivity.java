package com.jihee.nlcamping.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.jihee.nlcamping.Model.CampingAdmin;
import com.jihee.nlcamping.Model.Province;
import com.jihee.nlcamping.R;
import com.jihee.nlcamping.apdater.ParkAdapter;

public class ParkListActivity extends AppCompatActivity {
    public static final int ADD_ACTIVITY = 2000;
    public static final int EDIT_ACTIVITY = 2100;
    public static final String PARK_POSITION = "parkPostion";
    public static final String PROVINCE_POSITION = "provincePosition";
    private Button addButton;
    private TextView provinceName;
    private ListView listView;
    public static int provincePosition;
    private ParkAdapter parkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_list);

        Intent intent = getIntent();

        provincePosition = intent.getIntExtra(HomeFargment.PROVINCE_POSITION,-1);

        addButton= findViewById(R.id.addParkInParkDetail);
        provinceName = findViewById(R.id.provinceNameInParkDetail);
        listView = findViewById(R.id.listViewInParkDetail);

        Province p = CampingAdmin.provinces.get(provincePosition);
        provinceName.setText(p.getProvinceName());

        parkAdapter = new ParkAdapter(this,p.getCampingParks());
        listView.setAdapter(parkAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                whenLongItemClicked(position);
                return true;
            }
        });

    }


    public void addParkButtonClicked(View view) {
        Intent intent = new Intent(this, ParkEditAdd.class);
        intent.putExtra(PARK_POSITION,-200);
        intent.putExtra(PROVINCE_POSITION,provincePosition);
        startActivityForResult(intent, ADD_ACTIVITY);
        parkAdapter.notifyDataSetChanged();
    }


    private void whenLongItemClicked(int position) {
        Intent intent = new Intent(this, ParkEditAdd.class);
        intent.putExtra(PARK_POSITION,position);
        intent.putExtra(PROVINCE_POSITION,provincePosition);
        startActivityForResult(intent, EDIT_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        parkAdapter.notifyDataSetChanged();
    }
}
