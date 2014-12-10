package com.example.demos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notifications);

		TextView tvNotification = (TextView) findViewById(R.id.tvNotification);
		Intent recievedIntent = getIntent();
		String data = recievedIntent.getStringExtra("intent");
		tvNotification.setText(data);

	}

}
