package com.benchelbikh.architecture.utils;

import android.app.Application;
import android.util.Log;

import com.benchelbikh.architecture.buisness.DefaultService;
import com.benchelbikh.architecture.dao.MemoryUserDao;


public class MyContext extends Application {

    private DefaultService ds ;


    public MyContext() {
        ds = new DefaultService();

    }

    public DefaultService getDs() {
        return ds;
    }
}
