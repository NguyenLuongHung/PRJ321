/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prj321.filter;

import com.prj321.dao.AccountDAO;
import com.prj321.model.Account;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class AuthenFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        AccountDAO accountDAO = new AccountDAO();
        HttpServletRequest req = (HttpServletRequest ) request;
        HttpSession session = req.getSession(true);
        
        if (session.getAttribute("user") != null){
            System.out.println("This is authenFilter");
            chain.doFilter(request, response);
        } else {
            String username = null;
            String password = null;
            Cookie[] cookies = req.getCookies();
            if (cookies != null){
                for ( Cookie ck: cookies){
                    if (ck.getName().equals("username")){
                        username = ck.getValue();
                    } else if (ck.getName().equals("password")){
                        password = ck.getValue();
                    } 

                }
                if (username != null && password != null){
                    Account acct = accountDAO.getAccount(username, password);
                    session.setAttribute("user", acct);
                    session.setMaxInactiveInterval(60*30);
                    System.out.println("This is authenFilter");
                    chain.doFilter(request, response);
                }
                else {
                    System.out.println("This is authenFilter");
                    req.getRequestDispatcher("/access-denied.jsp").forward(request, response);
                }
            }
        } 
    }

    @Override
    public void destroy() {

    }
    
}
