package com.jihee.nlcamping.apdater;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jihee.nlcamping.Model.CampingAdmin;
import com.jihee.nlcamping.Model.CampingPark;
import com.jihee.nlcamping.Model.Province;
import com.jihee.nlcamping.R;
import com.jihee.nlcamping.activity.ParkDetailActivity;
import com.jihee.nlcamping.activity.ParkListActivity;

import java.util.List;

public class ParkAdapter extends ArrayAdapter {
    public static final String PROVINCE_POSITION = "provincePosition";
    public static final String PARK_POSITION = "parkPosition";
    private LayoutInflater layoutInflater;
    private List<CampingPark> parks;
    private Button detailButton, deleteButton, addMyListButton;
    private TextView parkName;
    private RatingBar parkRating;
    private int provincePosition;
    private Context context;

    public ParkAdapter(@NonNull Context context, @NonNull List objects) {
        super(context, R.layout.park_list,objects);
        this.layoutInflater = LayoutInflater.from(context);
        this.parks = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final CampingPark c = parks.get(position);
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.park_list,parent,false);
        }
        provincePosition = ParkListActivity.provincePosition;


        deleteButton = convertView.findViewById(R.id.removeParkButton);
        detailButton = convertView.findViewById(R.id.parkDetailbutton);
        addMyListButton = convertView.findViewById(R.id.addMyListButton);
        if(c.isSelected()){
            Drawable top = getContext().getDrawable(R.drawable.ic_favorite_pink);
            addMyListButton.setCompoundDrawablesWithIntrinsicBounds(null,top,null,null);
        }else {
            Drawable top = getContext().getDrawable(R.drawable.ic_favorite_border_black);
            addMyListButton.setCompoundDrawablesWithIntrinsicBounds(null,top,null,null);
        }
        parkName = convertView.findViewById(R.id.parkName);
        parkRating = convertView.findViewById(R.id.parkRatingBar);


        parkName.setText(c.getParkName());

        parkRating.setRating(Float.parseFloat(c.getAverageOfRating()));
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ParkDetailActivity.class);
                intent.putExtra(PROVINCE_POSITION,provincePosition);
                intent.putExtra(PARK_POSITION,position);
                context.startActivity(intent);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parks.remove(position);
                notifyDataSetChanged();
            }
        });

        addMyListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkMaxFavorite() <10){
                    if(c.isSelected()){
                        c.setSelected(false);
                        notifyDataSetChanged();
                        Toast.makeText(getContext(), "Removed from My Favorite list.", Toast.LENGTH_LONG).show();
                    }else{
                        c.setSelected(true);
                        notifyDataSetChanged();
                        Toast.makeText(getContext(), "Added to My Favorite list.", Toast.LENGTH_LONG).show();
                    }
                }else{
                    if(c.isSelected()){
                        c.setSelected(false);
                        notifyDataSetChanged();
                        Toast.makeText(getContext(), "Removed from My Favorite list.", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getContext(), "Sorry, The favorite storage is already full.", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });





        return convertView;
    }

    public int checkMaxFavorite() {
        int count=0;
        for (Province p : CampingAdmin.provinces) {
            if (p.getSelectedParks() != null) {
                count += p.getSelectedParks().size();
            }
        }
        return count;
    }


}
