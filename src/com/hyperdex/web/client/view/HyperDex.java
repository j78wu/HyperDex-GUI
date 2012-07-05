package com.hyperdex.web.client.view;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;


public class HyperDex implements EntryPoint{
	public void onModuleLoad() {
		
	    RootPanel.get("mainpage").add( new DatabaseInfoView() );
}
}