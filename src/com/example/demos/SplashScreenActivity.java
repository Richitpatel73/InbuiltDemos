package com.example.demos;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		Handler handler = new Handler();

		handler.postDelayed(new Runnable() {

			@Override
			public void run() {
				Intent intent = new Intent(getBaseContext(), MainActivity.class);
				startActivity(intent);
				finish();
			}
		}, 3000);
	}
}
