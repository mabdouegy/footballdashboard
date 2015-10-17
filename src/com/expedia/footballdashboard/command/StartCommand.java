package com.expedia.footballdashboard.command;

 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.expedia.footballdashboard.dto.StartCommandDto;
import com.expedia.footballdashboard.model.CommandPatternConstants;
import com.expedia.footballdashboard.model.Goal;
import com.expedia.footballdashboard.model.Match;

public class StartCommand  implements Command{	
	public StartCommand(){
		

	}
	@Override
	public Match execute(String command) {
				Pattern r = Pattern.compile(CommandPatternConstants.startCommandPattern); 
				Match match= new Match();
				Matcher m = r.matcher(command.trim());
				//O(1) loop, will run only once
				while (m.find()) {
					match.setHomeTeam(  m.group(1));
					match.setAwayTeam(m.group(2));
					match.setHomeTeamScore(0);
					match.setAwayTTeamScore(0);
					match.setTimer(0);
					match.setHomeTeamgaols(new ArrayList<Goal>());
					match.setAwayTeamgaols(new ArrayList<Goal>());		
			}
			return match;

	}
	@Override
	public Object buisnessValidateAndAssignValues(Object dto) throws Exception {
		StartCommandDto startDto=(StartCommandDto) dto;
		Match match = startDto.getMatch();
		String key=startDto.getMatch().getHomeTeam().toLowerCase()+"-"+startDto.getMatch().getAwayTeam().toLowerCase();
		if (  startDto.getMatch()!=null && startDto.getMatches()!=null&& startDto.getMatches().containsKey(key))
		{
			throw new Exception("input error - Match"+match.getHomeTeam()+" vs. "+match.getAwayTeam()+" already started");
		}
		else	if (startDto.getMatch()==null   )
			{
			throw new Exception("error, please refer to customer support");
			}
		else	
		{
			if(startDto.getMatches()==null)
				startDto.setMatches(new HashMap<String,Match>());
			startDto.getMatches().put(match.getHomeTeam().toLowerCase()+"-"+match.getAwayTeam().toLowerCase(), match);
	 
		}
		return startDto.getMatches();
	}
	
	@Override 
	public void validatePattern(String command ) throws Exception {
		
		if(!Pattern.matches(CommandPatternConstants.startCommandPattern , command.trim()))
			throw new Exception("'input error - please enter a valid command");
	}
 
	
	 
}