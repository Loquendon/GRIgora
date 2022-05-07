package com.ollie.model;

import java.util.Vector;

import com.oanda.fxtrade.api.API;
import com.oanda.fxtrade.api.FXHistoryPoint;
import com.ollie.controller.MainController;

import javafx.scene.chart.XYChart;

public class GraphUpdater implements  Runnable {
		
	@Override
    public void run() {
                
		MainController.initGraph();
		
		int count = CurrentGraph.getCurrentGraphPointCou