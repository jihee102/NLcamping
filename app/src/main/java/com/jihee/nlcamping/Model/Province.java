package com.jihee.nlcamping.Model;

import java.util.ArrayList;

public class Province {

    private String provinceName;
    private String flagImage;
    private String locationMap;
    private ArrayList<CampingPark> campingParks;

    public Province(String name){
        this.provinceName = name;
    }
    public void setFlagImage(String flagImage) {
        this.flagImage = flagImage;
    }

    public void setLocationMap(String locationMap) {
        this.locationMap = locationMap;
    }

    public Province(String name, String flagImage, String locationMap){
        this.provinceName = name;
        this.flagImage = flagImage;
        this.locationMap = locationMap;
        campingParks= new ArrayList<CampingPark>();
    }

    public String getProvinceName() {
        return provinceName;
    }

    public CampingPark findCampingParkByName(String name){
        for(CampingPark cp : campingParks){
            if(cp.getParkName().equals(name)){
                return cp;
            }
        }
        return null;
    }

    public void addCampingPark(String parkName, String address, String phone, String webAddress, String image){
        CampingPark cp = new CampingPark(parkName,address,phone,webAddress,image);
        campingParks.add(cp);
    }


    public void addCampingPark(String parkName, String address, String phone, String webAddress, String image, PropertyAmenity amenities){
        CampingPark cp = new CampingPark(parkName,address,phone,webAddress,image, amenities);
        campingParks.add(cp);
    }
    public void addCampingPark(CampingPark c){
        campingParks.add(c);
    }

    public String getLocationMap() {
        return locationMap;
    }

    public String getFlagImage() {
        return flagImage;
    }

    public ArrayList<CampingPark> getCampingParks() {
        return campingParks;
    }

    public ArrayList<CampingPark> getSelectedParks(){
        ArrayList<CampingPark> selectedParks = new ArrayList<>();
            for(CampingPark c:  campingParks){
                if(c.isSelected()){
                    selectedParks.add(c);
                }
            }
            if(selectedParks.size()>0){
                return selectedParks;
            }else {
                return null;
            }
    }

//    public ArrayList<CampingPark> getCustomCampingParks(ArrayList<String> customChoice) {
//        ArrayList<CampingPark> customParks = new ArrayList<>();
//            for( CampingPark c: campingParks) {
//                ArrayList<String> parks  = c.getParkProperties();
//                customChoice.removeAll(parks);
//                if(customChoice.size() == 0){
//                    return true;
//                }
//            }
//        return customParks;
//    }

}
