/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prj321.filter;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Admin
 */
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Log Init");
        
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
        HttpServletRequest req = (HttpServletRequest) request;
//        String logRequest = (String)req.getServletContext().getAttribute("log");
//        if (logRequest == null){
//            logRequest = "";
//        }
        
        String logRequest = "#INFO: ||" + formatter.format(date)+ "|| Request URL:  " +req.getRequestURL() + "\n";
        
        
        req.getServletContext().setAttribute("log", logRequest);
        System.out.println(logRequest);
        System.out.println(req.getServletPath());
        chain.doFilter(request, response);
        
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
