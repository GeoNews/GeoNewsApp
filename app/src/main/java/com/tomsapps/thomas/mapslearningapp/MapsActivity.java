package com.tomsapps.thomas.mapslearningapp;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private Map<Marker,NewsItem> newsItemWeakHashMap;
    private ArrayList<NewsItem> newsItems;

    public void SwitchToNewsItem(NewsItem newsItem){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("newsItem",newsItem);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
        GetServerData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void GetServerData(){
        ServerData serverData = new ServerData(this);
        serverData.RunServerConnectTask();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        IStoryGettingMachien dd = new DummyData();

        newsItemWeakHashMap = new HashMap<>();
        newsItems = dd.GetStories();
        for(NewsItem newsItem: newsItems){
            newsItemWeakHashMap.put(mMap.addMarker(newsItem.GetMarker()),newsItem);
        }

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
            NewsItem newsItem = newsItemWeakHashMap.get(marker);
            SwitchToNewsItem(newsItem);
            }
        });
    }

    public void AddToMap(IStoryGettingMachien iStoryGettingMachien) {
        for(NewsItem newsItem: iStoryGettingMachien.GetStories()){
            this.newsItems.add(newsItem);
            newsItemWeakHashMap.put(mMap.addMarker(newsItem.GetMarker()),newsItem);
        }
    }
}
