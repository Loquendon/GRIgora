package com.ollie.model;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Vector;

import com.oanda.fxtrade.api.Account;
import com.oanda.fxtrade.api.FXClient;
import com.oanda.fxtrade.api.MarketOrder;
import com.oanda.fxtrade.api.OAException;
import com.oanda.fxtrade.api.RateTableException;
import com.oanda.fxtrade.api.SessionException;
import com.oanda.fxtrade.api.User;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class OpenOrders {

	private static Vector<MarketOrder> trades = new Vector<MarketOrder>();
	private static ArrayList<Button> buttons = new ArrayList<Button>();
	private static ArrayList<String> transactionID = new ArrayList<String>();
	private static ArrayList<String> time = new ArrayList<String>();
	private static ArrayList<String> units = new ArrayList<String>();
	private static ArrayList<String> pair = new ArrayList<String>();
	private static ArrayList<String> price = new ArrayList<String>();
	private static ArrayList<String> stopLoss = new ArrayList<String>();
	private static ArrayList<String> takeProfit = new ArrayList<String>();
	private static ArrayList<String> profitLoss = new ArrayList<String>();
	private static ArrayList<String> buysell = new ArrayList<String>();

	
	@SuppressWarnings("unchecked")
	public static void updateOpenOrders() throws SessionException{
		trades.clear();
		buttons.clear();
		transactionID.clear();
		time.clear();
		units.clear();
		pair.clear();
		price.clear();
		sto