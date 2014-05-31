package com.jiahaoliuliu.actionbartabs;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;

import android.os.Bundle;

public class MainActivity extends SherlockFragmentActivity {
	  // store the active tab here
	  public static String ACTIVE_TAB = "activeTab";

	  @Override
	  public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    final ActionBar actionBar = getSupportActionBar();
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    // add the first tab which is an instance of TabFragment1
	    Tab tab1 = actionBar.newTab()
	              .setText("TabTitle 1")
	              .setTabListener(new TabListener<WhiteFragment>(
	               this, "tab1", WhiteFragment.class));
	    actionBar.addTab(tab1);

	    // add the second tab which is an instance of TabFragment2
	    Tab tab2 = actionBar.newTab()
	           .setText("TabTitle 2")
	           .setTabListener(new TabListener<BlackFragment>(
	                this, "tab2", BlackFragment.class));
	    actionBar.addTab(tab2);

	    // add the first tab which is an instance of TabFragment1
	    Tab tab3 = actionBar.newTab()
	              .setText("TabTitle 3")
	              .setTabListener(new TabListener<WhiteFragment>(
	               this, "tab3", WhiteFragment.class));
	    actionBar.addTab(tab3);

	    // add the second tab which is an instance of TabFragment2
	    Tab tab4 = actionBar.newTab()
	           .setText("TabTitle 4")
	           .setTabListener(new TabListener<BlackFragment>(
	                this, "tab4", BlackFragment.class));
	    actionBar.addTab(tab4);

	    // check if there is a saved state to select active tab
	    if( savedInstanceState != null ){
	      getSupportActionBar().setSelectedNavigationItem(
	                  savedInstanceState.getInt(ACTIVE_TAB));
	    }
	  }

	  @Override
	  protected void onSaveInstanceState(Bundle outState) {
	    // save active tab
	    outState.putInt(ACTIVE_TAB,
	            getSupportActionBar().getSelectedNavigationIndex());
	    super.onSaveInstanceState(outState);
	  }
}
