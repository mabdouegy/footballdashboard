package com.expedia.footballdashboard.observer;

import java.util.ArrayList;
import java.util.List;

 
public class FootballDashBoardPublisher implements Subject {
	private List<Observer> observers;
    private boolean changed;
    private String command;
	private final Object MUTEX= new Object();
	 public FootballDashBoardPublisher(){
	        this.observers=new ArrayList<>();
	    }
	@Override
	public void register(Observer obj) {
		if(obj == null) throw new NullPointerException("Null Observer");
		
        synchronized (MUTEX) {
        if(!observers.contains(obj)) observers.add(obj);
        }	
	}

	@Override
	public void unregister(Observer obj) {
		 synchronized (MUTEX) {
		 observers.remove(obj);
		 }
	}

	@Override
	public void notifyAllObservers() throws Exception{
		 List<Observer> observersLocal = null;
	        //synchronization is used to make sure any observer registered after message is received is not notified
	        synchronized (MUTEX) {
	            if (!changed)
	                return;
	            observersLocal = new ArrayList<>(this.observers);
	            this.changed=false;
	        }
	        for (Observer obj : observersLocal) {
	            obj.update();
	        }
	}

	@Override
	public Object getUpdate(Observer obj) {
		   return this.command;
	}
	
	public void postmatchCommand(String command)  throws Exception{
        this.command=command;
        this.changed=true;
        notifyAllObservers();
    }

}
