package org.spring.tutorial.examples.core.postConstructPreDestroy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeObject {

	public PrototypeObject() {
		System.out.println("> build Prototype ...");
	}
	
	@PostConstruct
	public void init(){
		System.out.println("> init Prototype ...");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("> destroy Prototype ...");
	}
	
	/*
	 * @PostConstruct and @PreDestroy are java annotations and not spring
	 *
	 * @PostConstruct is called after the construction of the object (by its constructor)
	 * @PostConstruct will not be called directly after the constructor. it will be called
	 * after the setters execution (spring uses the setters for injection)
	 *
	 * @PreDestroy is called just before the object is destroyed
	 * in our case the destory method is useless because spring
	 * will not call @PreDestroy unless the object is sigleton
	 */
}
