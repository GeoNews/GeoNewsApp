package com.tomsapps.thomas.mapslearningapp;

/**
 * Created by Thomas on 3/9/2015.
 */
public class Journalist {

    private String firstName;
    private String lastName;

    public Journalist(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return firstName + " " + lastName;
    }
}
