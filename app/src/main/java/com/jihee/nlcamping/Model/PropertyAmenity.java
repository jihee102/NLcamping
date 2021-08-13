package com.jihee.nlcamping.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class PropertyAmenity implements Parcelable {
    private boolean isTentSite;
    private boolean isCaravanSite;
    private boolean isBungalow;
    private boolean isFreeWifi;
    private boolean isRestaurant;
    private boolean isAnimalFriendly;
    private boolean isSwimmingPool;

    public PropertyAmenity(boolean isTentSite, boolean isCaravanSite, boolean isBungalow,
                           boolean isFreeWifi, boolean isRestaurant, boolean isAnimalFriendly, boolean isSwimmingPool){
        this.isTentSite= isTentSite;
        this.isCaravanSite = isCaravanSite;
        this.isBungalow = isBungalow;
        this.isFreeWifi =isFreeWifi;
        this.isRestaurant = isRestaurant;
        this.isAnimalFriendly = isAnimalFriendly;
        this.isSwimmingPool= isSwimmingPool;

    }

    protected PropertyAmenity(Parcel in) {
        isTentSite = in.readByte() != 0;
        isCaravanSite = in.readByte() != 0;
        isBungalow = in.readByte() != 0;
        isFreeWifi = in.readByte() != 0;
        isRestaurant = in.readByte() != 0;
        isAnimalFriendly = in.readByte() != 0;
        isSwimmingPool = in.readByte() != 0;
    }

    public static final Creator<PropertyAmenity> CREATOR = new Creator<PropertyAmenity>() {
        @Override
        public PropertyAmenity createFromParcel(Parcel in) {
            return new PropertyAmenity(in);
        }

        @Override
        public PropertyAmenity[] newArray(int size) {
            return new PropertyAmenity[size];
        }
    };

    public boolean isAnimalFriendly() {
        return isAnimalFriendly;
    }

    public boolean isBungalow() {
        return isBungalow;
    }

    public boolean isCaravanSite() {
        return isCaravanSite;
    }

    public boolean isFreeWifi() {
        return isFreeWifi;
    }

    public boolean isTentSite() {
        return isTentSite;
    }

    public boolean isRestaurant() {
        return isRestaurant;
    }

    public boolean isSwimmingPool() {
        return isSwimmingPool;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (isTentSite ? 1 : 0));
        dest.writeByte((byte) (isCaravanSite ? 1 : 0));
        dest.writeByte((byte) (isBungalow ? 1 : 0));
        dest.writeByte((byte) (isFreeWifi ? 1 : 0));
        dest.writeByte((byte) (isRestaurant ? 1 : 0));
        dest.writeByte((byte) (isAnimalFriendly ? 1 : 0));
        dest.writeByte((byte) (isSwimmingPool ? 1 : 0));
    }
}
