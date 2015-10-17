package com.expedia.footballdashboard.dto;

import java.util.Map;

import com.expedia.footballdashboard.model.Match;

public class StartCommandDto {
private Match match;
private Map<String, Match> matches ;
public Match getMatch() {
	return match;
}
public void setMatch(Match match) {
	this.match = match;
}
public Map<String, Match> getMatches() {
	return matches;
}
public void setMatches(Map<String, Match> matches) {
	this.matches = matches;
}
}
