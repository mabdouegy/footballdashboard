package com.expedia.footballdashboard.runner;

 import java.util.Scanner;

import com.expedia.footballdashboard.model.Match;
import com.expedia.footballdashboard.observer.FootballDashBoardSubscriber;
import com.expedia.footballdashboard.observer.FootballDashBoardPublisher;
import com.expedia.footballdashboard.observer.Observer;
import com.expedia.footballdashboard.printer.BasicPrinter;

public class AssigmentRunner {
	public static void main(String[] args) {
		AssigmentRunner runner = new AssigmentRunner();
        boolean loop = true;
        FootballDashBoardPublisher footballDashBoardPublisher = new FootballDashBoardPublisher();
        Observer footballDashBoardService = new FootballDashBoardSubscriber("Expedia Football Dashboard");
        footballDashBoardService.setSubject(footballDashBoardPublisher);
        footballDashBoardPublisher.register(footballDashBoardService);
        runner.displayOptions();
        Scanner keyboard = new Scanner(System.in);
        int choice =0;
        BasicPrinter printer = new BasicPrinter();
        String	temp=null;
        while (loop)
        {   
           
           temp=keyboard.nextLine();
           try
           {
           choice = Integer.valueOf(temp);
           }
           catch (Exception e)
           {
        	   choice=0; 
           }
            switch (choice) 
            {
            	case 1:   
            		 	System.out.println("Please enter your command ");
            		 	String command= keyboard.nextLine();
            		 	try{
            		 		footballDashBoardPublisher.postmatchCommand(command);
            		 	}
            		 	catch (Exception e)
            		 	{
            		 		System.out.println(e.getMessage());	
            		 	}
            		 	break;
            	case 2:
            			System.out.println("Please enter home team");
            			String homeTeam= keyboard.nextLine();
            			System.out.println("Please enter away team");
            			String awayTeam= keyboard.nextLine();
            			Match match=footballDashBoardService.findMatchesInList(homeTeam.trim()+"-"+awayTeam.trim());
            			if(match==null)
            				System.out.println("input error-game is not currently being played");
            			else
            				printer.printMatch(match);
            			break;
            	case 3:
        			runner.DisplayCommandExamples();
    				break;
            	case 4:
            			loop=false;
            			keyboard.close();
            			System.out.println("Bye bye");
        				break;
            	default:
            		 System.out.println("Please enter a valid choice");
            		 break;
            }
        runner.displayOptions();
        }
 
    }
	private void displayOptions()
	{
		  System.out.println("Please one of the following options: ");
		  System.out.println("1)enter a new command");
		  System.out.println("2)Print match result");
		  System.out.println("3)Display commands example");
		  System.out.println("4)Terminate the program");
		  
	}
	private void DisplayCommandExamples()
	{
		 System.out.println("to start a game write a command with the following format:[Start: '<Name of Home Team>' vs. '<Name of Away Team>']");
		 System.out.println("to End a game write a command with the following format:[End: '<Name of Home Team>' vs. '<Name of Away Team>']");
		 System.out.println("to update a game results command with the following format:[<minute> '<Team>' <name of scorer>]");
		 System.out.println("to display  game results choose 2 and then enter home and away teams without adding any '']");
			
	}
	 
}
