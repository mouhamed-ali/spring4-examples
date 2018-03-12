package org.spring.tutorial.examples.core.postConstructPreDestroy;

public class BeanObject {

	public BeanObject() {
		System.out.println("> build BeanObject ...");
	}
	
	public void init(){
		System.out.println("> init BeanObject ...");
	}
	
	public void destroy(){
		System.out.println("> destroy BeanObject ...");
	}
}
