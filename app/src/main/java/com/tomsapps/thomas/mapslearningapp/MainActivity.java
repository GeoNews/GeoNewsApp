package com.tomsapps.thomas.mapslearningapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;


public class MainActivity extends ActionBarActivity {

    private NewsItem newsItem;
    private TextView author, title, mainBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsItem = getIntent().getParcelableExtra("newsItem");
        author = (TextView)findViewById(R.id.textViewAuthor);
        title = (TextView)findViewById(R.id.textViewTitle);
        mainBody = (TextView)findViewById(R.id.textViewMainBody);
        mainBody.setMovementMethod(new ScrollingMovementMethod());
        author.setText(newsItem.getJournalistName());
        title.setText(newsItem.getHeadLine());
        mainBody.setText(newsItem.getStoryText());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        } else if (id == R.id.mobileServiceTest){
            try {
                Intent intent = new Intent(this, MobileServiceActivity.class);
                startActivity(intent);
            } catch (Exception ex){
                mainBody.setText(ex.getMessage());
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
