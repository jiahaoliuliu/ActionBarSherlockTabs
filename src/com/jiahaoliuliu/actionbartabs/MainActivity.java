package com.jiahaoliuliu.actionbartabs;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends SherlockFragmentActivity {

	// store the active tab here
	public static String ACTIVE_TAB = "activeTab";
	private ActionBar actionBar;
	
	private String[] tabs = {"Tab 1", "Tab 2"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		actionBar = getSupportActionBar();
		for (String tabTitle : tabs) {
			ActionBar.Tab tab = actionBar.newTab().setText(tabTitle)
					.setTabListener(tabListener);
			actionBar.addTab(tab);
		}
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
	  // save active tab
	  outState.putInt(ACTIVE_TAB,
	          getSupportActionBar().getSelectedNavigationIndex());
	  super.onSaveInstanceState(outState);
	}
	
	private ActionBar.TabListener tabListener = new ActionBar.TabListener() {
		@Override
		public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
		    // When the given tab is selected, show the tab contents in the
		    // container view.
		    Fragment fragment = new WhiteFragment();
			if (tab.getText().equals("Tab 2")) {
				fragment = new BlackFragment();
			}
		    getSupportFragmentManager().beginTransaction()
		        .replace(R.id.content_frame, fragment).commit();		}

		@Override
		public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
		}

		@Override
		public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
		}
	};
}
