package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.prj321.dao.EmployeeDAO;
import java.util.ArrayList;
import java.util.List;
import com.prj321.model.Employee;

public final class employee_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 
            EmployeeDAO empDao = new EmployeeDAO();
            List<Employee> empList = empDao.getEmployees();
        
      out.write("\n");
      out.write("        \n");
      out.write("        <form action=\"/CRUDEmployee/view/insert.jsp\" method=\"get\">\n");
      out.write("            <input type=\"submit\" value=\"Insert\">\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        <table border=\"2px\">\n");
      out.write("                <tr>\n");
      out.write("                    <th><span>ID</span></th>\n");
      out.write("                    <th><span>First Name</span></th>\n");
      out.write("                    <th><span>Last Name</span></th>\n");
      out.write("                    <th><span>Address</span></th>\n");
      out.write("                    <th><span>Gender</span></th>\n");
      out.write("                    <th><span>Join Date</span></th>\n");
      out.write("                    <th><span>Action</span></th>\n");
      out.write("                </tr>\n");
      out.write("            ");
for (int i = 0; i < empList.size(); i++) { 
      out.write("\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( empList.get(i).getId() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( empList.get(i).getFirsName());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( empList.get(i).getLastName());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( empList.get(i).getAddress() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( empList.get(i).getGender() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( empList.get(i).getJoin_date() );
      out.write("</td>\n");
      out.write("                    <td><a href=\"/CRUDEmployee/CRUDServlet?command=get&id=");
      out.print( empList.get(i).getId());
      out.write("\">Update</a>\n");
      out.write("                         | \n");
      out.write("                        <a href=\"/CRUDEmployee/CRUDServlet?command=delete&id=");
      out.print( empList.get(i).getId());
      out.write("\">Delete</a>\n");
      out.write("                    </td>\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("            \n");
      out.write("            ");
}
      out.write("\n");
      out.write("            \n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
