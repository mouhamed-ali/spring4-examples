package org.spring.tutorial.examples.core.wrapper;

import java.util.Properties;
import java.util.Set;

public class PropertiesWrapper {

    private Properties properties;

    public PropertiesWrapper() {

        properties = new Properties();
    }

    public void setProperty(String key, String value) {

        properties.setProperty(key, value);
    }

    public void showProperties() {

        getAllKeys().forEach(key -> System.out.println(key + " : " + getPropertyValue((String) key)));
    }

    public Set<Object> getAllKeys() {
        Set<Object> keys = properties.keySet();
        return keys;
    }

    public String getPropertyValue(String key) {
        return this.properties.getProperty(key);
    }
}
