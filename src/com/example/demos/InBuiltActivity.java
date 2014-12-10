package com.example.demos;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

public class InBuiltActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inbuilt);
	}

	public void callInBuilt(View view) {
		switch (view.getId()) {
		case R.id.btnDial:
			Intent dialIntent = new Intent(Intent.ACTION_DIAL,
					Uri.parse("tel:5558"));
			startActivity(dialIntent);
			break;
		case R.id.btnSms:
			Intent smsIntent = new Intent(Intent.ACTION_VIEW);
			smsIntent.setData(Uri.parse("sms:5556"));
			smsIntent.putExtra("sms_body", "Welcome to the SMS service");
			startActivity(smsIntent);
			break;
		case R.id.btnCamera:
			Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			startActivity(cameraIntent);
			break;
		default:
			break;
		}
	}

}
