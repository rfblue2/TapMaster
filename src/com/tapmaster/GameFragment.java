/**
 * 
 */
package com.tapmaster;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author Roland
 *
 */
public class GameFragment extends Fragment {

	private Button b;
	private TextView tvMoney;
	private Context context;
	private RelativeLayout rlayout;
	private Player p;
	private int rlayoutHeight;
	private int rlayoutWidth;

	/* (non-Javadoc)
	 * @see android.app.Fragment#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = getActivity();
		rlayout = new RelativeLayout(context);
		p = new Player("Player1");
		tvMoney = new TextView(context);
		tvMoney.setText("0");
		tvMoney.setPadding(10, 10, 10, 10);
		tvMoney.setTextSize(24);
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

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return rlayout;
	}
	
	public void addButton()	{
		b = new Button(context);
		b.setText(String.valueOf((int)(Math.random() * 5) + 1));
		b.setTextSize(24);
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

}
