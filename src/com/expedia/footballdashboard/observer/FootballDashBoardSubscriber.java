package com.expedia.footballdashboard.observer;

import java.util.Map;

import com.expedia.footballdashboard.command.Command;
import com.expedia.footballdashboard.command.EndCommand;
import com.expedia.footballdashboard.command.StartCommand;
import com.expedia.footballdashboard.command.UpdateCommand;
import com.expedia.footballdashboard.dto.EndCommandDto;
import com.expedia.footballdashboard.dto.StartCommandDto;
import com.expedia.footballdashboard.dto.UpdateCommandDto;
import com.expedia.footballdashboard.factory.CommandFactory;
import com.expedia.footballdashboard.model.Goal;
import com.expedia.footballdashboard.model.Match;
 

public class FootballDashBoardSubscriber implements Observer {
	private String name;
    private Subject topic;
    private Map<String, Match> matches ;
	Command footballDashBoardcommand    ;
	CommandFactory CommandFactory= new CommandFactory();
    public FootballDashBoardSubscriber(String name){
        this.name=name;
    }
	@Override
	public void update() throws Exception {
		 String msg = (String) topic.getUpdate(this);
 
	        processCommand(msg);
	}

	@Override
	public void setSubject(Subject sub) {
		this.topic=sub;
	}
	private void processCommand(String command) throws Exception
	{
		try
		{
			footballDashBoardcommand=CommandFactory.produceCommandObject(command);
		}
		catch(Exception e)
		{
			//TODO Fullfil initial requirment, this could had been handled in a better way , can be discussed with the team during the code review
			if (matches==null || matches.size()==0)
				throw new Exception(" 'input error - please start a game through typing 'Start:'<Name of Home Team>' vs. '<Name of Away Team>''.");
			else
				throw new Exception("'input error - please type 'print' for game details'.");
		}
		footballDashBoardcommand.validatePattern(command);
		Object result= footballDashBoardcommand.execute(command);
		Object dtoObject=null;
		if(footballDashBoardcommand instanceof StartCommand)
		{
			StartCommandDto startCommandDto= new StartCommandDto();
			startCommandDto.setMatch((Match) result);
			startCommandDto.setMatches(matches);
			dtoObject=startCommandDto;
	 	}
		if(footballDashBoardcommand instanceof UpdateCommand)
		{
			UpdateCommandDto updatetCommandDto= new UpdateCommandDto();
			updatetCommandDto.setGoal((Goal) result);
			updatetCommandDto.setMatches(matches);
			dtoObject=updatetCommandDto;			
		}
		if(footballDashBoardcommand instanceof EndCommand)
		{
			EndCommandDto endCommandDto= new EndCommandDto();
			endCommandDto.setMatches(matches);
			endCommandDto.setKey(result.toString());
			dtoObject=endCommandDto;	
		}
		matches= (Map<String, Match>) footballDashBoardcommand.buisnessValidateAndAssignValues(dtoObject) ;
	}
	@Override
	public Match findMatchesInList(String key) 
		{
		if ( matches !=null && matches.containsKey(key.trim().toLowerCase()))
				return matches.get(key.trim().toLowerCase());
			else return null;
			
		}
	 
	 
}
