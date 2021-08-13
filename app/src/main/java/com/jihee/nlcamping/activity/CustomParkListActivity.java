package com.jihee.nlcamping.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jihee.nlcamping.Model.CampingAdmin;
import com.jihee.nlcamping.Model.CampingPark;
import com.jihee.nlcamping.Model.Province;
import com.jihee.nlcamping.R;
import com.jihee.nlcamping.apdater.CustomParkAdapter;
import com.jihee.nlcamping.apdater.ParkAdapter;

import java.util.ArrayList;

public class CustomParkListActivity extends AppCompatActivity {
    private ListView listView;
    private CustomParkAdapter adapter;
    private ArrayList<String> customChoice;
    private ArrayList<CampingPark> parks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_park_list);

        customChoice = (ArrayList<String>) getIntent().getSerializableExtra("key");
        parks = getIntent().getParcelableArrayListExtra("list");
        listView = findViewById(R.id.listViewInParkDetail);
        adapter= new CustomParkAdapter(this,parks);
        listView.setAdapter(adapter);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        adapter.notifyDataSetChanged();
    }
}
