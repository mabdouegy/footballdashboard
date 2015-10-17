package com.expedia.footballdashboard.dto;

import java.util.Map;

import com.expedia.footballdashboard.model.Match;

public class EndCommandDto {
 
private Map<String, Match> matches ;
private String key;
 
public String getKey() {
	return key;
}
public void setKey(String key) {
	this.key = key;
}
public Map<String, Match> getMatches() {
	return matches;
}
public void setMatches(Map<String, Match> matches) {
	this.matches = matches;
}
}
