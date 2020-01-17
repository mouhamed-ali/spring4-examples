package org.spring.tutorial.examples.core.wrapper;

import java.util.ArrayList;
import java.util.List;

public class PropertiesWrapper {

	private List<String> properties;
	
	public PropertiesWrapper() {

		properties = new ArrayList<>();
	}
	
	public void setProperty(String prop){
		
		properties.add(prop);
	}
	
	public void showProperties() {

		properties.forEach(prop -> System.out.println("> " + prop));
	}
}
