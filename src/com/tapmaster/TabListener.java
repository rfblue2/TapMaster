/**
 * 
 */
package com.tapmaster;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * @author Roland
 *
 */
public class TabListener<T extends Fragment> implements ActionBar.TabListener {

	private Fragment mFrag;
	private final Activity mActiv;
	private final String mTag;
	private final Class<T> mClass;
	
	public TabListener(Activity activity, String tag, Class<T> clz)	{
		mActiv = activity;
		mTag = tag;
		mClass = clz;
	}
	
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		if(mFrag == null)	{
			mFrag = Fragment.instantiate(mActiv, mClass.getName());
			ft.add(android.R.id.content, mFrag, mTag);
		}
		else	{
			ft.attach(mFrag);
		}
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		if(mFrag != null)	{
			ft.detach(mFrag);
		}
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

}
