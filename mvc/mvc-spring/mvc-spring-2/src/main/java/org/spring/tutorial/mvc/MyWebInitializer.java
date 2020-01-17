package org.spring.tutorial.mvc;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class MyWebInitializer implements WebApplicationInitializer {

    /*
     * WebApplicationInitializer is an interface provided by Spring MVC that ensures your code-based configuration is detected and
     * automatically used to initialize any Servlet 3 container. An abstract base class implementation of this interface named
     * AbstractAnnotationConfigDispatcherServletInitializer makes it even easier to register the DispatcherServlet by simply
     * specifying its servlet mapping and listing configuration classes - it�s even the recommended way to set up your Spring MVC
     * application.
     */

    public void onStartup(ServletContext container) {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);//we can add more than one class

        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(MvcConfig.class);

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = container.addServlet("example", new DispatcherServlet(dispatcherServlet));//example is the servlet name
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/example/*");//servlet mapping, all requests starting by /example/<any_url> will be treated by this dispatcher servlet
        
        /*
         * In the preceding example, all requests starting with /example will be handled by the DispatcherServlet instance named example
         * xml configuration (in the web.xml file)
         * <web-app>
			    <servlet>
			        <servlet-name>example</servlet-name>
			        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
			        <load-on-startup>1</load-on-startup>
			    </servlet>
			
			    <servlet-mapping>
			        <servlet-name>example</servlet-name>
			        <url-pattern>/example/*</url-pattern>
			    </servlet-mapping>
			</web-app>
         */

        //second dispatcher servlet
        //creation
        AnnotationConfigWebApplicationContext dispatcherServletUser = new AnnotationConfigWebApplicationContext();
        dispatcherServletUser.register(MvcConfigUser.class);

        //subscription
        ServletRegistration.Dynamic dispatcherUser = container.addServlet("dispatcherUser", new DispatcherServlet(dispatcherServletUser));
        dispatcherUser.setLoadOnStartup(2);
        dispatcherUser.addMapping("/");

        // Register the HiddenHttpMethodFilter filter : used to intercept and switch the put and delete requests
        FilterRegistration.Dynamic hiddenHttpMethodFilter = container.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter());
        hiddenHttpMethodFilter.addMappingForUrlPatterns(null, false, "/*");

    }

}
