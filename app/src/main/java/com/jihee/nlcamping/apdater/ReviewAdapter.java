package com.jihee.nlcamping.apdater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jihee.nlcamping.Model.CampingAdmin;
import com.jihee.nlcamping.Model.CampingPark;
import com.jihee.nlcamping.Model.Review;
import com.jihee.nlcamping.R;
import com.jihee.nlcamping.activity.ParkDetailActivity;

import java.util.List;

public class ReviewAdapter extends ArrayAdapter {
    private LayoutInflater layoutInflater;
    private List<Review> reviews;
    private Button deleteButton;
    private TextView parkName, idInput, score, reviewContent;

    public ReviewAdapter(@NonNull Context context, @NonNull List objects) {
        super(context, R.layout.review_list, objects);
        layoutInflater = LayoutInflater.from(context);
        reviews = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView ==null){
            convertView = layoutInflater.inflate(R.layout.review_list,parent,false);
        }
        Review r = reviews.get(position);
        parkName = convertView.findViewById(R.id.parkNameInReviewEdit);
        idInput = convertView.findViewById(R.id.idInput);
        score = convertView.findViewById(R.id.score);
        reviewContent = convertView.findViewById(R.id.reviewContent);
        deleteButton = convertView.findViewById(R.id.deleteReview);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reviews.remove(position);
                notifyDataSetChanged();
            }
        });

        idInput.setText(r.getID());
        score.setText(r.getSatisfactionScore()+"");
        reviewContent.setText(r.getContent());



        return convertView;
    }
}
