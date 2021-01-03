
package com.ollie.controller;

import java.io.IOException;

import com.ollie.model.Login;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class MainApp extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;
    
	@Override
	public void start(Stage primaryStage) {
		
		  this.primaryStage = primaryStage;
	      this.primaryStage.setTitle("Login");

	       initRootLayout();
	       
	       showLogin();

	        
		
	}
	@Override
	public void stop(){
	    Login.returnFXClient().logout();
	}
	
	public void initRootLayout() {
        try {