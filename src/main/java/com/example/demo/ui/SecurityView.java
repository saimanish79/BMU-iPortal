package com.example.demo.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.User;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@org.springframework.stereotype.Component
public class SecurityView {
	
	private Label titleLabel;
	public static final String TITLE_ID = "dashboard-title";
	
	@Autowired
	GatepassDetailsView gatepassdetailsView;
	
	@Autowired
	GatepassForm gatepassform;
	
	@Autowired 
	ParentGatepassDetails parentGatepassDetails;
	
	@Autowired
	WardenGatepassDetails wardenGatepassDetails;
	
	@Autowired
	SecurityGatepassDetails securityGatepassDetails;
	


	private class GatepassHandler{

		
		TabSheet gatepassHandler_tabsheet;
		VerticalLayout mainvl;
		

		public GatepassHandler init(){
			gatepassHandler_tabsheet = new TabSheet();
			gatepassHandler_tabsheet.setStyleName(ValoTheme.TABSHEET_FRAMED);
			gatepassHandler_tabsheet.addStyleName(ValoTheme.TABSHEET_EQUAL_WIDTH_TABS);

			mainvl=new VerticalLayout();
			return this;
		}
		public Component layout(User user){
			
			
//			errorhandler_tabsheet.addTab(application.createComponent(), "Applications", FontAwesome.CUBE, 0);
//			errorhandler_tabsheet.addTab(project.createComponent(), "Flows", FontAwesome.DESKTOP, 1);
//			errorhandler_tabsheet.addTab(errors.createComponent(), "Errors", FontAwesome.CLOSE,2);
			gatepassHandler_tabsheet.addTab(securityGatepassDetails.createComponent(user),"GatepassDetails",FontAwesome.CUBE,0);
			//studenthandler_tabsheet.addTab(marksView.createComponent(),"Marks",FontAwesome.CUBE,2);

	
//			errorhandler_tabsheet.getTab(0).setClosable(true);
//			errorhandler_tabsheet.getTab(1).setClosable(true);
//			errorhandler_tabsheet.getTab(2).setClosable(true);

		
		mainvl.setSizeFull();
		mainvl.setSpacing(false);
		mainvl.setMargin(false);
		mainvl.addComponents(buildHeaderr(),gatepassHandler_tabsheet);

		return mainvl;
		
		}
	}
	private Component buildHeaderr() {
		HorizontalLayout header = new HorizontalLayout();
      header.addStyleName("viewheader");
      header.setSpacing(true);

      titleLabel = new Label("Gatepass Details");
      titleLabel.setId(TITLE_ID);
      titleLabel.setSizeUndefined();
      titleLabel.addStyleName(ValoTheme.LABEL_H1);
      titleLabel.addStyleName(ValoTheme.LABEL_NO_MARGIN);
      header.addComponent(titleLabel);
      return header;
	}
	public Component createComponent(User user){
		return new GatepassHandler().init().layout(user);
	}


}
