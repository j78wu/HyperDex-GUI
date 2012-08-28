package com.hyperdex.web.client.view;

import java.util.ArrayList;



public class spaceItems {
	private static final int NUM_ITEMS = 2;
    private static final int FRAGMENTS_PER_EMAIL = 4;
	
	private static final String[] spaceNames = new String[] {
		"phonebook","studentInfo"};
	
	private static final String[] replications = new String[] {
		"2","3"};
	
	private static final int[] subNumbers = new int[] {
		1,3};
	
	private static final String[] attrNumbers = new String[] {
		"5","6"};
	
	
	private static final String[] phonebookAttr = new String[] {
		"first", "last", "phone"
	};
	private static final String phonekey = "phone";
	
	private static final String[] sub = new String[]{"first","last"};
	
	private static ArrayList<String[]> phoneSub =new ArrayList<String[]>();
	
	static{phoneSub.add(sub);}
	
    // second space
	private static final String[] studentAttr = new String[]{
		"name", "age", "department", "course", "tutor","gender","grade","term"
	};
	
    private static final String studentkey = "name";
	
	private static final String[] subOne = new String[]{"age","gender"};
	
	private static final String[] subTwo = new String[]{"course","tutor","department"};
	
	private static final String[] subThree = new String[]{"grade", "term"};
	
	private static ArrayList<String[]> studentSub =new ArrayList<String[]>();
	
	static{studentSub.add(0,subOne);
		   studentSub.add(1,subTwo);
		   studentSub.add(2,subThree);}
	
	private static int spaceNameIdx = 0, replicationIdx = 0, subNumberIdx = 0,
	attrNumberIdx = 0;
	
	private static ArrayList<spaceItem> items = new ArrayList<spaceItem>();

	static {
	    for (int i = 0; i < NUM_ITEMS; ++i) {
	      items.add(createFakeMail());
	     
	    }
	  }

	  public static spaceItem getspaceItem(int index) {
	    if (index >= items.size()) {
	      return null;
	    }
	    return items.get(index);
	  }

	  public static int getSpaceItemCount() {
	    return items.size();
	  }

	  private static spaceItem createFakeMail() {
	    String spaceName = spaceNames[spaceNameIdx++];
	    if (spaceNameIdx == spaceNames.length) {
	      spaceNameIdx = 0;
	    }

	    String replication = replications[replicationIdx++];
	    if (replicationIdx == replications.length) {
	      replicationIdx = 0;
	    }

	    int subNumber = subNumbers[subNumberIdx++];
	    if (subNumberIdx == subNumbers.length) {
	      subNumberIdx = 0;
	    }
	    
	    String attrNumber = attrNumbers[attrNumberIdx++];
	    if (attrNumberIdx == attrNumbers.length) {
	      attrNumberIdx = 0;
	    }

	    
	      String[] attr = new String[]{};
	      String key = new String();
	      ArrayList<String[]> subspaces= new ArrayList<String[]>();
	    if (spaceName=="phonebook"){
	    	attr = phonebookAttr; 
	    	key = phonekey;
	    	subspaces = phoneSub;
	    }
	    
	    if (spaceName =="studentInfo"){
	    	attr = studentAttr;
	    	key = studentkey;
	    	subspaces = studentSub;
	    }

	    return new spaceItem(spaceName, replication, subNumber, attrNumber, attr, key, subspaces);
	  }
	  
	  

}
