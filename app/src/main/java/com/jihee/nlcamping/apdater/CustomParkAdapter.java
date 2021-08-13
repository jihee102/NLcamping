package com.jihee.nlcamping.apdater;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jihee.nlcamping.Model.CampingPark;
import com.jihee.nlcamping.Model.Review;
import com.jihee.nlcamping.R;
import com.jihee.nlcamping.compoundControl.AmenitiesBarView;
import com.jihee.nlcamping.compoundControl.ParkDetailView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CustomParkAdapter extends ArrayAdapter {
    private LayoutInflater layoutInflater;
    private ArrayList<CampingPark> parks;
    private TextView parkName;
    private ParkDetailView parkDetailView;
    private ImageView parkImage;
    private Context context;
    private AmenitiesBarView amenitiesBarView;
    private RatingBar ratingBar;

    public CustomParkAdapter(@NonNull Context context,@NonNull List objects) {
        super(context, R.layout.custom_park_list, objects);
        this.layoutInflater = LayoutInflater.from(context);
        this.parks =(ArrayList<CampingPark>) objects;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final CampingPark c = parks.get(position);
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.custom_park_list, parent, false);
        }

        parkName = convertView.findViewById(R.id.parkNameInCustom);

        parkImage = convertView.findViewById(R.id.parkImageInCustom);
        amenitiesBarView = convertView.findViewById(R.id.amenityBarView);
        ratingBar = convertView.findViewById(R.id.ratingBarInCustom);
        parkDetailView = convertView.findViewById(R.id.parkDetailViewInCustom);

        parkName.setText(parks.get(position).getParkName());
        parkDetailView.setAddress(parks.get(position).getAddress());
        parkDetailView.setPhone(parks.get(position).getPhone());
        parkDetailView.setWebstie(parks.get(position).getWebSiteAddress());
        ratingBar.setRating(Float.parseFloat(parks.get(position).getAverageOfRating()));

        setAmenitiesSetting(position);

        InputStream inputStream =null;
        try {
            String imageFile = parks.get(position).getParkImage();
            inputStream = getContext().getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            parkImage.setImageDrawable(d);
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



        return convertView;
    }

    private void setAmenitiesSetting(int position) {
        amenitiesBarView.setTent(parks.get(position).getAmenities().isTentSite());
        amenitiesBarView.setCaravan(parks.get(position).getAmenities().isCaravanSite());
        amenitiesBarView.setBungalow(parks.get(position).getAmenities().isBungalow());
        amenitiesBarView.setRestaurant(parks.get(position).getAmenities().isRestaurant());
        amenitiesBarView.setPool(parks.get(position).getAmenities().isSwimmingPool());
        amenitiesBarView.setWifi(parks.get(position).getAmenities().isFreeWifi());
        amenitiesBarView.setDog(parks.get(position).getAmenities().isAnimalFriendly());

    }


}
