package com.expedia.footballdashboard.printer;

import java.util.Iterator;
import com.expedia.footballdashboard.model.Goal;
import com.expedia.footballdashboard.model.Match;

 
public class BasicPrinter implements Printable {

	public BasicPrinter() {
		super();
	}

	@Override
	public String printMatch(Match match) {
		StringBuffer result = new StringBuffer(match.getHomeTeam() + " " + match.getHomeTeamScore() + " ");
		
		if (!match.getHomeTeamgaols().isEmpty()){
			result.append("(");
			Goal goal= new Goal();
			//TODO combine home and away iteration into a method that accept iteration as input and return a string
			for (Iterator<Goal> iterator = match.getHomeTeamgaols().iterator(); iterator
					.hasNext();) {
				goal= iterator.next();
				result.append(goal.getScorer() + " " + goal.getMinute() + "' ");
			}
			result.append( ") ");			
				
		}
		result.append( "vs. " + match.getAwayTeam() + " " + match.getAwayTTeamScore() + " ");
		if (!match.getAwayTeamgaols().isEmpty()){
			result.append("(");
			Goal goal= new Goal();
			for (Iterator<Goal> iterator = match.getAwayTeamgaols().iterator(); iterator
					.hasNext();) {
				goal= iterator.next();
				result.append(goal.getScorer() + " " + goal.getMinute() + "' ");
			}
			result.append( ")");
		}
		System.out.println(result);
		return result.toString();
	}
 

 
}
