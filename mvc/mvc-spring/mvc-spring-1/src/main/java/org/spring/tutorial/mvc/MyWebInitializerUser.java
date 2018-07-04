package org.spring.tutorial.mvc;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class MyWebInitializerUser extends AbstractAnnotationConfigDispatcherServletInitializer {

    /*
     * if we want to add a new dispatcher servlet. we can create a second class that extends AbstractAnnotationConfigDispatcherServletInitializer
     * and use the same configuration
     * that's will not work :p . i tried it but it does not work. it's gonna be a TODO
     * i think that it doesn't work. check this https://stackoverflow.com/questions/28877982/spring-java-config-with-multiple-dispatchers
     */

    @Override
    protected Class<?>[] getRootConfigClasses() {
        /*
         * service layer context declaration
         */
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        /*
         * web layer context declaration
         */
        return new Class[]{MvcConfigUser.class};
    }

    @Override
    protected String[] getServletMappings() {

		/*
			routes declaration :
			any /hello-mvc/user/any request will be treated by this dispatcher Servlet (we can have more than one
			dispatcher in an application)
		 */
        return new String[]{"/hello-mvc/user/*"};
    }

    @Override
    protected String getServletName() {

        return "userServlet";
    }

    @Override
    protected Filter[] getServletFilters() {
        /*
         * why we use this filter ?
         * the put and delete methods are not supported by some browsers so spring will change calls (in forms) delete
         * and put into post calls by adding an input hidden which has the value of delete
         * <input type="hidden" name="_method" value="delete">
         * this filter will intercept these calls and redirect them to our routes that exploit the delete and put calls
         */
        return new Filter[]{new HiddenHttpMethodFilter()};
    }
}
