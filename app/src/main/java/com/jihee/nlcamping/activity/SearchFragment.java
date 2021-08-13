package com.jihee.nlcamping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jihee.nlcamping.Model.CampingAdmin;
import com.jihee.nlcamping.Model.CampingPark;
import com.jihee.nlcamping.Model.Province;
import com.jihee.nlcamping.R;
import com.jihee.nlcamping.compoundControl.AmenitiesView;

import java.util.ArrayList;

public class SearchFragment extends Fragment {
    public static final String LIST = "list";
    public static final String KEY = "key";
    private View view;
    private Button searchButton;
    private AmenitiesView amenitiesView;
    private ArrayList<String> customChoice;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_search,container,false);

        amenitiesView = view.findViewById(R.id.amenityView);
        searchButton = view.findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkoutCustomSetting();
                if(customChoice.size() != 0){
                    ArrayList<CampingPark>pass = getCampingList();
                    Intent intent = new Intent(getContext(), CustomParkListActivity.class);
                    intent.putExtra(KEY,customChoice);
                    intent.putParcelableArrayListExtra(LIST, pass);
                    startActivity(intent);

                }else{
                    Toast.makeText(getContext(), "Please choose any option.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }
    public ArrayList<CampingPark> getCampingList(){
        ArrayList<CampingPark> result = new ArrayList<>();
        for(Province p : CampingAdmin.provinces){
                for (CampingPark c : p.getCampingParks()) {
                    if(search(c.getParkProperties(),customChoice) == customChoice.size()){
                        result.add(c);
                    }
                }

            }
        return result;

    }

    public int search(ArrayList<String> alphas, ArrayList<String> betas) {
        ArrayList<String> results = new ArrayList<>();

        for (String alpha : alphas) {
            for (String beta : betas) {
                if (alpha.equals(beta)) {
                    results.add(alpha);
                    break;
                }
            }
        }
        return results.size();
    }


    public void checkoutCustomSetting() {
        customChoice = new ArrayList<>();
        if(amenitiesView.getSwTent()){
            customChoice.add("tent");
        }
        if(amenitiesView.getSwBungalow()){
            customChoice.add("bungalow");
        }
        if(amenitiesView.getSwCaravan()){
            customChoice.add("caravan");
        }
        if(amenitiesView.getSwRestaurant()){
            customChoice.add("restaurant");
        }
        if(amenitiesView.getSwPool()){
            customChoice.add("pool");
        }
        if(amenitiesView.getSwWifi()){
            customChoice.add("wifi");
        }
        if(amenitiesView.getSwDog()){
            customChoice.add("dog");
        }
    }


}
