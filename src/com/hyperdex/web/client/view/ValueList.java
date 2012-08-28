package com.hyperdex.web.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class ValueList extends Composite{

	private static ValueListUiBinder uiBinder = GWT
			.create(ValueListUiBinder.class);

	interface ValueListUiBinder extends UiBinder<Widget, ValueList> {
	}


	

	public ValueList(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
