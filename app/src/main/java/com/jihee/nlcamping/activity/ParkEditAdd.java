package com.jihee.nlcamping.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jihee.nlcamping.Model.CampingAdmin;
import com.jihee.nlcamping.Model.CampingPark;
import com.jihee.nlcamping.Model.PropertyAmenity;
import com.jihee.nlcamping.R;
import com.jihee.nlcamping.compoundControl.AmenitiesBarView;
import com.jihee.nlcamping.compoundControl.AmenitiesSettingView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ParkEditAdd extends AppCompatActivity {

        private EditText parkName, parkAddress, parkPhone, parkWebsite;
        private ImageView parkPicture;
        private AmenitiesSettingView amenitiesSettingView;
        private int provincePosition;
        private int parkPosition;
        private int newOrOld;
        private boolean isNewPark;
        private CampingPark campingPark;
        private static final int IMAGE_CAPTURE_REQUEST = 4000;
        private Bitmap bitmap;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_park_eidit_add);

            Intent intent = getIntent();

            newOrOld = intent.getIntExtra(ParkListActivity.PARK_POSITION, -3);
            provincePosition = intent.getIntExtra(ParkListActivity.PROVINCE_POSITION, -1);
            parkName = findViewById(R.id.parkNameEdit);
            parkAddress = findViewById(R.id.parkAddressEdit);
            parkPhone = findViewById(R.id.parkPhoneEdit);
            parkWebsite = findViewById(R.id.parkWebsiteEdit);
            parkPicture = findViewById(R.id.parkPictureEdit);
            amenitiesSettingView = findViewById(R.id.amenitySetting);
            if(newOrOld == -200){
                isNewPark = true;
            }


            if (!isNewPark) {
                parkPosition = intent.getIntExtra(ParkListActivity.PARK_POSITION, -2);
                campingPark = CampingAdmin.provinces.get(provincePosition).getCampingParks().get(parkPosition);
                parkName.setText(campingPark.getParkName());
                parkAddress.setText(campingPark.getAddress());
                parkPhone.setText(campingPark.getPhone());
                parkWebsite.setText(campingPark.getWebSiteAddress());
                amenitiesSettingView.setTent(campingPark.getAmenities().isTentSite());
                amenitiesSettingView.setCaravan(campingPark.getAmenities().isCaravanSite());
                amenitiesSettingView.setBungalow(campingPark.getAmenities().isBungalow());
                amenitiesSettingView.setRestaurant(campingPark.getAmenities().isRestaurant());
                amenitiesSettingView.setPool(campingPark.getAmenities().isSwimmingPool());
                amenitiesSettingView.setWifi(campingPark.getAmenities().isFreeWifi());
                amenitiesSettingView.setDog(campingPark.getAmenities().isAnimalFriendly());

                if (!checkImageFile()) {
                    InputStream inputStream = null;
                    try {
                        String imageFile = campingPark.getParkImage();
                        inputStream = getApplicationContext().getAssets().open(imageFile);
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
                }

            }
        }

        private boolean checkImageFile() {
            ContextWrapper cw = new ContextWrapper(getApplicationContext());
            Context context = getApplicationContext();
            File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
            File myPath = new File(directory, campingPark.getParkName() + ".jpg");

            if (myPath != null) {
                parkPicture.setImageDrawable(Drawable.createFromPath(myPath.toString()));
                return true;
            }
            return false;
        }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
            if (isNewPark) {
                String pName = parkName.getText().toString();
                String pAddress = parkAddress.getText().toString();
                String pWeb = parkWebsite.getText().toString();
                String pPhone = parkPhone.getText().toString();
                PropertyAmenity propertyAmenity= getAmenitiesChange();

                CampingPark parkObject = new CampingPark(pName, pAddress, pPhone, pWeb);
                parkObject.setAmenities(propertyAmenity);
                String filePath = saveToInternalStorage(bitmap, parkObject);
                parkObject.setParkImage(filePath + "/" + parkObject.getParkName() + ".jpg");
                CampingAdmin.provinces.get(provincePosition).getCampingParks().add(parkObject);


            } else {
                String pName = parkName.getText().toString();
                String pAddress = parkAddress.getText().toString();
                String pWeb = parkWebsite.getText().toString();
                String pPhone = parkPhone.getText().toString();
                PropertyAmenity propertyAmenity= getAmenitiesChange();
                CampingAdmin.provinces.get(provincePosition).getCampingParks().get(parkPosition).setParkName(pName);
                CampingAdmin.provinces.get(provincePosition).getCampingParks().get(parkPosition).setAddress(pAddress);
                CampingAdmin.provinces.get(provincePosition).getCampingParks().get(parkPosition).setPhone(pPhone);
                CampingAdmin.provinces.get(provincePosition).getCampingParks().get(parkPosition).setWebSiteAddress(pWeb);
                CampingAdmin.provinces.get(provincePosition).getCampingParks().get(parkPosition).setAmenities(propertyAmenity);

            }
        }

    private PropertyAmenity getAmenitiesChange() {
            boolean tent = amenitiesSettingView.getSwTent();
            boolean caravan = amenitiesSettingView.getSwCaravan();
            boolean bungalow = amenitiesSettingView.getSwBungalow();
            boolean wifi = amenitiesSettingView.getSwWifi();
            boolean restaurant = amenitiesSettingView.getSwRestaurant();
            boolean dog = amenitiesSettingView.getSwDog();
            boolean pool = amenitiesSettingView.getSwPool();

            return new PropertyAmenity(tent,caravan,bungalow,wifi,restaurant,dog,pool);
    }

    @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == IMAGE_CAPTURE_REQUEST && resultCode == Activity.RESULT_OK) {
                bitmap = (Bitmap) data.getExtras().get("data");
                parkPicture.setImageBitmap(bitmap);
                if (!isNewPark) {
                    String filePath = saveToInternalStorage(bitmap, campingPark);
                    CampingAdmin.provinces.get(provincePosition).getCampingParks().get(parkPosition).setParkImage(filePath + "/" + campingPark.getParkName() + ".jpg");
                }
            }
        }

        public String saveToInternalStorage(Bitmap bitmap, CampingPark parkObject) {
            ContextWrapper cw = new ContextWrapper(getApplicationContext());
            Context context = getApplicationContext();

            File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);

            File myPath = new File(directory, parkObject.getParkName() + ".jpg");

            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(myPath);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return directory.getAbsolutePath();
        }

        public void whenSavePressed(View view) {
            Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
            onBackPressed();
        }

        public void addImage(View view) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, IMAGE_CAPTURE_REQUEST);
        }

    }
