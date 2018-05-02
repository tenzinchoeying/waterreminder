package com.example.a1959freetibet.waterreminder;

import android.app.Application;

public class IntroApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		Globals.init(this);
	}
}
