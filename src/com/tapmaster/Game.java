package com.tapmaster;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Game extends Activity {

	private Button b;
	private TextView tvMoney;
	private Context context;
	private RelativeLayout rlayout;
	private Player p;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		context = this;
		p = new Player("Player1");
		rlayout = (RelativeLayout) findViewById(R.id.game_layout);
		tvMoney = new TextView(context);
		tvMoney.setText("0");
		rlayout.addView(tvMoney);
		addButton();
	}
	
	public void addButton()	{
		b = new Button(context);
		b.setText(String.valueOf((int)(Math.random() * 5) + 1));
		int x = (int) (Math.random() * (rlayout.getWidth() * .8));
		int y = (int) (Math.random() * (rlayout.getHeight() * .8));
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(100, 100);
		params.leftMargin = x;
		params.topMargin = y;
		System.out.println("position: "+x+","+y);
		Log.d("INFO", "position: "+x+","+y);
		rlayout.addView(b, params);
		b.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				p.addMoney(Integer.valueOf(b.getText().toString()));
				tvMoney.setText(String.valueOf(p.getMoney()));
				rlayout.removeView(b);
				addButton();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

}
