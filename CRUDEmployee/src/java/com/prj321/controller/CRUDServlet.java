/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prj321.controller;

import com.prj321.dao.EmployeeDAO;
import com.prj321.model.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class CRUDServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CRUDServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CRUDServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        
        String command = request.getParameter("command");
        if (command.equals("insert")){
            addEmp(request, response);
            forward(request, response, "/view/employee_list.jsp");
        } else if (command.equals("get")){
            String id = request.getParameter("id");
            Employee emp = getEmp(id);
            request.setAttribute("emp", emp);
            forward(request, response, "/view/update.jsp");
        }
        else if (command.equals("delete")){
            String id = request.getParameter("id");
            deleteEmp(request, response, id);
            forward(request, response, "/view/employee_list.jsp");
        } else if (command.equals("update")){
            String oldId = request.getParameter("oldId");
            updateEmp(request, response, oldId);
            forward(request, response, "/view/employee_list.jsp");
        }
        
        
        
        
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
    
    
    public void addEmp(HttpServletRequest request, HttpServletResponse response){
        EmployeeDAO empDao = new EmployeeDAO();
        
        String id = request.getParameter("id");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String joinDate = request.getParameter("joinDate");
        
        Employee emp = new Employee(id, firstName, lastName, 
                address, gender, joinDate);
        
        empDao.addEmployee(emp);
    }
    
    public void deleteEmp(HttpServletRequest request, HttpServletResponse response,
                        String id){
        EmployeeDAO empDao = new EmployeeDAO();
        empDao.deleteEmployee(id);
    }
    
    public Employee getEmp(String id){
        EmployeeDAO empDao = new EmployeeDAO();
        Employee emp = empDao.getEmployee(id);
        return emp;
    }
    
    public void updateEmp (HttpServletRequest request, HttpServletResponse response
                            , String oldId){
        EmployeeDAO empDao = new EmployeeDAO();
        
        String id = request.getParameter("id");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String joinDate = request.getParameter("joinDate");
        
        Employee emp = new Employee(id, firstName, lastName, 
                address, gender, joinDate);
        
        empDao.updateEmployee(emp, oldId);
    }
    
    public void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException{
        request.getRequestDispatcher(url).forward(request, response);
    }
    
}
