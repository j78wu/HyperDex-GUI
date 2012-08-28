package com.hyperdex.web.client.view;

import com.google.gwt.core.client.JavaScriptObject;

class fakedata extends JavaScriptObject {                              // (1)
  // Overlay types always have protected, zero argument constructors.
  protected fakedata() {}                                              // (2)

  // JSNI methods to get stock data.
  public final native String getStatus() /*-{ return this.status; }-*/; // (3)
  public final native String getStartTime() /*-{ return this.startTime; }-*/;
  public final native String getNodeNumber() /*-{ return this.nodeNum; }-*/;
  public final native String getNewSpaceCreation() /*-{ return this.newSpaceCreation; }-*/;
  public final native String getNewSpaceName() /*-{ return this.newSpaceName; }-*/;
  public final native String getEndTime() /*-{ return this.endTime; }-*/;
   
}