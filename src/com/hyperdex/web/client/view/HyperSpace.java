package com.hyperdex.web.client.view;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.hyperdex.web.client.model.Coordinator;
import com.hyperdex.web.client.model.Operations;
import com.hyperdex.web.client.model.Persentage;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class HyperSpace extends Composite{
	

	public HyperSpace() {
		
		VerticalPanel mainPanel = new VerticalPanel();
		mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		mainPanel.setStyleName("gwt-DecoratorPanel");
		initWidget(mainPanel);
		mainPanel.setSize("1000px", "495px");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		mainPanel.add(horizontalPanel);
		horizontalPanel.setSpacing(10);
		
		Label lblCoordinator = new Label("Coordinator:");
		horizontalPanel.add(lblCoordinator);
		lblCoordinator.setSize("115px", "43px");
		
		Grid grid = new Grid(1, 1);
		grid.setStyleName("gwt-grid");
		horizontalPanel.add(grid);
		grid.setWidth("42px");
		grid.setText(0, 0, "ended");
		
		PushButton pshbtnStart = new PushButton("START");
		horizontalPanel.add(pshbtnStart);
		pshbtnStart.setWidth("61px");
		
		PushButton pshbtnEnd = new PushButton("END");
		horizontalPanel.add(pshbtnEnd);
		pshbtnEnd.setWidth("61px");
		
		Label lblCoordinator_1 = new Label("Daemon:");
		horizontalPanel.add(lblCoordinator_1);
		lblCoordinator_1.setSize("115px", "43px");
		
		Grid grid_1 = new Grid(1, 1);
		grid_1.setStyleName("gwt-grid");
		horizontalPanel.add(grid_1);
		grid_1.setWidth("43px");
		grid_1.setText(0, 0, "ended");
		
		PushButton pshbtnStart_1 = new PushButton("START");
		horizontalPanel.add(pshbtnStart_1);
		pshbtnStart_1.setWidth("61px");
		
		PushButton pshbtnEnd_1 = new PushButton("END");
		horizontalPanel.add(pshbtnEnd_1);
		pshbtnEnd_1.setWidth("61px");
		if (History.getToken().isEmpty())
		{
			History.newItem("home");
		}
		Coordinator CoInfo = new Coordinator();
		
		Persentage per = new Persentage();
		Operations op = new Operations();
	    	    	    	    
	          HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
	    	  horizontalPanel_3.setSpacing(2);
	    	  mainPanel.add(horizontalPanel_3);
	    	  horizontalPanel_3.setSize("448px", "328px");
	    	    	    	    
	          Label lblHyperspace = new Label("HyperSpace:");
	    	  horizontalPanel_3.add(lblHyperspace);
	    	  lblHyperspace.setWidth("147px");
	    // Create a table to layout the form options
	    final FlexTable layout = new FlexTable();
	    
	    layout.setCellSpacing(6);
	    FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();
	    
	    	    // Add a title to the form
	    layout.setText(0, 0, "SpaceName");
	    cellFormatter.setColSpan(0, 0, 2);
	    cellFormatter.setHorizontalAlignment(
	    	        0, 0, HasHorizontalAlignment.ALIGN_CENTER);
	    	    
	    // Add some standard form options
	    layout.setText(1, 0, "SpaceName");
	    layout.setWidget(1, 1, new TextBox());
	    	    	    

	    // Wrap the content in a DecoratorPanel
	    DecoratorPanel decPanel = new DecoratorPanel();
	    horizontalPanel_3.add(decPanel);
	    decPanel.setStyleName("gwt-DecoratorPanel");
	    	    	    

	    	    	    // Add a title to the form
	    layout.setText(0, 0, "CreateSpace");
	    cellFormatter.setColSpan(0, 0, 2);
	    cellFormatter.setHorizontalAlignment(
	        0, 0, HasHorizontalAlignment.ALIGN_CENTER);
	    	    	    
	    // Add some standard form options
	    layout.setText(1, 0, "SpaceName:");
	    layout.setWidget(1, 1, new TextBox());
	    layout.setText(2, 0, "Dimension:");
	    layout.setWidget(2, 1, new TextBox());
	    Button addRow = new Button("add", new ClickHandler() {
	    	    	    	          public void onClick(ClickEvent event) {
	    	    	    	              addRow(layout);
	    	    	    	            }
	    	    	    	          });
	    layout.setWidget(2, 2, addRow);
	    final FlexTable layout_1 = new FlexTable();
	    layout.setCellSpacing(6);
	    FlexCellFormatter cellFormatter_1 = layout.getFlexCellFormatter();
	    cellFormatter_1.setColSpan(0, 0, 2);
	    cellFormatter_1.setHorizontalAlignment( 0, 0, HasHorizontalAlignment.ALIGN_CENTER);
	    layout_1.setText(1, 0, "Key:");
	    layout_1.setWidget(1, 1, new TextBox());
	    layout_1.setText(2, 0, "SubSpace:");
	    layout_1.setWidget(2, 1, new TextBox());
	    Button addRow_2 = new Button("add", new ClickHandler() {
	    	    	    	          public void onClick(ClickEvent event) {
	    	    	    	              addRowTwo(layout_1);
	    	    	    	            }
	    	    	    	          });
	    layout_1.setWidget(2, 2, addRow_2);
	    Button create = new Button("create");
	    	    	    	    
	    // Wrap the content in a DecoratorPanel
	    VerticalPanel onPanel = new VerticalPanel();
	    onPanel.add(layout);
	    onPanel.add(layout_1);
	    onPanel.add(create);
	    onPanel.setCellVerticalAlignment(create, HasVerticalAlignment.ALIGN_MIDDLE);
	    onPanel.setCellHorizontalAlignment(create, HasHorizontalAlignment.ALIGN_CENTER);
	    decPanel.add(onPanel);
	    onPanel.setHeight("304px");
	    onPanel.add(new spaceList());
	    	    	    	    
	    	    	    	   
		      
	}
	
	private void showCategory(ListBox listBox, int category) {
	    String listData = null;
	    switch (category) {
	      case 0:
	        listData = "First";
	        break;
	      case 1:
	        listData = "second";
	        break;
	      case 2:
	        listData = "thrid";
	        break;
	    }
	   // }
	  }
	private void showCategorySubspace(ListBox listBox, int category) {
	    String listData = null;
	    switch (category) {
	      case 0:
	        listData = "First";
	        break;
	      case 1:
	        listData = "second";
	        break;
	      case 2:
	        listData = "thrid";
	        break;
	    }
	   // }
	  }
	 private void addRow(final FlexTable flexTable) {
		    int numRows = flexTable.getRowCount();
		    flexTable.setText(numRows, 0, "Dimension");
		    flexTable.setWidget(numRows, 1, new TextBox());
		    Button del = new Button(
		            "del", new ClickHandler() {
		              public void onClick(ClickEvent event) {
		                removeRow(flexTable);
		              }
		            });
		    flexTable.setWidget(numRows, 2, del);
		    flexTable.getFlexCellFormatter().setRowSpan(0, 1, numRows + 1);
		  }
	 private void addRowTwo(final FlexTable flexTableTwo) {
		 int numRows = flexTableTwo.getRowCount();
		    flexTableTwo.setText(numRows, 0, "SubSpace");
		    flexTableTwo.setWidget(numRows, 1, new TextBox());
		    Button del = new Button(
		            "del", new ClickHandler() {
		              public void onClick(ClickEvent event) {
		                removeRow(flexTableTwo);
		              }
		            });
		    flexTableTwo.setWidget(numRows, 2, del);
		    flexTableTwo.getFlexCellFormatter().setRowSpan(0, 1, numRows + 1);
		  }
	 private void removeRow(FlexTable flexTable) {
			// TODO Auto-generated method stub
		 int numRows = flexTable.getRowCount();
		    if (numRows > 1) {
		      flexTable.removeRow(numRows - 1);
		      flexTable.getFlexCellFormatter().setRowSpan(0, 1, numRows - 1);
		    }
		}
}
