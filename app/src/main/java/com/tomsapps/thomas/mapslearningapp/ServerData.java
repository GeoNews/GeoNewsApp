package com.tomsapps.thomas.mapslearningapp;

import android.text.format.Time;
import android.util.JsonReader;
import android.util.JsonToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.net.URL;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Thomas on 6/11/2015.
 */
public class ServerData implements IStoryGettingMachien {

    private ArrayList<NewsItem> storyList;
    private JsonReader jsonReader;
    private URL url;
    private MapsActivity mapsActivity;

//    JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
//    storyList = getNewsItemsFromJson(reader);
//    reader.close();

    public ServerData(MapsActivity mapsActivity) {
        storyList = new ArrayList<>();
        this.mapsActivity = mapsActivity;
        try{
            url = new URL("http://geonews.azurewebsites.net/api/StoryLocation");
        } catch (MalformedURLException ex){
            System.out.println("You fucked up the URL again");
        }
    }

    public void AddToStoryList(ArrayList<NewsItem> newsItems){
        storyList.addAll(newsItems);
    }

    public void SubmitToMap(){
        mapsActivity.AddToMap(this);
    }

    public void RunServerConnectTask(){
        ServerConnectTask task = new ServerConnectTask(this);
        task.execute(url);
    }

    public void RunJsonParseTask(){
        JsonParseTask task = new JsonParseTask(this);
        task.execute(jsonReader);
    }

    public ArrayList<NewsItem> GetStories(){
        return storyList;
    }

    public JsonReader getJsonReader() {
        return jsonReader;
    }

    public void setJsonReader(JsonReader jsonReader) {
        this.jsonReader = jsonReader;
    }
}
