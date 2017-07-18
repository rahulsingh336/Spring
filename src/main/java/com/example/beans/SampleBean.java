package com.example.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.example.listener.BeanEvent;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SampleBean implements BeanPostProcessor,AuditLog{
	
	 @Autowired
	 private ApplicationEventPublisher publisher;

	
	public void testSampleBean(){
		System.out.println("calling method of Sample Bean");
	}
	
	private int rndNumber;
    
    public int getRndNumber(){
        return rndNumber;
    }
    public void setRndNumber(int rndNumber){
        this.rndNumber = rndNumber;
    }
      
    public void generateRndNumber(){
        this.rndNumber = (int) (Math.random() * 99999);
    }

    
  //You must override this method; It will give you acces to ApplicationEventPublisher
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }


	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		
		return bean;
	}


	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		//publishing the event here
		// May set some values for event bean type
		//System.out.println("---before initialization ------ " + bean.getClass().getName());
		if(bean instanceof AuditLog) {
			publisher.publishEvent(new BeanEvent(this, "CREATE", SampleBean.class));
		} 
		 
		return bean;
	}
}
