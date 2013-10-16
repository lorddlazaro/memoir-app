package com.example.memoir;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class LinkPhaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_link_phase);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.link_phase, menu);
		return true;
	}

}
