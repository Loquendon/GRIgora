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
	pri