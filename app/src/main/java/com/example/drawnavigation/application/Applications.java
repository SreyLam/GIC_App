package com.example.drawnavigation.application;


import android.app.Application;


public class Applications extends Application
{
    private static Application appInstance;

    @Override
    public void onCreate()
    {
        super.onCreate();
        appInstance=this;
    }
    public static Application getAppInstance()
    {
        if(appInstance==null)
        {
            appInstance=new Applications();
        }
        return appInstance;
    }

}
