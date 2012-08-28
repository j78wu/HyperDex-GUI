package com.hyperdex.web.client.view;


import java.util.ArrayList;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.History;
import com.hyperdex.web.client.model.Coordinator;
import com.hyperdex.web.client.model.Operations;
import com.hyperdex.web.client.model.Persentage;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.visualizations.Gauge;

public class DatabaseInfoView extends Composite{
	FlexTable table1 = new FlexTable();
	FlexTable flexTable2 = new FlexTable();
	private ArrayList<String> stocks = new ArrayList<String>();
	Label Message = new Label("message");
	private static String JSON_URL = "http://localhost:8000/?q=ABC";
	private int jsonRequestId = 0;

	public DatabaseInfoView() {
		
		VerticalPanel mainPanel = new VerticalPanel();
		initWidget(mainPanel);
		mainPanel.setSize("1000px", "495px");
		if (History.getToken().isEmpty())
		{
			History.newItem("home");
		}
		Coordinator CoInfo = new Coordinator();
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		mainPanel.add(horizontalPanel);
		horizontalPanel.setWidth("926px");
	
		Label lblCoordinator = new Label("Coordinator:");
		horizontalPanel.add(lblCoordinator);
		lblCoordinator.setWidth("152px");
		mainPanel.setCellVerticalAlignment(lblCoordinator, HasVerticalAlignment.ALIGN_MIDDLE);
		
		horizontalPanel.add(table1);
		table1.setWidth("698px");
		table1.setCellPadding(2);
		table1.getRowFormatter().addStyleName(0,"gwt-flextable");
		table1.addStyleName("FlextableList");
		table1.setText(0,0,"Status");
		table1.setText(0,1,"StartTime");
		table1.setText(0,2,"NodeNumber");
		table1.setText(0,3,"NewSpaceCreation");
		table1.setText(0,4,"NewSpaceName");
		table1.setText(0,5,"EndTime");
		table1.setTitle("Coordinator");
		
		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		mainPanel.add(horizontalPanel_3);
		horizontalPanel_3.setSize("1000px", "85px");
		
		Persentage per = new Persentage();
		
		// Add a drop box with the list types
	    Label NodeLabel = new Label("NodeInfo:");
		horizontalPanel_3.add(NodeLabel);
		NodeLabel.setWidth("166px");
		mainPanel.setCellVerticalAlignment(NodeLabel, HasVerticalAlignment.ALIGN_MIDDLE);
	    
		
		flexTable2.getRowFormatter().addStyleName(0,"gwt-flextable");
		flexTable2.addStyleName("FlextableList");
		flexTable2.setCellPadding(2);
		flexTable2.setText(0,0,"NodeToken");
		flexTable2.setText(0,1, "NodeIP");
		flexTable2.setText(0,2,"Incoming Port");
		flexTable2.setText(0,3,"Outgoing Port");
		flexTable2.setText(0,4,"Incoming Instance ID");
		flexTable2.setText(0,5,"Outgoing Instance ID");
		flexTable2.setText(0,6,"Join Time");
		flexTable2.setText(0,7,"Leaving Time");
		
		
		/*flexTable2.setText(1,0,"Token_one");
		flexTable2.setText(1,1,"140.179.220.200");
		flexTable2.setText(1,2,"1234");
		flexTable2.setText(1,3,"1233");
		flexTable2.setText(1,4,"00015084");
		flexTable2.setText(1,5,"00013083");
		flexTable2.setText(1,6,"2012-07-10,1:00:23");
		flexTable2.setText(1,7,"null");
		
		flexTable2.setText(2,0,"Token_two");
		flexTable2.setText(2,1,"140.179.220.188");
		flexTable2.setText(2,2,"1234");
		flexTable2.setText(2,3,"1233");
		flexTable2.setText(2,4,"00015070");
		flexTable2.setText(2,5,"00013029");
		flexTable2.setText(2,6,"2012-07-10,10:00:30");
		flexTable2.setText(2,7,"null");*/
		
		flexTable2.setText(3,0,"Token_three");
		flexTable2.setText(3,1,"140.179.220.100");
		flexTable2.setText(3,2,"1234");
		flexTable2.setText(3,3,"1233");
		flexTable2.setText(3,4,"00032084");
		flexTable2.setText(3,5,"00013483");
		flexTable2.setText(3,6,"2012-07-10,12:00:23");
		flexTable2.setText(3,7,"2012-07-10,12:30:00");
		
		flexTable2.setText(4,0,"Token_four");
		flexTable2.setText(4,1, "140.179.220.202");
		flexTable2.setText(4,2,"1234");
		flexTable2.setText(4,3,"1233");
		flexTable2.setText(4,4,"00375084");
		flexTable2.setText(4,5,"00893083");
		flexTable2.setText(4,6,"2012-07-10,1:00:23");
		flexTable2.setText(4,7,"null");
		
		horizontalPanel_3.add(flexTable2);
		flexTable2.setWidth("824px");
		
		Label lblNewLabel = new Label("Operations:");
		
		
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.add(lblNewLabel);
		lblNewLabel.setWidth("130px");
		mainPanel.add(horizontalPanel_1);
		horizontalPanel_1.setSize("945px", "40px");
		
		Operations op = new Operations();
		FlexTable flexTable = new FlexTable();
		horizontalPanel_1.add(flexTable);
		flexTable.setTitle("Node");
		flexTable.getRowFormatter().addStyleName(0,"gwt-flextable");
		flexTable.addStyleName("FlextableList");
		flexTable.setText(0,0,"Operation Name");
		flexTable.setText(0,1,"Operation Number");
		flexTable.setText(0,2,"Latency");
		flexTable.setCellPadding(2);
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
		
		VerticalPanel verticalPanel = new VerticalPanel();
		horizontalPanel_1.add(verticalPanel);
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		horizontalPanel_1.add(verticalPanel_1);
		
        final DataTable data = DataTable.create();
        
        data.addColumn(ColumnType.STRING, "Label");
        data.addColumn(ColumnType.NUMBER, "Value");
        data.addRows(1);
        data.setValue(0, 0, "CPU(%)");
        data.setValue(0, 1, 40);
		
		final Gauge.Options option = Gauge.Options.create();
        
        option.setHeight(150);
        option.setWidth(480);
        option.setGreenRange(71, 80);
        option.setMinorTicks(10);
        option.setRedRange(81, 100);
        option.setYellowRange(61, 70);
        verticalPanel.add(new Gauge(data, option));
        
        //for memory

        final DataTable data_1 = DataTable.create();
        
        data_1.addColumn(ColumnType.STRING, "Label");
        data_1.addColumn(ColumnType.NUMBER, "Value");
        data_1.addRows(1);
        data_1.setValue(0, 0, "Memory(%)");
        data_1.setValue(0, 1, 40);
		
		final Gauge.Options option_1 = Gauge.Options.create();
        
        option_1.setHeight(150);
        option_1.setWidth(480);
        option_1.setGreenRange(71, 80);
        option_1.setMinorTicks(10);
        option_1.setRedRange(81, 100);
        option_1.setYellowRange(61, 70);
        verticalPanel_1.add(new Gauge(data_1, option_1));
        
        final ListBox dropBox = new ListBox(false);
	    horizontalPanel_1.add(dropBox);
	    dropBox.setWidth("78px");
	    
	    dropBox.addItem("one");
	    dropBox.addItem("two");
	    dropBox.addItem("three");
	    
	    
	    mainPanel.add(Message);
	
	    refreshWatchList();
	    
	}
	 
	/**
	 * Pad JSON with the callback function.
	 */
	private void refreshWatchList() {
	 
	  String url = JSON_URL;
	  // Append watch list stock symbols to query URL.
	  
	  // Append the name of the callback function to the JSON URL.
	  url = URL.encode(url) + "&callback=";

	  // Send request to server by replacing RequestBuilder code with a call to a JSNI method.
	  getJson(jsonRequestId++, url, this);
	}
	/**
	   * Make call to remote server.
	   */
	  public native static void getJson(int requestId, String url,
	      DatabaseInfoView handler) /*-{
	   var callback = "callback" + requestId;

   // [1] Create a script element.
   var script = document.createElement("script");
   script.setAttribute("src", url+callback);
   script.setAttribute("type", "text/javascript");

   // [2] Define the callback function on the window object.
   window[callback] = function(jsonObj) {
   // [3]
     handler.@com.hyperdex.web.client.view.DatabaseInfoView::handleJsonResponse(Lcom/google/gwt/core/client/JavaScriptObject;)(jsonObj);
     window[callback + "done"] = true;
   }
   // [4] JSON download has 1-second timeout.
   setTimeout(function() {
     if (!window[callback + "done"]) {
       handler.@com.hyperdex.web.client.view.DatabaseInfoView::handleJsonResponse(Lcom/google/gwt/core/client/JavaScriptObject;)(null);
     }

     // [5] Cleanup. Remove script and callback elements.
     document.body.removeChild(script);
     delete window[callback];
     delete window[callback + "done"];
   }, 1000);
  
   // [6] Attach the script element to the document body.
   document.body.appendChild(script);
	  }-*/;

	  /**
	   * Handle the response to the request for stock data from a remote server.
	   */
	   public void handleJsonResponse(JavaScriptObject jso) {
	     if (jso == null) {
	       displayError("Couldn't retrieve JSON");
	       return;
	     }
	     JSONObject json = new JSONObject(jso);
	     JSONArray ary = json.get("value").isObject().get("coordinator").isArray();
	     JSONArray ary1 = json.get("value").isObject().get("node").isArray();
	     
	     for (int i = 0; i < ary.size(); ++i) {
	    	   table1.setText(i+1, 0, ary.get(i).isObject().get("status").toString());
		       table1.setText(i+1, 1, ary.get(i).isObject().get("startTime").toString());
		       table1.setText(i+1, 2, ary.get(i).isObject().get("nodeNum").toString());
		       table1.setText(i+1, 3, ary.get(i).isObject().get("newSpaceCreation").toString());
		       table1.setText(i+1, 4, ary.get(i).isObject().get("newSpaceName").toString());
		       table1.setText(i+1, 5, ary.get(i).isObject().get("endTime").toString());
	       }
	     for (int i = 0; i < ary1.size(); ++i) {
	    	 flexTable2.setText(i+1, 0, ary1.get(i).isObject().get("nodeToken").toString());
	    	 flexTable2.setText(i+1, 1, ary1.get(i).isObject().get("nodeIP").toString());
	    	 flexTable2.setText(i+1, 2, ary1.get(i).isObject().get("incomingPort").toString());
	    	 flexTable2.setText(i+1, 3, ary1.get(i).isObject().get("outgoingPort").toString());
	    	 flexTable2.setText(i+1, 4, ary1.get(i).isObject().get("incomingID").toString());
	    	 flexTable2.setText(i+1, 5, ary1.get(i).isObject().get("outgoingID").toString());
	    	 flexTable2.setText(i+1, 6, ary1.get(i).isObject().get("joinTime").toString());
	    	 flexTable2.setText(i+1, 7, ary1.get(i).isObject().get("leavingTime").toString());
	       }
	    //updateTable(asArrayOfStockData (jso));
	   }
	   
	   /**
	    * Cast JavaScriptObject as JsArray of StockData.
	    */
	   private final native JsArray<fakedata> asArrayOfStockData(JavaScriptObject jso) /*-{
	          return jso;
	        }-*/;
	   
	   /**
	    * Update the Price and Change fields all the rows in the stock table.
	    * 
	    * @param prices Stock data for all rows.
	    * 
	    */
	   private void updateTable(JsArray<fakedata> prices) {
	     for (int i = 0; i < prices.length(); i++) {
	       table1.setText(i+1, 0, prices.get(i).getStatus());
	       table1.setText(i+1, 1, prices.get(i).getStartTime());
	       table1.setText(i+1, 2, prices.get(i).getNodeNumber());
	       table1.setText(i+1, 3, prices.get(i).getNewSpaceCreation());
	       table1.setText(i+1, 4, prices.get(i).getNewSpaceName());
	       table1.setText(i+1, 5, prices.get(i).getEndTime());
	     }
	     // Clear any errors.
	     Message.setVisible(false);
	   }
	   
	   /**
	    * Update a single row in the stock table.
	    * 
	    * @param price Stock data for a single row.
	    */
	   
	   private void displayError(String error) {
		    Message.setText("Error: " + error);
		    Message.setVisible(true);
		  }
}
	

	
