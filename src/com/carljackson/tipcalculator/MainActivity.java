package com.carljackson.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void calculateTip(View view) {
		Button btTipAmount = (Button)view;
		TextView tvTipAmount = (TextView) findViewById(R.id.tvTipAmount);
		EditText etBillAmount = (EditText) findViewById(R.id.etBillAmount);

		float tipAmount = 0;
		float tipPercent = Integer.parseInt(btTipAmount.getText().toString().substring(0,2));
		try {
			float billAmount = Float.parseFloat(etBillAmount.getText().toString());
			tipAmount = billAmount * (1 + tipPercent/100);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		tvTipAmount.setText(String.format("$%.2f", tipAmount));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
