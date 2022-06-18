
package com.ollie.model;

import java.util.Vector;

import com.oanda.fxtrade.api.API;
import com.oanda.fxtrade.api.Account;
import com.oanda.fxtrade.api.AccountException;
import com.oanda.fxtrade.api.FXClient;
import com.oanda.fxtrade.api.InvalidPasswordException;
import com.oanda.fxtrade.api.InvalidUserException;
import com.oanda.fxtrade.api.MultiFactorAuthenticationException;
import com.oanda.fxtrade.api.SessionException;
import com.oanda.fxtrade.api.User;

public class Login {

	private static FXClient fxclient;
	
	public static int loginAttempt(String user, String pass){
		
		fxclient = API.createFXGame();
		fxclient.setWithRateThread(true); 
		
		System.out.println("login attempt with user " + user);
		
		try { fxclient.login(user, pass); }
		catch (SessionException e) { return -1; }