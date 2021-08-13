# Description of Application

NLCamping is an Android App to provides information of camping places in the Netherlands. For the
convenience of users finding a camping park, this App will show camping parks that are categorized
into provinces in the Netherlands. Users can search camping parks upon their needs such as property
amenities. Additionally, user can save their favorite camping park in their favorite list with maximum
10 parks.

# Explanation of the features

## There are 3 lists

- List of provinces
- List of camping parks
- List of reviews (able to add (click + button)/edit (long click of the review))

## List Function

- List of provinces:
  User is not able to add/edit, since there are only 12 provinces in the Netherlands.
- List of camping parks:
  User is able to add (click + button in park list)/ edit (long click of the park item) park.
  User can also delete a park (click delete button in the park item)
- List of reviews:
  User is able to add (click + button)/edit (long click of the review) review.
  User can also delete a review (click delete button in the review item.

## Total activities

- Main Activity
- 5 types Fragments (Home, Favorite, Search, Overview and Setting fragments)
- Park list Activity
- Park Edit Add Activity
- Park Detail Activity
- Review Edit Add Activity
- Custom Park List Activity

## Total adapters

- Province Adapter (for Home Fragment)
- Park Adapter (for Park list Activity)
- Custom Park Adapter (for Custom Park List Activity)
- Expandable List Adapter (for Favorite Fragment)
- Review Adapter (for Park Detail Activity)

## Total UI components

- TextView (Overall)
- Button (Overall)
- EditText (In Park Edit Add Activity, Review Edit Add Activity)
- ImageView (Overall)
- RatingBar (In Park Adapter, Park Detail Activity and Custom Park List Activity)
- Spinner (In Setting Fragment)
- Switch (In Compound controls)

## Compound controls

- AmenitiesBarView (Used in Park Edit Add Activity, Park Detail Activity and Custom Park List
  Activity)
- AmenitiesSettingView (Used in Park Edit Add Activity)
- AmenitiesView (Used in search fragment)
- ParkDetailView (Used in Park Detail Activity, Custom Park List Activity)
- ProvinceColorView(Used in Overview Fragment)

## Custom drawing

- GraphView (Used in Favorite fragment to show how many favorite parks are in the list.
  When 10 parks are in the favorite list, the graph will show full rate.)
- PieChartView(Used in Overview fragment to show how many parks are in every provinces
  within the pie chart. )

## Language support

- NLCamping provides3 language service, English, Dutch and Korean.

## Model

- Camping Admin
- Province
- CampingPark
- Review
- PropertyAmenity

# User manual

![image](https://user-images.githubusercontent.com/57978810/129364128-65b1e45f-d26f-4edd-81e2-ea3c11a87f97.png)

1. Home Button :\
   Home screen will show you list of provinces in the Netherlands.\
2. Favorite List Button :\
   List of user’s favorite parks.\
3. Search Button:\
   User can search camping park upon their preference for parks.\
4. Overview Button:\
   User can see how many parks in every provinces within pie chart.\
5. Setting Button:\
   User can change language option of the app. (3 options : English, Dutch and
   Korean)\

# Version & Compatibility

- The application is programmed in Java (Not Kotlin) using in Android Studio 3.5.3.
- API levels: Minimum API Level: 23 (Android Marshmallow 6.0)
- Run / Build API Level: 27 (Android Oreo 8.1.0)
- The app works at least on an emulator with a Nexus 5x, with API 27 (Android Oreo 8.1.0).

# functional design

![NLcamping (1)](https://user-images.githubusercontent.com/57978810/129363915-6936a0c7-a814-4e7a-b41a-2caf35025f53.jpg)

# class diagram

![image](https://user-images.githubusercontent.com/57978810/129363422-4044a795-1185-4b39-8e18-9ff6375f17ed.png)
