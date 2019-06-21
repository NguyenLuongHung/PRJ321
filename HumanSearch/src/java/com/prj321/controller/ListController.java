/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prj321.controller;

import com.prj321.dao.HumanDao;
import com.prj321.dao.HumanTypeDao;
import com.prj321.model.Human;
import com.prj321.model.HumanType;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class ListController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        
        HumanTypeDao hmTypeDao = new HumanTypeDao();
        HumanDao hmDao = new HumanDao();
        
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String dateFrom = request.getParameter("dateFrom");
        String dateTo = request.getParameter("dateTo");
        String type = request.getParameter("type");
        
        List<HumanType> hmTypeList = null;
        List<Human> hmList = null;
        
        if (id == null && name == null && gender == null && dateFrom == null && dateTo == null && type == null){
            System.out.println("All null");
            hmList = hmDao.getHumans();
            type = "all";
            gender = "all";
            request.setAttribute("gender", gender);
            request.setAttribute("type", type);
            
        } 
        else {
            
            if (!id.equals("") ){
                System.out.println("id: " + id);
                request.setAttribute("dateFrom", "");
                request.setAttribute("dateTo", "");
                request.setAttribute("name", "");
                request.setAttribute("gender", "all");
                request.setAttribute("type", "all");
            }
            
            else  {
                System.out.println("Get here");
                id = "";
                
                request.setAttribute("name", name);
                if (name.equals("")){
                    name = "";
                }
                request.setAttribute("gender", gender);
                if (gender == null){

                    gender = "all";
                }
                request.setAttribute("dateFrom", dateFrom);
                if (dateFrom.equals("")){
                    System.out.println("DateFrom123");

                    dateFrom = "1900-01-01";
                }
                request.setAttribute("dateTo", dateTo);
                if (dateTo.equals("")){

                    dateTo = sdf.format(date);
                }
                request.setAttribute("type", type);
                if (type == null){
                    type = "all";
                }
            }
            
            
            hmList = hmDao.getHumansSearch(id, name, gender, dateFrom, dateTo, type);
            
            
            
            
        }
        request.setAttribute("id", id);
            System.out.println("Gender: " + gender);
            System.out.println("type: " + type);
//            request.setAttribute("gender", gender);
//            request.setAttribute("type", type);
        hmTypeList = hmTypeDao.getHumanTypes();
        request.setAttribute("hm_list", hmList);
        request.setAttribute("hm_type_list", hmTypeList);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
