/**
 * 
 */
package com.tapmaster;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author Roland
 *
 */
public class StoreFragment extends Fragment {

	private Context context;
	private RelativeLayout rlayout;
	private TextView storeTitle;
	

	/* (non-Javadoc)
	 * @see android.app.Fragment#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = getActivity();
		rlayout = new RelativeLayout(context);
		storeTitle = new TextView(context);
		storeTitle.setText("Store");
		storeTitle.setPadding(10, 10, 10, 10);
		storeTitle.setTextSize(24);
		rlayout.addView(storeTitle);

	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return rlayout;
		//return super.onCreateView(inflater, container, savedInstanceState);
	}

}
