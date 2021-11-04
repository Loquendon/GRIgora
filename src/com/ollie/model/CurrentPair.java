package com.ollie.model;

import java.util.Vector;

import com.oanda.fxtrade.api.API;
import com.oanda.fxtrade.api.FXClient;
import com.oanda.fxtrade.api.FXHistoryPoint;
import com.oanda.fxtrade.api.FXPair;
import com.oanda.fxtrade.api.OAException;

public class CurrentPair {

	private static String currentPair = "GBP/USD";
	private static FXPair p;
	private static Vector<FXHistoryPoint> fiveSecVector = new Vector<FXHistoryPoint>();
	private static Vector<FXHistoryPoint> thirtySecVector = new Vector<FXHistoryPoint>();
	private static Vector<FXHistoryPoint> oneMinVector = new Vector<FXHistoryPoint>();
	private static Vector<FXHistoryPoint> fiveMinVector = new Vector<FXHistoryPoint>();
	private static Vector<FXHistoryPoint> oneHourV