package com.tomsapps.thomas.mapslearningapp; /**
 * Created by Thomas on 3/10/2015.
 */

import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.Time;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class NewsItem implements Parcelable {

    private String journalistName;
    private String headLine;
    private String storyText;
    private double Lat;
    private double Lng;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    public String getStoryText() {
        return storyText;
    }

    public String getHeadLine() {
        return headLine;
    }

    public void setHeadline(String headLineText){
        if (headLineText != null) {
            headLine = headLineText;
        } else {
            headLine = "Failed to set headline correctly";
        }
    }

    public String getJournalistName() { return journalistName; }

    public Time getStoryDateTime() {
        Time time = new Time();
        time.set(0,minute,hour,day,month,year);
        return time;
    }

    public NewsItem(Journalist author, String headLine, String storyText, LatLng pointOnMap, Time time) {
        this.journalistName = author.toString();
        this.headLine = headLine;
        this.storyText = storyText;
        this.Lat = pointOnMap.latitude;
        this.Lng = pointOnMap.longitude;
        this.year = time.year;
        this.month = time.month;
        this.day = time.monthDay;
        this.hour = time.hour;
        this.minute = time.minute;
    }

    public NewsItem(Time time) {
        this.year = time.year;
        this.month = time.month;
        this.day = time.monthDay;
        this.hour = time.hour;
        this.minute = time.minute;
    }

    public NewsItem(Parcel in) throws Exception{
        this.headLine = in.readString();
        this.storyText = in.readString();
        this.journalistName = in.readString();
        this.Lat = in.readDouble();
        this.Lng = in.readDouble();
        this.year = in.readInt();
        this.month = in.readInt();
        this.day = in.readInt();
        this.hour = in.readInt();
        this.minute = in.readInt();
    }

    public MarkerOptions GetMarker(){
        MarkerOptions mo = new MarkerOptions().position(new LatLng(Lat,Lng)).title(headLine).snippet(intro());

        return mo;
    }

    private String intro(){
        return storyText != null? storyText.substring(0,25) + "..." : "No text downloaded";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(headLine);
        out.writeString(storyText);
        out.writeString(journalistName);
        out.writeDouble(Lat);
        out.writeDouble(Lng);
        out.writeInt(year);
        out.writeInt(month);
        out.writeInt(day);
        out.writeInt(hour);
        out.writeInt(minute);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<NewsItem> CREATOR = new Parcelable.Creator<NewsItem>() {
        public NewsItem createFromParcel(Parcel in) {
            try {
                return new NewsItem(in);
            } catch (Exception e){
                return null;
            }
        }

        public NewsItem[] newArray(int size) {
            return new NewsItem[size];
        }
    };

    public void setLat(double lat) {
        Lat = lat;
    }

    public void setLng(double lng) {
        Lng = lng;
    }
}
