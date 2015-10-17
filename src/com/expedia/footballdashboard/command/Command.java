package com.expedia.footballdashboard.command;

public interface Command {
  
	 void validatePattern(String command ) throws Exception; 
	  Object execute(String command  ) throws Exception;
	  Object buisnessValidateAndAssignValues(Object dto) throws Exception;
	  
}
