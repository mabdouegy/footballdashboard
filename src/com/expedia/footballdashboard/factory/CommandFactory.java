package com.expedia.footballdashboard.factory;

import java.util.regex.Pattern;

import com.expedia.footballdashboard.command.Command;
import com.expedia.footballdashboard.command.EndCommand;
import com.expedia.footballdashboard.command.StartCommand;
import com.expedia.footballdashboard.command.UpdateCommand;
import com.expedia.footballdashboard.model.CommandPatternConstants;

public class CommandFactory   {

	 StartCommand startCommand = new StartCommand();
	 UpdateCommand updateCommand = new UpdateCommand();
	 EndCommand endCommand = new EndCommand();
	public   Command produceCommandObject(String command) throws Exception {
		 
		if(Pattern.matches(CommandPatternConstants.startCommandPattern , command))
		{
			startCommand= new StartCommand();
			 return startCommand;
		}
		else if (Pattern.matches(CommandPatternConstants.udateCommandPattern , command))
		{
			updateCommand= new UpdateCommand();
			 return updateCommand;
		}
		else if (Pattern.matches(CommandPatternConstants.endCommandPattern , command))
		{
			endCommand= new EndCommand();
			 return endCommand;
		}
		throw new Exception("input error -command not recognized");
	}

}
