package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.expedia.footballdashboard.command.EndCommand;
import com.expedia.footballdashboard.command.StartCommand;
import com.expedia.footballdashboard.command.UpdateCommand;
import com.expedia.footballdashboard.model.Goal;
import com.expedia.footballdashboard.model.Match;

public class CommandTester {

	 @Test
	public void testStartCommandValidation() {
		StartCommand command = new StartCommand();
		try {
			command.validatePattern("Start: 'England' vs. 'West Germany'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("feailed due to:["+e.getMessage()+"]");
		}
	} 
	@Test
	public void testUpdateCommandValidation() {
		UpdateCommand command = new UpdateCommand();
		try {
			command.validatePattern("11 'West Germany' Haller  ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("feailed due to:["+e.getMessage()+"]");
		}
	}
	@Test
	public void testEndCommandValidation() {
		EndCommand command = new EndCommand();
		try {
			command.validatePattern("End: 'England' vs. 'West Germany'  ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("feailed due to:["+e.getMessage()+"]");
		}
	}
	@Test
	public void testStartCommandExecute() {
		StartCommand command = new StartCommand();
		try {
			Match match=(Match) command.execute("Start: 'England' vs. 'West Germany'   ");
			if(!match.getHomeTeam().trim().equalsIgnoreCase("England"))
			{
				fail("feailed due to discrepancy in home team, excpected:[England] but got:["+match.getHomeTeam()+"]");
			}
			if(!match.getAwayTeam().trim().equalsIgnoreCase("West Germany"))
			{
				fail("feailed due to discrepancy in away team, excpected:[England] but got:["+match.getAwayTeam()+"]");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("feailed due to:["+e.getMessage()+"]");
		}
	}
	@Test
	public void testSUpdateCommandExecute() {
		UpdateCommand command = new UpdateCommand();
		try {
			Goal goal=(Goal) command.execute("11 'West Germany' Haller ");
			if(!goal.getTeam().equalsIgnoreCase("West Germany"))
			{
				fail("feailed due to discrepancy in home team, excpected:[West Germany] but got:["+goal.getTeam()+"]");
			}
			if(!goal.getScorer().trim().equalsIgnoreCase("Haller"))
			{
				fail("feailed due to discrepancy in goal scorer, excpected:[Haller] but got:["+goal.getScorer()+"]");
			}
			if(goal.getMinute()!=11)
			{
				fail("feailed due to discrepancy in goal Minute, excpected:[11] but got:["+goal.getMinute()+"]");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("feailed due to:["+e.getMessage()+"]");
		}
	}
		@Test
		public void testEndCommandExecute() {
			EndCommand command = new EndCommand();
			try {
				String key= (String) command.execute("End: 'England' vs. 'West Germany'   " );
				if(!key.trim().equalsIgnoreCase("England-West Germany"))
				{
					fail("feailed due to discrepancy in end gommand, excpected: home team [England] and away [West Germany] but got:["+key+"]");
				}
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				fail("feailed due to:["+e.getMessage()+"]");
			}
	}
}
