package com.example.demos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class OptionItemActivity extends Activity {
	int itemSelected = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_option_item);
		Intent recieveIntent = getIntent();
		itemSelected = recieveIntent.getIntExtra("itemSelected", 0);
	}

	@Override
	protected void onStart() {
		super.onStart();
		switch (itemSelected) {
		case 1:
			setContentView(R.layout.aboutus);
			break;
		case 2:
			setContentView(R.layout.help);
			break;
		case 3:
			setContentView(R.layout.faq);
			break;
		case 4:
			setContentView(R.layout.contactus);
			break;
		default:
			break;
		}
	}

}
