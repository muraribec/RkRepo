package com.qa.facebook.util;

public class TimeUtil {
	
	//short wait
	//Medium wait
	//long wait
	//Explicit wait--powerfull
	//Implicit wait---dont use
	//Fluent wait---1/2 second polling
	
	public static void shortWait(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void mediumWait(){
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
  public static void longWait(){
	  try {
		Thread.sleep(20000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
  }
	
	
	
	
	
	
	
	
	
	
	
	
	

}
