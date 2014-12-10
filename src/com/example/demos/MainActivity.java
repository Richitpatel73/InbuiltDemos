package com.example.demos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
	}

	public void goTo(View view) {
		switch (view.getId()) {
		case R.id.btnMenu:
			Intent menusIntent = new Intent(getBaseContext(),
					MenuActivity.class);
			startActivity(menusIntent);
			break;
		case R.id.btnAlert:
			Intent alertsIntent = new Intent(this, AlertActivity.class);
			startActivity(alertsIntent);
			break;
		case R.id.btnInBuilt:
			Intent inBuiltIntent = new Intent(getBaseContext(),
					InBuiltActivity.class);
			startActivity(inBuiltIntent);
			break;

		default:
			break;
		}
	}

	public void exit(View view) {
		finish();
	}
}
