package com.expedia.footballdashboard.observer;

import com.expedia.footballdashboard.model.Match;

public interface Observer {
		public void update()  throws Exception ;  
	 public void setSubject(Subject sub);
	Match findMatchesInList(String key);
}
