package com.example.demos;

import android.R.color;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MenuActivity extends Activity {

	Menu menu;
	Button btnOption;
	Button btnContext;
	Button btnPopup;
	PopupMenu popUp;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		menu = (Menu) findViewById(R.menu.optionsmenu);
		btnContext = (Button) findViewById(R.id.btnContext);
		btnPopup = (Button) findViewById(R.id.btnPopup);

		registerForContextMenu(btnContext);

		popUp = new PopupMenu(getBaseContext(), btnPopup);
		popUp.inflate(R.menu.popupmenu);
		
		btnPopup.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				popUp.show();
			}
		});
		
		popUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem item) {
				switch (item.getItemId()) {
				case R.id.itemRed:
					btnPopup.setBackgroundResource(color.holo_red_light);
					break;
				case R.id.itemGreen:
					btnPopup.setBackgroundResource(color.holo_green_light);
					break;
				case R.id.itemBlue:
					btnPopup.setBackgroundResource(color.holo_blue_light);
					break;
				}
				return true;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.optionsmenu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemSelected = 0;
		Intent optionItemIntent = new Intent(getBaseContext(),
				OptionItemActivity.class);
		switch (item.getItemId()) {
		case R.id.itemAboutUs:
			itemSelected = 1;
			break;
		case R.id.itemHelp:
			itemSelected = 2;
			break;
		case R.id.itemFAQ:
			itemSelected = 3;
			break;
		case R.id.itemContactUs:
			itemSelected = 4;
			break;
		default:
			itemSelected = 0;
			break;
		}
		optionItemIntent.putExtra("itemSelected", itemSelected);
		startActivity(optionItemIntent);
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		MenuInflater contextInflater = getMenuInflater();
		contextInflater.inflate(R.menu.contextmenu, menu);
		super.onCreateContextMenu(menu, v, menuInfo);
		
	}
}
