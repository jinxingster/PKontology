/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ROUROU
 */
public class serv extends HttpServlet {

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
           String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
           String DB_URL = "jdbc:mysql://localhost/pkmodel";
           String USER="jin";
           String PASS="P123assword26";
           Connection conn = null;
           PreparedStatement stmt = null;
             Class.forName("com.mysql.jdbc.Driver");


            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            
            System.out.println("Creating statement...");
           
            stmt = conn.prepareStatement("INSERT INTO tpaper (TITLE, AUTHOR, PUBLISHED, YEAR, MYNAME, NOFKEYS, COMMENT)  VALUES(?,?,?,?,?,?,?)");
            //SQLiteConnection db = new SQLiteConnection(dbyFile);
            String num=request.getParameter("nofkeys").toString();
            String nam=request.getParameter("name").toString();
            String author=request.getParameter("author").toString();
            String year=request.getParameter("year").toString();
            String publishe=request.getParameter("publishe").toString();
            String myname=request.getParameter("myname").toString();
            String comment=request.getParameter("comment").toString();
            
                              
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>term model</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Please model the " + num + " keywords for "+nam+" </h1>");
            //Here we generat the number of keywords input form
            out.println("<form action=\"thanks.jsp\" method=\"post\">");
            out.println("<input type=\"hidden\" value=" + "\""+nam+"\"" +"name=\"title\" />");
            out.println("<input type=\"hidden\" value=" + "\""+num+"\"" +"name=\"nofkeys\" />");
            out.println("<table>");
            
            
            out.println("<tr>");
            out.println("<td>The Term &nbsp;&nbsp;&nbsp;&nbsp;</td>");
            out.println("<td>Keyword &nbsp;&nbsp;&nbsp;&nbsp;</td>");
            out.println("<td>Value&nbsp;&nbsp;"+"(1=Weakest and 10=Strongest)"+"</td>");
            out.println("</tr>");
            int i = Integer.parseInt(num);
            int j;
            for (j=1;j<=i;j++)
            {
                out.println("<tr>");
                out.println("<td>"+j+"</td>");
                out.println("<td>"+"<input type=\"text\" name=\"term"+j+"\""+">"+"</td>");
                out.println("<td>"+"<input type=\"text\" name=\"value"+j+"\""+">"+"</td>");
                
                out.println("</tr>");
            }
            
            out.println("</table>");
            //The sumbit button
            out.println("<input type=\"submit\" value=\"submit\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
           // SQLiteStatement statement = db.prepare("INSERT INTO paper (NAME, AUTHOR, PUBLISHE, YEAR, MYNAME, NOFKEYS, COMMENT)  VALUES(?,?,?,?,?,?,?)");
            
            stmt.setString(1, nam);
            stmt.setString(2,author);
            stmt.setString(3,publishe);
	    stmt.setString(4,year);
            stmt.setString(5,myname);
            int thenum=Integer.parseInt(num);
            stmt.setInt(6,thenum);
	    stmt.setString(7,comment);
	    stmt.executeUpdate();
	    stmt.close();
            
            out.close();
            conn.close();
        }  catch (ClassNotFoundException ex) {
            Logger.getLogger(serv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(serv.class.getName()).log(Level.SEVERE, null, ex);
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
