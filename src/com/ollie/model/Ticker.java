
package com.ollie.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.oanda.fxtrade.api.FXEventInfo;
import com.oanda.fxtrade.api.FXEventManager;
import com.oanda.fxtrade.api.FXRateEvent;
import com.oanda.fxtrade.api.FXRateEventInfo;
import com.ollie.controller.MainController;

import javafx.scene.chart.XYChart;

public class Ticker extends FXRateEvent
{
	public void handle(FXEventInfo EI, FXEventManager EM)