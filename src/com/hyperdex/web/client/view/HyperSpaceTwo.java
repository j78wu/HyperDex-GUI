package com.hyperdex.web.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class HyperSpaceTwo extends Composite{
	  @UiTemplate("HyperSpaceTwo.ui.xml")
	  interface Binder extends UiBinder<DockLayoutPanel, HyperSpaceTwo> { }

	  interface GlobalResources extends ClientBundle {
	    @NotStrict
	    @Source("global.css")
	    CssResource css();
	  }

	  private static final Binder binder = GWT.create(Binder.class);

	  @UiField spaceList spaceList;
	  @UiField spaceDetail spaceDetail;
	  //@UiField Shortcuts shortcuts;
	  DockLayoutPanel outer = binder.createAndBindUi(this);

	  
	  public HyperSpaceTwo() {
		  
	  initWidget(binder.createAndBindUi(this));
	  
	  GWT.<GlobalResources>create(GlobalResources.class).css().ensureInjected();

	   
	  Window.enableScrolling(false);
	  //Window.setMargin("0px");

	    // Special-case stuff to make topPanel overhang a bit.
	    //Element topElem = outer.getWidgetContainerElement(topPanel);
	    //topElem.getStyle().setZIndex(2);
	    //topElem.getStyle().setOverflow(Overflow.VISIBLE);

	    // Listen for item selection, displaying the currently-selected item in
	    // the detail area.
	    spaceList.setListener(new spaceList.Listener() {
	      public void onItemSelected(spaceItem item) {
	        spaceDetail.setItem(item);
	      }
	    });
	    
	  
	  }
}

