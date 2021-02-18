
package com.ollie.controller;


import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Vector;

import com.oanda.fxtrade.api.Account;
import com.oanda.fxtrade.api.FXClient;
import com.oanda.fxtrade.api.FXHistoryPoint;
import com.oanda.fxtrade.api.MarketOrder;
import com.oanda.fxtrade.api.OAException;
import com.oanda.fxtrade.api.SessionException;
import com.oanda.fxtrade.api.User;
import com.ollie.model.CurrentGraph;
import com.ollie.model.CurrentOrder;
import com.ollie.model.CurrentPair;
import com.ollie.model.GraphUpdater;
import com.ollie.model.Login;
import com.ollie.model.OpenOrders;
import com.ollie.model.Ticker;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableRow;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class MainController implements Initializable{
	
	public static XYChart.Series<String, Number> series = new  XYChart.Series<String, Number>();
	final ToggleGroup group = new ToggleGroup();
	public static double currentRate = 1;
	
	@FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;
	@FXML
	private LineChart<String, Number> myChart;
	@FXML
	private ComboBox<String> currencyPairCombo;
	@FXML
	private TextField unitsTF;
	@FXML
	private TextField takeProfitTF;
	@FXML
	private TextField stopLossTF;
	@FXML 
	private ToggleButton buyBtn;
	@FXML 
	private ToggleButton sellBtn;
	@FXML
    public TextField rateTF;
	@FXML
	public GridPane accountOrderGP;
	@FXML
	public GridPane openOrdersGP;
	
	public void updateAccountOrderGP(){
		
		//clear past values
		
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		for(int i = 0; i < 8; i++){
			nodes.add(openOrdersGP.getChildren().get(i));
		}
		
		openOrdersGP.getChildren().clear();
		openOrdersGP.getChildren().addAll(nodes);
		
		accountOrderGP.getChildren().clear();
		
		
		//add account details
		Label username = new Label("Username: " + Login.getAccountName());
		username.setStyle("-fx-font-size: 14px");
		GridPane.setHalignment(username, HPos.CENTER);
		accountOrderGP.add(username, 0, 0);
		
		DecimalFormat df = new DecimalFormat("#.#####");
		String b = df.format(Login.getBalance());
		Label balance = new Label("Balance: " + b);
		balance.setStyle("-fx-font-size: 14px");
		GridPane.setHalignment(balance, HPos.CENTER);
		accountOrderGP.add(balance, 1, 0);
		
		
		// update orders
		try {
			OpenOrders.updateOpenOrders();
		} catch (SessionException e) {
			e.printStackTrace();
		}
	
		
		//loop through and print to grid
		for(int i = 0; i < OpenOrders.getSize(); i++){
			
			
			Label profitLoss = new Label(OpenOrders.getPL(i));
			
			if(OpenOrders.getPL(i).startsWith("-")){
				profitLoss.setStyle("-fx-background-color:  #ff5b5b");
			}
			else{
				profitLoss.setStyle("-fx-background-color: #22cda5");
			}