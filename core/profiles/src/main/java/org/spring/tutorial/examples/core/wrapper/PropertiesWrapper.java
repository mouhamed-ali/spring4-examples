package org.spring.tutorial.examples.core.wrapper;

import java.util.ArrayList;
import java.util.List;

public class PropertiesWrapper {

	private List<String> properties;
	
	public PropertiesWrapper() {
		
		properties = new ArrayList<String>();
	}
	
	public void setProperty(String prop){
		
		properties.add(prop);
	}
	
	public void showProperties(){

		System.out.println();
		for(String prop : properties){
			System.out.print(" > "+prop+" , ");
		}
		System.out.println();
		System.out.println();
	}
}
