package com.ollie.model;
import com.oanda.fxtrade.api.*;

public class RateTicker{
	
	public static void startRateTicker()	{
		
		//import client
		
		FXClient fxclient = Login.returnFXClient();
		
		//cr