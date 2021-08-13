package com.jihee.nlcamping.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jihee.nlcamping.Model.CampingAdmin;
import com.jihee.nlcamping.Model.CampingPark;
import com.jihee.nlcamping.R;
import com.jihee.nlcamping.apdater.ParkAdapter;
import com.jihee.nlcamping.apdater.ReviewAdapter;
import com.jihee.nlcamping.compoundControl.AmenitiesBarView;
import com.jihee.nlcamping.compoundControl.ParkDetailView;

import java.io.IOException;
import java.io.InputStream;

public class ParkDetailActivity extends AppCompatActivity {
    public static final int ADD_ACTIVITY = 2001;
    public static final int EDIT_ACTIVITY = 2000;
    public static final String POSITION_WHICH_CLICK = "positionWhichClick";
    public static int provincePosition;
    public static int parkPosition;
    private TextView parkName;
    private ParkDetailView parkDetailView;
    private AmenitiesBarView amenitiesBarView;
    private RatingBar parkRating;
    private ImageView parkPicture;
    private Button addReviewButton;
    private ListView reviewList;
    private ReviewAdapter reviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_detail);

        parkName = findViewById(R.id.parkDetailName);
        parkPicture = findViewById(R.id.parkDetailImage);
        amenitiesBarView = findViewById(R.id.amenityBarViewInPark);
        parkDetailView = findViewById(R.id.parkDetailViewInPark);
        parkRating = findViewById(R.id.parkDetailRatingBar);
        addReviewButton = findViewById(R.id.parkDetailAddReview);
        reviewList = findViewById(R.id.parkDetailListview);

        Intent intent = getIntent();
        provincePosition = intent.getIntExtra(ParkAdapter.PROVINCE_POSITION, -1);
        parkPosition = intent.getIntExtra(ParkAdapter.PARK_POSITION, -2);
        CampingPark cp = CampingAdmin.provinces.get(provincePosition).getCampingParks().get(parkPosition);


        parkName.setText(cp.getParkName());
        parkDetailView.setAddress(cp.getAddress());
        parkDetailView.setPhone(cp.getPhone());
        parkDetailView.setWebstie(cp.getWebSiteAddress());

        amenitiesBarView.setTent(cp.getAmenities().isTentSite());
        amenitiesBarView.setCaravan(cp.getAmenities().isCaravanSite());
        amenitiesBarView.setBungalow(cp.getAmenities().isBungalow());
        amenitiesBarView.setRestaurant(cp.getAmenities().isRestaurant());
        amenitiesBarView.setPool(cp.getAmenities().isSwimmingPool());
        amenitiesBarView.setWifi(cp.getAmenities().isFreeWifi());
        amenitiesBarView.setDog(cp.getAmenities().isAnimalFriendly());


        parkRating.setNumStars(5);
        parkRating.setRating(Float.parseFloat(cp.getAverageOfRating()));

        InputStream inputStream = null;
        try {
            String imageFile = cp.getParkImage();
            inputStream = this.getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            parkPicture.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        reviewAdapter = new ReviewAdapter(this, cp.getReviews());
        reviewList.setAdapter(reviewAdapter);
        reviewList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                whenLongItemClicked(position);
                return true;
            }
        });

    }

    private void whenLongItemClicked(int position) {
        Intent intent = new Intent(this,ReviewEditAdd.class);
        intent.putExtra(POSITION_WHICH_CLICK,position);
        startActivityForResult(intent, EDIT_ACTIVITY);
    }

    public void addButtonClicked(View view) {
        Intent intent = new Intent(this,ReviewEditAdd.class);
        intent.putExtra(POSITION_WHICH_CLICK, -200);
        startActivityForResult(intent, ADD_ACTIVITY);
        reviewAdapter.notifyDataSetChanged();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        reviewAdapter.notifyDataSetChanged();
    }

}
