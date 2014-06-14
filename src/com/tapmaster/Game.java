package com.tapmaster;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Game extends Activity {

	private Button b;
	private TextView tvMoney;
	private Context context;
	private RelativeLayout rlayout;
	private Player p;
	private int rlayoutHeight;
	private int rlayoutWidth;
	
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
		
		ViewTreeObserver vto = rlayout.getViewTreeObserver(); 
		vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener() { 
		    @Override 
		    public void onGlobalLayout() { 
		        rlayout.getViewTreeObserver().removeOnGlobalLayoutListener(this); 
		        rlayoutWidth  = rlayout.getMeasuredWidth();
		        rlayoutHeight = rlayout.getMeasuredHeight(); 
		        addButton();//initial button
		    } 
		});
		
	}
	
	public void addButton()	{
		b = new Button(context);
		b.setText(String.valueOf((int)(Math.random() * 5) + 1));
		int x = (int) (Math.random() * (rlayoutWidth * .8));
		int y = (int) (Math.random() * (rlayoutHeight * .8));
		int s = (int) ((rlayoutHeight * .2 + rlayoutWidth * .2) / 2);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(s, s);
		params.leftMargin = x;
		params.topMargin = y;
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
