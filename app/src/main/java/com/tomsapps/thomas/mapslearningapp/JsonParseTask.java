package com.tomsapps.thomas.mapslearningapp;

import android.os.AsyncTask;
import android.text.format.Time;
import android.util.JsonReader;

import com.tomsapps.thomas.mapslearningapp.NewsItem;
import com.tomsapps.thomas.mapslearningapp.ServerData;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Thomas on 6/15/2015.
 */
public class JsonParseTask extends AsyncTask<JsonReader, Integer, ArrayList<NewsItem>> {

    private ServerData serverData;
    private ArrayList<Exception> caughtExceptions;

    public JsonParseTask(ServerData serverData) {
        this.serverData = serverData;
        caughtExceptions = new ArrayList<>();
    }

    @Override
    protected ArrayList<NewsItem> doInBackground(JsonReader... params) {
        JsonReader jsonReader = params[0];
        ArrayList<NewsItem> newsItems = new ArrayList<>();
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()){
                try {
                    jsonReader.beginObject();
                    Time now = new Time();
                    now.setToNow();
                    NewsItem newsItem = new NewsItem(now);
                    try {
                        while (jsonReader.hasNext()){
                            String name = jsonReader.nextName();
                            if (name.equals("id")){
                                jsonReader.skipValue();
                            } else if (name.equals("HeadLine")){
                                newsItem.setHeadline(jsonReader.nextString());
                            } else if (name.equals("Latitude")){
                                newsItem.setLat(jsonReader.nextDouble());
                            } else if (name.equals("Longitude")){
                                newsItem.setLng(jsonReader.nextDouble());
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                    } catch (Exception ex){
                        caughtExceptions.add(ex);
                    }
                    newsItems.add(newsItem);
                    jsonReader.endObject();
                } catch (Exception ex){
                    caughtExceptions.add(ex);
                }
            }
            jsonReader.endArray();
        } catch (IOException IOex){
            caughtExceptions.add(IOex);
        } catch (Exception ex){
            caughtExceptions.add(ex);
        }
        return newsItems;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(ArrayList<NewsItem> newsItems) {
        super.onPostExecute(newsItems);
        serverData.AddToStoryList(newsItems);
        for (Exception exception: caughtExceptions){
            System.out.println(exception.getClass().getSimpleName());
        }
        System.out.println("Number of news items: " + newsItems.size());
        serverData.SubmitToMap();
    }
}
