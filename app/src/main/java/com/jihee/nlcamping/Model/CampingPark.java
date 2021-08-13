package com.jihee.nlcamping.Model;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class CampingPark implements Parcelable {
    private String parkName;
    private String address;
    private String phone;
    private String webSiteAddress;
    private String parkImage;
    private boolean selected;
    private PropertyAmenity amenities;

    private List<Review> reviews;

    public CampingPark(String parkName, String address, String phone, String webAddress){
        this.parkName = parkName;
        this.address = address;
        this.phone = phone;
        this.webSiteAddress = webAddress;
        reviews = new ArrayList<>();
    }

    public CampingPark(String parkName, String address, String phone, String webAddress, String image){
        this.parkName = parkName;
        this.address = address;
        this.phone = phone;
        this.webSiteAddress = webAddress;
        this.parkImage = image;
        reviews = new ArrayList<>();
    }

    public CampingPark(String parkName, String address, String phone, String webAddress, String image, PropertyAmenity amenities){
        this.parkName = parkName;
        this.address = address;
        this.phone = phone;
        this.webSiteAddress = webAddress;
        this.parkImage = image;
        this.amenities= amenities;
        reviews = new ArrayList<>();
    }


    protected CampingPark(Parcel in) {
        parkName = in.readString();
        address = in.readString();
        phone = in.readString();
        webSiteAddress = in.readString();
        parkImage = in.readString();
        selected = in.readByte() != 0;
        amenities= in.readParcelable(PropertyAmenity.class.getClassLoader());
        reviews = new ArrayList<>();
        reviews = in.readArrayList(Review.class.getClassLoader());
    }

    public static final Creator<CampingPark> CREATOR = new Creator<CampingPark>() {
        @Override
        public CampingPark createFromParcel(Parcel in) {
            return new CampingPark(in);
        }

        @Override
        public CampingPark[] newArray(int size) {
            return new CampingPark[size];
        }
    };

    public void setParkImage(String parkImage) {
        this.parkImage = parkImage;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWebSiteAddress(String webSiteAddress) {
        this.webSiteAddress = webSiteAddress;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setAmenities(PropertyAmenity amenities) {
        this.amenities = amenities;
    }

    public boolean isSelected(){
        return selected;
    }

    public String getAverageOfRating() {
        if(reviews.size()>0) {
            int sum = 0;
            for (Review r : reviews) {
                sum += r.getSatisfactionScore();
            }

            double result = sum / reviews.size();
            double output = roundToHalf(result);
            return output + "";
        }else{
            return "0";
        }
    }

    public double roundToHalf(double result) {
        double diff = result- (int)result;
        if(diff <0.25) return (int)result;
        else if(diff <0.75) return (int)result+0.5;
        else return (int)result+1;
    }

    public String getAddress() {
        return address;
    }

    public String getParkName() {
        return parkName;
    }

    public String getPhone() {
        return phone;
    }

    public String getParkImage() {
        return parkImage;
    }


    public List<Review> getReviews() {
        return reviews;
    }


    public String getWebSiteAddress() {
        return webSiteAddress;
    }

    public PropertyAmenity getAmenities() {
        return amenities;
    }

    public ArrayList<String> getParkProperties() {
        if(amenities != null) {
            ArrayList<String> parkProperties = new ArrayList<>();
            if (amenities.isTentSite()) {
                parkProperties.add("tent");
            }
            if (amenities.isCaravanSite()) {
                parkProperties.add("caravan");
            }
            if (amenities.isBungalow()) {
                parkProperties.add("bungalow");
            }
            if (amenities.isRestaurant()) {
                parkProperties.add("restaurant");
            }
            if (amenities.isSwimmingPool()) {
                parkProperties.add("pool");
            }
            if (amenities.isFreeWifi()) {
                parkProperties.add("wifi");
            }
            if (amenities.isAnimalFriendly()) {
                parkProperties.add("dog");
            }
            return parkProperties;
        }
        return null;
    }

    public void addReview(String id, String content, int score){
        Review r = new Review(id,content,score);
        reviews.add(r);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(parkName);
        dest.writeString(address);
        dest.writeString(phone);
        dest.writeString(webSiteAddress);
        dest.writeString(parkImage);
        dest.writeByte((byte) (selected ? 1 : 0));
        dest.writeParcelable(amenities,flags);
        dest.writeList(reviews);

    }
}
