package test;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import com.expedia.footballdashboard.model.Goal;
import com.expedia.footballdashboard.model.Match;
import com.expedia.footballdashboard.printer.BasicPrinter;

public class BasicPrintTester {
	//TODO clean dataentry and separate it in another method
	 @Test
	public void testBasicPrintSingleGoal() {
		 String excpectedResult="England 0 vs. West Germany 1 (Haller 12' )";
		 Match match = new Match();
		 match.setHomeTeam("England");
		 match.setHomeTeamScore(0);
		 match.setAwayTTeamScore(1);
		 match.setAwayTeam("West Germany");
		 match.setHomeTeamgaols(new ArrayList<Goal>());
		 Goal goal = new Goal();
		 goal.setMinute(12);
		 goal.setScorer("Haller");
		 goal.setTeam("West Germany");
		 ArrayList<Goal> awayTeamGoals= new ArrayList<Goal>();
		 awayTeamGoals.add(goal);
		 match.setAwayTeamgaols(awayTeamGoals);
		 BasicPrinter basicPrinter = new BasicPrinter();
		try {
			String result=basicPrinter.printMatch(match);
			if(!result.equalsIgnoreCase(excpectedResult))
			{
				fail("feailed due to discrepancy between excpected and actual string to be printed actual is:["+result+"] and excpected is:["
						+excpectedResult+"]");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("feailed due to:["+e.getMessage()+"]");
		}
	} 
	 @Test
	 public void testBasicPrintMultipleGoals() {
			 String excpectedResult="England 0 (Hurst 18' Peters 78' ) vs. West Germany 1 (Haller 12' )";
			 Match match = new Match();
			 match.setHomeTeam("England");
			 match.setHomeTeamScore(0);
			 match.setAwayTTeamScore(1);
			 match.setAwayTeam("West Germany");
			 Goal goal = new Goal();
			 goal.setMinute(12);
			 goal.setScorer("Haller");
			 goal.setTeam("West Germany");
			 ArrayList<Goal> teamGoals= new ArrayList<Goal>();
			 teamGoals.add(goal);
			 match.setAwayTeamgaols( teamGoals);
			 teamGoals= new ArrayList<Goal>();
			 goal = new Goal();
			 goal.setMinute(18);
			 goal.setScorer("Hurst");
			 goal.setTeam("England");
			 teamGoals.add(goal);
			 goal = new Goal();
			 goal.setMinute(78);
			 goal.setScorer("Peters");
			 goal.setTeam("England");
			 teamGoals.add(goal);
			 match.setHomeTeamgaols(teamGoals);
	 
	 
			 BasicPrinter basicPrinter = new BasicPrinter();
			try {
				String result=basicPrinter.printMatch(match);
				if(!result.equalsIgnoreCase(excpectedResult))
				{
					fail("feailed due to discrepancy between excpected and actual string to be printed actual is:["+result+"] and excpected is:["
							+excpectedResult+"]");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				fail("feailed due to:["+e.getMessage()+"]");
			}
		} 
} 
	 
 
