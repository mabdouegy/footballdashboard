package com.expedia.footballdashboard.observer;

public interface Subject {
	public void register(Observer obj);
    public void unregister(Observer obj); 
    public void notifyAllObservers() throws Exception;
    public Object getUpdate(Observer obj);
}
