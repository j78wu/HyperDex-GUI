package com.hyperdex.web.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.hyperdex.web.client.model.Coordinator;
import com.hyperdex.web.client.model.Operations;
import com.hyperdex.web.client.model.Persentage;

public class LogInfo extends Composite{
	public LogInfo() {
		
		VerticalPanel mainPanel = new VerticalPanel();
		initWidget(mainPanel);
		mainPanel.setSize("1000px", "495px");
		if (History.getToken().isEmpty())
		{
			History.newItem("home");
		}
		//History.addValueChangeHandler(this);
		//History.fireCurrentHistoryState();
		
	  
		
		Label lblCoordinator = new Label("Coordinator:");
		mainPanel.add(lblCoordinator);
		mainPanel.setCellVerticalAlignment(lblCoordinator, HasVerticalAlignment.ALIGN_MIDDLE);
		Coordinator CoInfo = new Coordinator();
		
		
		Label lblNodeip = new Label("ServerInfo:");
		mainPanel.add(lblNodeip);
		lblNodeip.setSize("103px", "28px");
		
		Persentage per = new Persentage();;
		Operations op = new Operations();
		
	}

	
	
	
}
