/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prj321.filter;

import com.prj321.model.Account;
import com.prj321.securityConfig.AuthorConfig;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class AuthorFilter implements Filter {
    
    AuthorConfig config = new AuthorConfig();
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
       
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String servletPath = req.getServletPath();
        System.out.println("This is AuthorFilter: " + servletPath);
        
        HttpSession session = req.getSession();
         Account user = (Account) session.getAttribute("user");
        if (user != null){
            String roleId = user.getRoles().get(0);
            
            System.out.println("ADMIN: " + config.getADMIN());
            System.out.println("MOD: " + config.getMOD());
            
            if (config.isAuthorized(roleId, servletPath)){
                chain.doFilter(request, response);
            } else {
                req.getRequestDispatcher("../../author-denied.jsp").forward(request, response);
            }
        } 
    }

    @Override
    public void destroy() {
       
    }
    
}
