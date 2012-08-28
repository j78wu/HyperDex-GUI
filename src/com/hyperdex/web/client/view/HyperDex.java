package com.hyperdex.web.client.view;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SourcesTabEvents;
import com.google.gwt.user.client.ui.TabBar;
import com.google.gwt.user.client.ui.TabListener;
import com.google.gwt.user.client.ui.TabPanel;


public class HyperDex implements EntryPoint, HistoryListener, TabListener{
	
	TabPanel menu = new TabPanel();
	String oldToken = null;
	public void onModuleLoad() {  
		
		menu.add(new DatabaseInfoView(), "Home");
		
		Space space = new Space();
		menu.add(space, "SpaceInfo");
		
		HyperSpace hyperSpace = new HyperSpace();
		menu.add(hyperSpace, "CreateSpace");
		
		LogInfo info = new LogInfo();
		menu.add(info, "LogInfo");
		
		menu.setStyleName("gwt-TabBar");
		
		RootPanel rootPanel = RootPanel.get("mainpage");
		rootPanel.add(menu);
		menu.selectTab(0);
		menu.addTabListener(this);
		History.addHistoryListener(this);
}
	
	@Override
	public void onHistoryChanged(String historyToken) {
		// TODO Auto-generated method stub
		// If they are the same, no need to do anything
	    if (oldToken != null && historyToken.equals(oldToken)) return;

	    // Save the token for the next time round
	    oldToken = historyToken;

	    // Get the tab index
	    int index = 0;
	    try
	    {
	        index = Integer.parseInt(historyToken);
	    }
	    catch (Exception e)
	    {
	    }

	    // Do a bit of checking
	    if (index < 0 || index >= menu.getTabBar().getTabCount()) index = 0;
	    menu.selectTab(index);
	}

	@Override
	public boolean onBeforeTabSelected(SourcesTabEvents sender, int tabIndex) {
		return true;
	}

	@Override
	public void onTabSelected(SourcesTabEvents sender, int tabIndex) {
		// TODO Auto-generated method stub
		History.newItem(""+tabIndex);
	}
}