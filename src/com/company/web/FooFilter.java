package com.company.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class FooFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("Before request handling:" + ((HttpServletRequest)req).getRequestURL());

        chain.doFilter(req, resp);

        System.out.println("After request handling");

    }

    public void init(FilterConfig config) throws ServletException {

        System.out.println("Param 3: "+ config.getInitParameter("param3"));
    }

}
