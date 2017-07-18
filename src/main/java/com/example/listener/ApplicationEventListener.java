package com.example.listener;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;



@Component
public class ApplicationEventListener implements ApplicationListener<BeanEvent> {
	
	
	Map<String, Integer> eventsMap = new ConcurrentHashMap<String, Integer>();
	
	@Override
	public void onApplicationEvent(BeanEvent event) {
	
		BeanEvent sampleEvent = (BeanEvent) event;
		 
       // Do more processing as per application logic
        
        if (null != eventsMap.get(sampleEvent.getEventType())) {
        	
        	int counter = eventsMap.get(sampleEvent.getEventType());
        	counter++;
        	eventsMap.put(sampleEvent.getEventType(), counter);
        	
        } else {
        	
        	eventsMap.put(sampleEvent.getEventType(), 1);
        }
        
        // Printing logged events
        
        for (Map.Entry<String, Integer> loggedEvents : eventsMap.entrySet()) {
			System.out.println("Event Type" + "  " + loggedEvents.getKey() + " Size of Event " +"  "+loggedEvents.getValue());
		}
		
	}

	public Map<String, Integer> getEventsMap() {
		return eventsMap;
	}
	
	

}
