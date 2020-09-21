package com.company.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class FooListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public FooListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext servletContext = sce.getServletContext();

        System.out.println("Param 1: "+servletContext.getInitParameter("param1"));

        String serverInfo = servletContext.getServerInfo();

        System.out.println("Server Info: "+ serverInfo);

      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
    }

    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("Context Destroyed!");

      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }
}
