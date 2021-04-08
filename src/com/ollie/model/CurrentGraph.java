
package com.ollie.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.oanda.fxtrade.api.FXClient;


public class CurrentGraph {
	
	private static Long currentGraphInterval = FXClient.INTERVAL_5_SEC;
	private static int currentGraphPointCount = 75;
	private static boolean updateInProgress = false;
	
	public static Long getCurrentGraphInterval(){
		return currentGraphInterval;
	}
	public static void setCurrentGraphInterval(Long l){
		currentGraphInterval = l;
	}
	public static int getCurrentGraphPointCount(){
		return currentGraphPointCount;