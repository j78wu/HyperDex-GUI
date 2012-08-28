package com.hyperdex.web.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;


public class Space extends Composite{
public Space() {
	
	VerticalPanel verticalPanel = new VerticalPanel();
	initWidget(verticalPanel);
	
	spaceList list = new spaceList();
	verticalPanel.add(list);
	list.setHeight("142px");
	    
	final spaceDetail detail = new spaceDetail();
	verticalPanel.add(detail);
	detail.setHeight("274px");
	
	
	list.setListener(new spaceList.Listener() {
	      public void onItemSelected(spaceItem item) {
	        detail.setItem(item);
	      }
	    });
		      
	}

}
