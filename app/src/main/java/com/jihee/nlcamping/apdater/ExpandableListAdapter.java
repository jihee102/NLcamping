package com.jihee.nlcamping.apdater;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jihee.nlcamping.Model.CampingPark;
import com.jihee.nlcamping.Model.Province;
import com.jihee.nlcamping.R;
import com.jihee.nlcamping.activity.ParkDetailActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter{
    public static final String PARK_POSITION = "parkPosition";
    public static final String PROVINCE_POSITION = "provincePosition";
    public static final String ADD_NEW_PARK = "addNewPark";
    private Context context;
    private List<Province> listOfProvince;
    private HashMap<String , List<CampingPark>> listOfParks;

    public ExpandableListAdapter(Context context, List<Province> listOfProvince, HashMap<String, List<CampingPark>> listOfParks){
        this.context = context;
        this.listOfProvince = listOfProvince;
        this.listOfParks = listOfParks;

    }

    @Override
    public int getGroupCount() {
        return listOfProvince.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listOfParks.get(listOfProvince.get(groupPosition).getProvinceName()).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listOfProvince.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listOfParks.get(listOfProvince.get(groupPosition).getProvinceName()).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Province group = (Province) getGroup(groupPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_group,null);

        }
        TextView provinceName = convertView.findViewById(R.id.provinceNameInGroupList);
        provinceName.setText(listOfProvince.get(groupPosition).getProvinceName());


        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final CampingPark child =(CampingPark) getChild(groupPosition,childPosition);
        if(convertView== null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_child,null);
        }

        Button detailButton = convertView.findViewById(R.id.parkDetailbutton);
        Button addMyListButton = convertView.findViewById(R.id.addMyListButton);
        if(child.isSelected()){
            Drawable top = context.getDrawable(R.drawable.ic_favorite_pink);
            addMyListButton.setCompoundDrawablesWithIntrinsicBounds(null,top,null,null);
        }else {
            Drawable top = context.getDrawable(R.drawable.ic_favorite_border_black);
            addMyListButton.setCompoundDrawablesWithIntrinsicBounds(null,top,null,null);
        }
        TextView parkName = convertView.findViewById(R.id.parkName);


        parkName.setText(child.getParkName());


        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ParkDetailActivity.class);
                intent.putExtra(PROVINCE_POSITION,groupPosition);
                intent.putExtra(PARK_POSITION,childPosition);
                context.startActivity(intent);
            }
        });


        addMyListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(child.isSelected()){
                    child.setSelected(false);
                    notifyDataSetChanged();
                    Toast.makeText(context, "Removed from My Favorite list.", Toast.LENGTH_LONG).show();
                }else{
                    child.setSelected(true);
                    notifyDataSetChanged();
                    Toast.makeText(context, "Added to My Favorite list.", Toast.LENGTH_LONG).show();
                }

            }
        });




        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
