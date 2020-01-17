package org.spring.tutorial.examples.security.filters;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Set;

public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //nothing  to do
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        /*
         * we created our own filter. we will intercept the request. add some messages for our users
         * pass the treatment to the next filter
         * This remains the filter record. see the other config classes "SecurityConfigBasic".
         */
        HttpServletRequest request = (HttpServletRequest) req;//intercept the request
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // this filter will be executed for every request. if the user is not authenticated we will have several NullPointerException, authentication may be null, roles may be null
        if (authentication != null) {
            Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
            if (roles != null) {
                if (roles.contains("ROLE_ADMIN")) {
                    request.getSession().setAttribute("messageAdmin", "hey admin, you are a little weirdo. you have to work harder.");
                }
                if (roles.contains("ROLE_USER")) {
                    request.getSession().setAttribute("messageUser", "hey user, you are awesome. you are our fortune.");
                }
            }
        }
        if (request != null) {
            request.setAttribute("passedByFilter", "this request passed by the custom filter (-_-) !!!");
        }
        chain.doFilter(req, response);
    }

    @Override
    public void destroy() {
        //nothing  to do
    }
}
