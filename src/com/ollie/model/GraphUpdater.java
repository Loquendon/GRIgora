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
		
		int count = CurrentGraph.getCurrentGraphPointCount();
		Long interval = CurrentGraph.getCurrentGraphInterval();
		
		
        do {
        	//checks to see if point count or interval has been updated
        	int cmp = Integer.compare(count, CurrentGraph.getCurrentGraphPointCount());
        	
        	if( cmp < 0 || cmp > 0 || !interval.equals(CurrentGraph.getCurrentGraphInterval())){
        		
        		MainController.initGraph();
        		interval = CurrentGraph.getCurrentGraphInterval();
        		count =  C