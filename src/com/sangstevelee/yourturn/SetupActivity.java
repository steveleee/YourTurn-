package com.sangstevelee.yourturn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class SetupActivity extends Activity {

	EditText listenInput;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setup);
		listenInput = (EditText) findViewById(R.id.listenInput);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setup, menu);
		return true;
	}
	
	public String getInputString() {
		return listenInput.getText().toString();
	}

	private boolean parseString() {
		String input = getInputString();
		if (input.equals("")) {
			return false;
		}
		return true;
	}
	
	public void startListening(View view) {
		if (parseString()) {
			Intent newIntent = new Intent(SetupActivity.this, ListenActivity.class);
			newIntent.putExtra("listenInput", getInputString()); 
			SetupActivity.this.startActivity(newIntent);
		} return;
	}
}
