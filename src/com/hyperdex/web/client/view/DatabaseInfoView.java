package com.hyperdex.web.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalSplitPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.TabPanel;
import com.hyperdex.web.client.model.Coordinator;
import com.hyperdex.web.client.model.Operations;
import com.hyperdex.web.client.model.Persentage;

public class DatabaseInfoView extends Composite implements ValueChangeHandler{
	private Label label = new Label();
	public DatabaseInfoView() {
		
		VerticalPanel mainPanel = new VerticalPanel();
		initWidget(mainPanel);
		mainPanel.setSize("1000px", "495px");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		mainPanel.add(horizontalPanel);
		horizontalPanel.setSize("407px", "51px");
		
		MenuBar menuBar = new MenuBar(false);
		horizontalPanel.add(menuBar);
		menuBar.setSize("463px", "45px");
		
		MenuItem mntmHome = new MenuItem("Home", false, (Command) null);
		mntmHome.setHTML("HyperDex");
		menuBar.addItem(mntmHome);
		mntmHome.setSize("100", "29px");
		
		MenuItemSeparator separator = new MenuItemSeparator();
		menuBar.addSeparator(separator);
		
		MenuItem mntmSpaces = new MenuItem("Spaces", false, (Command) null);
		mntmSpaces.setHTML("HyperSpace");
		menuBar.addItem(mntmSpaces);
		mntmSpaces.setWidth("100");
		
		MenuItemSeparator separator_1 = new MenuItemSeparator();
		menuBar.addSeparator(separator_1);
		
		MenuItem mntmAllLogs = new MenuItem("Logs", false, (Command) null);
		menuBar.addItem(mntmAllLogs);
		mntmAllLogs.setWidth("100");
		
		MenuItemSeparator separator_2 = new MenuItemSeparator();
		menuBar.addSeparator(separator_2);
		
		MenuItem mntmAllNodes = new MenuItem("Nodes", false, (Command) null);
		menuBar.addItem(mntmAllNodes);
		mntmAllNodes.setWidth("100");
		
		Hyperlink hprlnkHyperspace = new Hyperlink("HyperSpace", false, "HyperSpace");
		horizontalPanel.add(hprlnkHyperspace);
		if (History.getToken().isEmpty())
		{
			History.newItem("home");
		}
		History.addValueChangeHandler(this);
		History.fireCurrentHistoryState();
		
	  
		
		Label lblCoordinator = new Label("Coordinator:");
		mainPanel.add(lblCoordinator);
		mainPanel.setCellVerticalAlignment(lblCoordinator, HasVerticalAlignment.ALIGN_MIDDLE);
		
		FlexTable table1 = new FlexTable();
		table1.setCellPadding(2);
		table1.getRowFormatter().addStyleName(0,"gwt-flextable");
		table1.addStyleName("FlextableList");
		table1.setText(0,0,"Status");
		table1.setText(0,1,"StartTime");
		table1.setText(0,2,"JoinNode");
		table1.setText(0,3,"JoinTime");
		table1.setText(0,4,"LeavingNode");
		table1.setText(0,5,"LeavingTime");
		table1.setText(0,6,"NodeNumber");
		table1.setText(0,7,"NewSpaceCreation");
		table1.setText(0,8,"NewSpaceName");
		table1.setText(0,9,"EndTime");
		table1.setTitle("Coordinator");
		mainPanel.add(table1);
		table1.setSize("1000px", "88px");
		Coordinator CoInfo = new Coordinator();
		table1.setText(1, 0, CoInfo.getStatus());
		table1.setText(1,1,CoInfo.getStartTime());
		table1.setText(1, 2, CoInfo.getNewNodes());
		table1.setText(1, 3, CoInfo.getJoinTime());
		table1.setText(1, 4, CoInfo.getLeavingNode());
		table1.setText(1, 5, CoInfo.getLeavingTime());
		table1.setText(1, 6, CoInfo.getNodeNum());
		table1.setText(1, 7, CoInfo.getNewSpaceCreation());
		table1.setText(1, 8, CoInfo.getSpaceName());
		table1.setText(1, 9, CoInfo.getEndTime());
		
		
		Label lblNodeip = new Label("NodeIP:");
		mainPanel.add(lblNodeip);
		lblNodeip.setSize("103px", "28px");
		
		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		mainPanel.add(horizontalPanel_3);
		horizontalPanel_3.setSize("1000px", "188px");
		
		Persentage per = new Persentage();
		ListBox listBox = new ListBox();
		horizontalPanel_3.add(listBox);
		listBox.setSize("120px", "186px");
		listBox.setStyleName("h1");
		listBox.setVisibleItemCount(5);
		listBox.addItem(per.getIp());
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		mainPanel.add(horizontalPanel_1);
		horizontalPanel_1.setSize("298px", "40px");
		
		Label lblAllRequests = new Label("All Requests:");
		horizontalPanel_1.add(lblAllRequests);
		
		
		Grid grid = new Grid(1, 1);
		horizontalPanel_1.add(grid);
		grid.setWidth("78px");
		grid.setText(0, 0, per.getRequest());
		
		FlexTable flexTable = new FlexTable();
		flexTable.setTitle("Node");
		flexTable.getRowFormatter().addStyleName(0,"gwt-flextable");
		flexTable.addStyleName("FlextableList");;
		flexTable.setText(0,0,"Operation Name");
		flexTable.setText(0,1,"Operation Number");
		flexTable.setText(0,2,"Latency");
		flexTable.setCellPadding(2);
		mainPanel.add(flexTable);
		flexTable.setSize("359px", "177px");
		Operations op = new Operations();
		flexTable.setText(1,0,op.getName1());
		flexTable.setText(1,1,op.getSearchNum());
		flexTable.setText(1,2,op.getTime1());
		
		flexTable.setText(2,0,op.getName2());
		flexTable.setText(2,1,op.getGetNum());
		flexTable.setText(2,2,op.getTime2());
		
		flexTable.setText(3,0,op.getName3());
		flexTable.setText(3,1,op.getPutNum());
		flexTable.setText(3,2,op.getTime3());
		
		flexTable.setText(4,0,op.getName4());
		flexTable.setText(4,1,op.getDelNum());
		flexTable.setText(4,2,op.getTime4());
		
		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		mainPanel.add(horizontalPanel_2);
		horizontalPanel_2.setSize("794px", "66px");
		
		Label lblMemoryUsage = new Label("Memory Usage:");
		horizontalPanel_2.add(lblMemoryUsage);
		lblMemoryUsage.setSize("120px", "42px");
		
		Grid grid_1 = new Grid(1, 1);
		horizontalPanel_2.add(grid_1);
		grid_1.setWidth("183px");
		grid_1.setText(0, 0, per.getMemory());
		
		Label lblCpuUsage = new Label("CPU Usage:");
		horizontalPanel_2.add(lblCpuUsage);
		lblCpuUsage.setWidth("93px");
        
        Grid grid_2 = new Grid(1, 1);
        horizontalPanel_2.add(grid_2);
        grid_2.setWidth("121px");
        grid_2.setText(0, 0, per.getCpu());
		
        horizontalPanel_2.add(label);
		
	}

	@Override
	public void onValueChange(ValueChangeEvent event) {
		// TODO Auto-generated method stub
		changePage(History.getToken());	
		
	}
	public void changePage(String token) {
	    if(History.getToken().equals("HyperSpace")) {
	    	label.setText("The current Link selected is: " + token); 
	    	Window.Location.assign("http://127.0.0.1:8888/HyperSpace.html");
	    } else {
	    	label.setText("The current Link selected is: " + token);
	    }
	}
	
}

	
