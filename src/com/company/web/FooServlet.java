package com.company.web;

import com.company.foo.Foo;
import com.company.foo.FooService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.IOException;

public class FooServlet extends javax.servlet.http.HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Param 2: "+config.getInitParameter("param2"));
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        System.out.println("Request received!");

        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

        FooService fooService = applicationContext.getBean(FooService.class);

        Foo foo = fooService.createFoo(request.getParameter("name"));

        request.setAttribute("model", foo);

        request.getRequestDispatcher("/WEB-INF/foo.jsp").forward(request,response);
    }
}
