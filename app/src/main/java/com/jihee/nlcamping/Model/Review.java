package com.jihee.nlcamping.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Review implements Parcelable {
    private String ID;
    private String content;
    private int satisfactionScore;

    public Review(String id, String content, int score){
        this.ID = id;
        this.content = content;
        this.satisfactionScore = score;
    }

    protected Review(Parcel in) {
        ID = in.readString();
        content = in.readString();
        satisfactionScore = in.readInt();
    }

    public static final Creator<Review> CREATOR = new Creator<Review>() {
        @Override
        public Review createFromParcel(Parcel in) {
            return new Review(in);
        }

        @Override
        public Review[] newArray(int size) {
            return new Review[size];
        }
    };

    public int getSatisfactionScore() {
        return satisfactionScore;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setSatisfactionScore(int satisfactionScore) {
        this.satisfactionScore = satisfactionScore;
    }

    public String getID() {
        return ID;
    }

    public String getContent() {
        return content;
    }

    public String toString(){
        return content +"   by "+ID +"\n";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ID);
        dest.writeString(content);
        dest.writeInt(satisfactionScore);
    }
}
