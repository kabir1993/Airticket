package com.example;

import com.vaadin.annotations.Theme;

import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.awt.Dialog;

import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class TodoUI extends UI {

    private VerticalLayout layout;

    @Autowired
    TodoList todoList;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setupLayout();
        addHeader();
        addTab();
        //addTodoList();
    }

    private void setupLayout() {
        layout = new VerticalLayout();
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(layout);
    }

    private void addHeader() {
        Label header = new Label("AIRWAYS");
        header.addStyleName(ValoTheme.LABEL_H2);
        layout.addComponent(header);

    }

//    private void addForm() {
//        HorizontalLayout formLayout = new HorizontalLayout();
//        formLayout.setWidth("80%");
//
//        
//        TextField taskField = new TextField();
//        taskField.focus();
//        
//        Button addButton = new Button("");
//
//        formLayout.addComponentsAndExpand(taskField);
//        
//        formLayout.addComponent(addButton);
//        
//        layout.addComponent(formLayout);
//
//        addButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
//        addButton.setIcon(VaadinIcons.PLUS);
//
//        addButton.addClickListener(click -> {
//            todoList.addTodo(new Todo(taskField.getValue()));
//            taskField.setValue("");
//            taskField.focus();
//        });
//        addButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);
//    }
//
//
//    private void addActionButtons() {
//        Button deleteButton = new Button("Delete completed items");
//
//        deleteButton.addClickListener(click->todoList.deleteCompleted());
//
//        layout.addComponent(deleteButton);
//
//    }
    private void addTab() {
    	TabSheet tabsheet = new TabSheet();
    	layout.addComponent(tabsheet);
    	tabsheet.setWidth("90%");
    	
    	ComboBox<String> rFrom = new ComboBox<>();
    	rFrom.setItems("Dhaka", "Chittagong", "Cumilla");
    	rFrom.setPlaceholder("From");
    	ComboBox<String> rTo = new ComboBox<>();
    	rTo.setItems("Dhaka", "Chittagong", "Cumilla");
    	rTo.setPlaceholder("To");
    	DateField rDatePickerOn = new DateField();
    	rDatePickerOn.setPlaceholder("On");
    	DateField rDatePickerReturn = new DateField();
    	rDatePickerReturn.setPlaceholder("Return");
    	ComboBox<String> rPessanger = new ComboBox<>();
    	rPessanger.setItems("Infant", "Child", "Adult");
    	rPessanger.setPlaceholder("Passenger");
    	Button submitButton = new Button("");
    	submitButton.setCaption("SUBMIT");
    	submitButton.addStyleName(ValoTheme.BUTTON_FRIENDLY);
    	submitButton.setIcon(VaadinIcons.PLUS);
    	// Create the first tab
    	HorizontalLayout round_trip_tab = new HorizontalLayout();
    	round_trip_tab.addComponents(rFrom,rTo,rDatePickerOn,rDatePickerReturn,rPessanger,submitButton);
    	tabsheet.addTab(round_trip_tab).setCaption("Round Trip");
    	submitButton.addClickListener(click -> {
    		System.out.println("From ------------------------------------"+ rFrom.getValue());
    		System.out.println("To ------------------------------------"+ rTo.getValue());
    		System.out.println("On Date ------------------------------------"+ rDatePickerOn.getValue());
    		System.out.println("Return Date ------------------------------------"+ rDatePickerReturn.getValue());
    		System.out.println("Pessanger Type ------------------------------------"+ rPessanger.getValue());
        });
    	
    	
    	//-------------------------------------------------------------
    	ComboBox<String> oFrom = new ComboBox<>();
    	rFrom.setItems("Dhaka", "Chittagong", "Cumilla");
    	rFrom.setPlaceholder("From");
    	ComboBox<String> oTo = new ComboBox<>();
    	rTo.setItems("Dhaka", "Chittagong", "Cumilla");
    	rTo.setPlaceholder("To");
    	DateField oDatePickerOn = new DateField();
    	rDatePickerOn.setPlaceholder("On");
    	DateField oDatePickerReturn = new DateField();
    	rDatePickerReturn.setPlaceholder("Return");
    	ComboBox<String> oPessanger = new ComboBox<>();
    	rPessanger.setItems("Infant", "Child", "Adult");
    	rPessanger.setPlaceholder("Passenger");
    	Button submitButton2 = new Button("");
    	submitButton.setCaption("SUBMIT");
    	submitButton.addStyleName(ValoTheme.BUTTON_FRIENDLY);
    	submitButton.setIcon(VaadinIcons.PLUS);
    	// Create the first tab
    	HorizontalLayout one_way_trip = new HorizontalLayout();
    	round_trip_tab.addComponents(oFrom,oTo,oDatePickerOn,oDatePickerReturn,oPessanger,submitButton2);
    	tabsheet.addTab(one_way_trip).setCaption("One Way Trip");
    	submitButton.addClickListener(click -> {
    		System.out.println("From ------------------------------------"+ oFrom.getValue());
    		System.out.println("To ------------------------------------"+ oTo.getValue());
    		System.out.println("On Date ------------------------------------"+ oDatePickerOn.getValue());
    		System.out.println("Return Date ------------------------------------"+ oDatePickerReturn.getValue());
    		System.out.println("Pessanger Type ------------------------------------"+ oPessanger.getValue());
        });
    }
}
