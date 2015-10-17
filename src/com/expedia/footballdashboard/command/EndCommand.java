package com.expedia.footballdashboard.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.expedia.footballdashboard.dto.EndCommandDto;
import com.expedia.footballdashboard.model.CommandPatternConstants;

public class EndCommand  implements Command  {
 

	@Override
	public void validatePattern(String command ) throws Exception {
		
		if(!Pattern.matches(CommandPatternConstants.endCommandPattern , command.trim()))
			throw new Exception("'input error - please enter a valid command");
	}
 
			
	@Override
	public Object execute(String  command) throws Exception {
		Pattern r = Pattern.compile(CommandPatternConstants.endCommandPattern ); 
		Matcher m = r.matcher(command.trim());
		//O(1) loop, will run only once
		while (m.find()) {
			return  m.group(1).toLowerCase()+"-"+m.group(2).toLowerCase();	
	}
		return  m.group(1).toLowerCase()+"-"+m.group(2).toLowerCase();
	}

	 
	@Override
	public Object buisnessValidateAndAssignValues(Object dto) throws Exception {
		EndCommandDto endDto=(EndCommandDto) dto;
		 
		if(endDto.getMatches()==null ||! endDto.getMatches().containsKey(endDto.getKey())  )
		{
			throw new Exception("input error - this match didn't start yet"); 
				 
		}
		else
		{
			endDto.getMatches().remove(endDto.getKey());
		}
		return endDto.getMatches();
	}
	 
	
	 
	 
 
}
