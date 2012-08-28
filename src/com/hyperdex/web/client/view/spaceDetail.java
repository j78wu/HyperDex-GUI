package com.hyperdex.web.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.dom.client.Element;

public class spaceDetail extends ResizeComposite {

	private static final spaceDetailUiBinder uiBinder = GWT.create(spaceDetailUiBinder.class);


	interface spaceDetailUiBinder extends UiBinder<Widget, spaceDetail> {
	}


	@UiField Element spaceName;
	@UiField FlexTable table;
	public spaceDetail() {
		initWidget(uiBinder.createAndBindUi(this));
		
	}
	
	public void setItem(spaceItem item){
		spaceName.setInnerText(item.spaceName); 
		table.setText(0, 0, "SpaceAttributes:");
		table.getColumnFormatter().setStyleName(0, "gwt-flextable");
		table.addStyleName("FlextableList");
		int i = 1;
		for (; i < item.attributes.length+1; ++i){
			table.setText(0, i, item.attributes[i-1]);
		}

		// Clear any remaining slots.
		int count = table.getCellCount(0);
	    for (; i < count; ++i) {
	    	table.removeCell(0, (table.getCellCount(0)-1));
	    }
	    
	    int s = 0;//row
	    int n = 0;//used for delete
	    for (int j = 0; j < item.subNumber; ++j, s=j){
	    	for (int m = 1; m < item.subspaces.get(j).length+1; ++m,n=m){
	    	table.setText(j+2,0,"Subspace"+(j+1)+":");
	    	table.setText(j+2,m,item.subspaces.get(j)[m-1]);
	    	}
	    }
	    
	    table.setText(1, 0, "key:");
	    table.setText(1, 1, item.key);
	    s++;
	 // Clear any remaining slots
	    for (; s < (table.getRowCount()-1) ;){
	    	
	    	table.removeRow(table.getRowCount()-1);
	    }
	    for (; n < table.getCellCount(s); ++n) {
	    	
	    	table.removeCell(s, (table.getCellCount(s)-1));
	    }
	    
	    
	}

}
