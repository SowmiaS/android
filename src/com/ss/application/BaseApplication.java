package com.ss.application;

import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application{

	private static Context applicationContext;

	public static Context getContext() {
		return applicationContext;
	}

	public  static void setContext(Context context) {
		applicationContext = context;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		applicationContext = getApplicationContext();
	}
}
