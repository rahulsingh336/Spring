package com.example.monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

import com.example.listener.ApplicationEventListener;

@ManagedResource(objectName = "com.example:type=JMX,name=AppMonitor")
public class AppMonitor implements IAppMonitor{
	
 
	@Autowired
	private ApplicationEventListener eventListener;
	
	@ManagedOperation
    @Override
    public int getObjectCount() {
    	//It can also be dynamic
        return eventListener.getEventsMap().get("CREATE").intValue();
    }
 
 }
