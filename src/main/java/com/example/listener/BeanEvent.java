package com.example.listener;

import org.springframework.context.ApplicationEvent;

import com.example.beans.SampleBean;

public class BeanEvent extends ApplicationEvent{
	
	private static final long serialVersionUID = 1L;
    
    private String eventType;
    private Class<?> classType;
     
    //Constructor's first parameter must be source
    public BeanEvent(Object source, String eventType, Class<?> classType) 
    {
        //Calling this super class constructor is necessary
        super(source);
        this.eventType = eventType;
        this.classType = classType;
    }
 
    public String getEventType() {
        return eventType;
    }
 
    public Class<?> getClassType() {
        return classType;
    }

}
