package com.example.appsforgood;

import android.app.Application;

public class Controller extends Application
{
    private Question myData = new Question("Default", "Default", "Default", "Default", "Default");

    public Question getData() {
        return myData;
    }
}
