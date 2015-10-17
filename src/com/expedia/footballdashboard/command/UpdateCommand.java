package com.expedia.footballdashboard.command;

import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.expedia.footballdashboard.dto.UpdateCommandDto;
import com.expedia.footballdashboard.model.CommandPatternConstants;
import com.expedia.footballdashboard.model.Goal;
import com.expedia.footballdashboard.model.Match;

public class UpdateCommand  implements Command  {
 

	@Override
	public void validatePattern(String command) throws Exception {
		
		if(!Pattern.matches(CommandPatternConstants.udateCommandPattern , command.trim()))
			throw new Exception("'input error - please enter a valid command");
	}
 
			
	@Override
	public Object execute(String  command) throws Exception {
		Goal goal= null;
		if(Pattern.matches(CommandPatternConstants.udateCommandPattern , command.trim()))
		{
			Pattern pattern = Pattern.compile(CommandPatternConstants.udateCommandPattern);
			Matcher matcher = pattern.matcher(command);
			//O(1) loop, will run only once
			while (matcher.find()) {
				goal = new Goal();
				goal.setMinute( Integer.parseInt(matcher.group(1)));
				goal.setTeam( matcher.group(2));
				goal.setScorer(matcher.group(3));
			}
		}
		return goal;
	}

	 
	@Override
	public Object buisnessValidateAndAssignValues(Object dto) throws Exception {
		UpdateCommandDto updatetDto=(UpdateCommandDto) dto;
		boolean matchFound=false; 
		Map<String, Match> matches=updatetDto.getMatches();
		String teamName=updatetDto.getGoal().getTeam().toLowerCase();
		if (matches!=null)
		{
		for (Entry<String, Match> entry : matches.entrySet())
			{
			if ( entry.getKey().contains(teamName)) 
				{
				matchFound=true;
				if(entry.getValue().getHomeTeam().equalsIgnoreCase(teamName))
				{
					matches.get(entry.getKey()).setHomeTeamScore(matches.get(entry.getKey()).getHomeTeamScore()+1);
					matches.get(entry.getKey()).getHomeTeamgaols().add(updatetDto.getGoal());
				}
				else if(entry.getValue().getAwayTeam().equalsIgnoreCase(teamName))
				{
					matches.get(entry.getKey()).setAwayTTeamScore(matches.get(entry.getKey()).getAwayTTeamScore()+1);
					matches.get(entry.getKey()).getAwayTeamgaols().add(updatetDto.getGoal());
				}
				break;
				}
			}
		}
		else
		{
			throw new Exception("error, please refer to customer support");
		}
		if(!matchFound)
			throw new Exception("input error - Team:["+teamName+"] does not play any game at the moment");
		else
			return matches;
	}
	 
	
	 
}
