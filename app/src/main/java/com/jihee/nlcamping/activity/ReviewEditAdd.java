package com.jihee.nlcamping.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jihee.nlcamping.Model.CampingAdmin;
import com.jihee.nlcamping.Model.Review;
import com.jihee.nlcamping.R;

import java.io.IOException;
import java.io.InputStream;

public class ReviewEditAdd extends AppCompatActivity {
    private ImageView reviewImage;
    private EditText ID, score, comment;
    private TextView parkName;
    private int position;
    private boolean isNewReview;
    private int provincePosition;
    private int parkPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_edit_add);

        Intent intent =getIntent();
        position = intent.getIntExtra(ParkDetailActivity.POSITION_WHICH_CLICK,-3);
        provincePosition = ParkDetailActivity.provincePosition;
        parkPosition = ParkDetailActivity.parkPosition;
        if(position == -200){
            isNewReview = true;
        }

        parkName =findViewById(R.id.parkNameInReviewEdit);
        ID = findViewById(R.id.idEditText);
        score = findViewById(R.id.scoreEditText);
        comment = findViewById(R.id.reviewCommentEditText);
        reviewImage = findViewById(R.id.reviewImageView);

        InputStream inputStream =null;
        try {
            String imageFile = "review.png";
            inputStream = this.getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            reviewImage.setImageDrawable(d);
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

        if(!isNewReview){
            Review r = CampingAdmin.provinces.get(provincePosition).getCampingParks().get(parkPosition).getReviews().get(position);
            parkName.setText("Review of "+CampingAdmin.provinces.get(provincePosition).getCampingParks().get(parkPosition).getParkName());
            ID.setText(r.getID());
            score.setText(r.getSatisfactionScore()+"");
            comment.setText(r.getContent());
        }else {
            parkName.setText("Review of "+CampingAdmin.provinces.get(provincePosition).getCampingParks().get(parkPosition).getParkName());
        }


    }

    public void whenSavePressed(View view) {
        Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_LONG).show();
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(isNewReview){
            String stringID = ID.getText().toString();
            if(stringID.length()>1){
                int intScore = Integer.parseInt(score.getText().toString());
                String stringComment = comment.getText().toString();

                Review r = new Review(stringID,stringComment,intScore);
                CampingAdmin.provinces.get(provincePosition).getCampingParks().get(parkPosition).getReviews().add(r);
            }
        }else {
            String stringID = ID.getText().toString();
            int intScore = Integer.parseInt(score.getText().toString());
            String stringComment = comment.getText().toString();
            CampingAdmin.provinces.get(provincePosition).getCampingParks().get(parkPosition).getReviews().get(position).setID(stringID);
            CampingAdmin.provinces.get(provincePosition).getCampingParks().get(parkPosition).getReviews().get(position).setSatisfactionScore(intScore);
            CampingAdmin.provinces.get(provincePosition).getCampingParks().get(parkPosition).getReviews().get(position).setContent(stringComment);
        }
    }

}
