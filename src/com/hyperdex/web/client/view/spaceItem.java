package com.hyperdex.web.client.view;

import java.util.ArrayList;

public final class spaceItem {
	
	  public String spaceName;
	  public String replication;
	  public int subNumber;
	  public String[] attributes;
	  public String key;
	  public ArrayList<String[]> subspaces = new ArrayList<String[]>();

	public String attrNumber;
	  public boolean read;

	  public spaceItem(String spaceName, String replication, int subNumber, String attrNumber, String[] attributes, String key, ArrayList<String[]> subspaces) {
	    this.spaceName = spaceName;
	    this.replication = replication;
	    this.subNumber = subNumber;
	    this.attrNumber = attrNumber;
	    this.attributes = attributes;
	    this.key=key;
	    this.subspaces=subspaces;
	  }
}
