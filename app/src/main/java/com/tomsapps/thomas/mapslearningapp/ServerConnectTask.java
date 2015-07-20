package com.tomsapps.thomas.mapslearningapp;

import android.os.AsyncTask;
import android.util.JsonReader;

import com.tomsapps.thomas.mapslearningapp.MapsActivity;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Thomas on 6/15/2015.
 */
public class ServerConnectTask extends AsyncTask<URL, Integer, JsonReader> {

    private ServerData serverData;
    private ArrayList<Exception> caughtExceptions;

    public ServerConnectTask(ServerData serverData) {
        this.serverData = serverData;
        caughtExceptions = new ArrayList<>();
    }

    @Override
    protected JsonReader doInBackground(URL... params) {
        JsonReader jsonReader = null;
        try{
            HttpURLConnection urlConnection = (HttpURLConnection) params[0].openConnection();
            jsonReader = new JsonReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
        } catch (Exception ex){
            caughtExceptions.add(ex);
        }
        return jsonReader;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//        System.out.print("Started background Thread");
    }

    @Override
    protected void onPostExecute(JsonReader jsonReader) {
        super.onPostExecute(jsonReader);
//        System.out.print("Finished background thread");
        serverData.setJsonReader(jsonReader);
//        for (Exception exception: caughtExceptions){
//            System.out.print(exception.getClass().getSimpleName());
//        }
        serverData.RunJsonParseTask();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}
