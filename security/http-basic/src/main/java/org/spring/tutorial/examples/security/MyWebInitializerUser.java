package org.spring.tutorial.examples.security;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebInitializerUser extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {

        //loading the security context
        return new Class[]{SecurityConfigBasic.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class[]{MvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {

        return new String[]{"/"};
    }

    @Override
    protected String getServletName() {

        return "userServlet";
    }
}
