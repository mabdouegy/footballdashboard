package com.expedia.footballdashboard.model;

public class Goal {
 
private String Team;
private int minute;
private String scorer;
public String getTeam() {
	return Team;
}
public void setTeam(String team) {
	Team = team;
}
public int getMinute() {
	return minute;
}
public void setMinute(int minute) {
	this.minute = minute;
}
public String getScorer() {
	return scorer;
}
public void setScorer(String scorer) {
	this.scorer = scorer;
} 
 
}
