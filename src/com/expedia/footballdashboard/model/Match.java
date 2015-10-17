package com.expedia.footballdashboard.model;

import java.util.ArrayList;

public class Match {
 
	private int id;
	private String homeTeam;
	private String AwayTeam;
	private int homeTeamScore=0;
	private int AwayTeamScore=0;
	private int timer;
	private ArrayList<Goal> awayTeamgaols;
	private ArrayList<Goal> homeTeamgaols; 
	public ArrayList<Goal> getAwayTeamgaols() {
		return awayTeamgaols;
	}

	public void setAwayTeamgaols(ArrayList<Goal> awayTeamgaols) {
		this.awayTeamgaols = awayTeamgaols;
	}

	public ArrayList<Goal> getHomeTeamgaols() {
		return homeTeamgaols;
	}

	public void setHomeTeamgaols(ArrayList<Goal> homeTeamgaols) {
		this.homeTeamgaols = homeTeamgaols;
	}
	 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	public String getAwayTeam() {
		return AwayTeam;
	}
	public void setAwayTeam(String awayTeam) {
		AwayTeam = awayTeam;
	}
 
	public int getHomeTeamScore() {
		return homeTeamScore;
	}
	public void setHomeTeamScore(int homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}
	public int getAwayTTeamScore() {
		return AwayTeamScore;
	}
	public void setAwayTTeamScore(int awayTTeamScore) {
		AwayTeamScore = awayTTeamScore;
	}
	public int getTimer() {
		return timer;
	}
	public void setTimer(int timer) {
		this.timer = timer;
	}
	 
	

}
