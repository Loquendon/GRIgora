package com.ollie.model;

import java.util.Vector;

import com.oanda.fxtrade.api.API;
import com.oanda.fxtrade.api.FXPair;
import com.oanda.fxtrade.api.Account;
import com.oanda.fxtrade.api.FXClient;
import com.oanda.fxtrade.api.MarketOrder;
import com.oanda.fxtrade.api.OAException;
import com.oanda.fxtrade.api.StopLossOrder;
import com.oanda.fxtrade.api.TakeProfitOrder;
import com.oanda.fxtrade.api.User;
import com.ollie.controller.MainController;

public class CurrentOrder {
	
	private static MarketOrder thisOrder = API.createMarketOrder();
	private static FXPair fxpair = API.createFXPair();
	
	public void setUnits(String units, String buysell){
		
		long unitsLong = Long.parseLong(units);
		
		if(buysell == "SELL" || buysell.equals("SELL")){
			unitsLong = -unitsLong;
			System.out.println("neg units - " + unitsLong);
		}
		
		thisOrder.setUnits(unitsLong);
	}
	public void setPair(String pair){
		fxpair.setPair(pair);
		thisOrder.setPair(fxpair);
	}
	public void setTP(String tp){
		
		if(!tp.equals("")|| !tp.equals(null)){
			
			double tpDouble = Double.parseDouble(tp);
			TakeProfitOrder tpo = API.createTakeProfitOrder(tpDouble);
			thisOrder.setTakeProfit(tpo);
		}
	}
	public void setSL(String sl){
		
		if(!sl.equals("")