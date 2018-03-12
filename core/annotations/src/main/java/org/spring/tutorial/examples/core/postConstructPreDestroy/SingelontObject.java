package org.spring.tutorial.examples.core.postConstructPreDestroy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingelontObject {

	public SingelontObject() {
		System.out.println("> build Singelton ...");
	}
	
	@PostConstruct
	public void init(){
		System.out.println("> init Singelton ...");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("> destroy Singelton ...");
	}
}
