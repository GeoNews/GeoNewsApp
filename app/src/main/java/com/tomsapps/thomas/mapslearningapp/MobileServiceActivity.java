package com.tomsapps.thomas.mapslearningapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.microsoft.windowsazure.mobileservices.*;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.TableOperationCallback;

import java.net.MalformedURLException;
import java.util.ArrayList;


public class MobileServiceActivity extends ActionBarActivity {

    private MobileServiceClient mClient;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_service);
        textView = (TextView)findViewById(R.id.textViewMainThing);
        try {
            mClient = new MobileServiceClient(
                    "https://geonewsmobileservice4.azure-mobile.net/",
                    "LvKnWSprNxhjKOPyrknpFkCPScFcsg70",
                    this
            );
        } catch (MalformedURLException ex){
            textView.setText(ex.getMessage());
        }
        if (mClient != null){
            ArrayList<NewsItem> newsItems = new DummyData().GetStories();
            NewsItem newsItem = newsItems.get(1);
            mClient.getTable(NewsItem.class).insert(newsItem, new TableOperationCallback<NewsItem>() {
                public void onCompleted(NewsItem entity, Exception exception, ServiceFilterResponse response) {
                    if (exception == null) {
                        textView.setText("it fucking worked");
                    } else {
                        textView.setText("Fucked up");
                    }
                }
            });
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mobile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
