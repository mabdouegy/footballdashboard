package com.expedia.footballdashboard.dto;

import java.util.Map;

import com.expedia.footballdashboard.model.Goal;
import com.expedia.footballdashboard.model.Match;

public class UpdateCommandDto {
private Goal goal;
public Goal getGoal() {
	return goal;
}
public void setGoal(Goal goal) {
	this.goal = goal;
}
private Map<String, Match> matches ;
 
public Map<String, Match> getMatches() {
	return matches;
}
public void setMatches(Map<String, Match> matches) {
	this.matches = matches;
}
}
