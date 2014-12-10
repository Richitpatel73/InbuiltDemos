package com.example.demos;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class AlertActivity extends Activity {
	MediaPlayer objPlayer;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alerts);
	}

	public void alert(View view) {
		Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
		MediaPlayer player = MediaPlayer.create(getBaseContext(), R.raw.intel);

		switch (view.getId()) {
		case R.id.btnVibrate:
			if (player.isPlaying()) {
				player.pause();
				player.stop();
			}
			long[] pattern = { 1000, 1000, 1000 };
			vibrator.vibrate(pattern, -1);
			break;
		case R.id.btnSound:
			vibrator.cancel();
			player.setLooping(false);
			player.start();
			
			break;
			
		case R.id.btnNotification:
			Intent intent = new Intent(getBaseContext(),
					NotificationsActivity.class);
			intent.putExtra("intent", "This is Richit's App");
			PendingIntent pendingIntent = PendingIntent.getActivity(
					getBaseContext(), 1, intent,
					PendingIntent.FLAG_CANCEL_CURRENT);
			NotificationCompat.Builder builder = new NotificationCompat.Builder(
					this).setSmallIcon(R.drawable.ic_launcher)
					.setContentTitle("New Notification")
					.setContentText("Goto Richit's notification")
					.setAutoCancel(true).setContentIntent(pendingIntent);
			Notification notification = builder.build();
			NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
			manager.notify(1, notification);
			break;
			
		case R.id.btnToast:
			Toast toast = Toast.makeText(this, "Toasted",
					Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 50, 250);
			toast.show();
			break;
		default:
			break;
		}
	}
}
