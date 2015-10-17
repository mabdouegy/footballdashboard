package com.expedia.footballdashboard.model;

public class CommandPatternConstants {
	//TODO make them Enum
	public static final String startCommandPattern="^Start: '(.+)' vs. '(.+)'$";
	public static final String udateCommandPattern= "^(\\d+) '(.+)' (.+)$";
	public static final String endCommandPattern="^End: '(.+)' vs. '(.+)'$"; 
}
