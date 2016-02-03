/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class output extends HttpServlet {

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
             String DB_URL = "jdbc:mysql://pkmodeldb.crtsgnnnfmdi.us-east-1.rds.amazonaws.com/pkmodel";
             String USER="jxing";
             String PASS="P123assword26$";;
             Connection conn = null;
             PreparedStatement stmt = null;
             Class.forName("com.mysql.jdbc.Driver");


            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String query = "SELECT PAPER,KEYWORD,VALUE FROM pkmodel.tterm";
            
            
            Statement st = conn.createStatement();
       
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet output</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Here is the list of terms:</h1>");
            while (rs.next())
                {
                    
                   String paper=rs.getString("PAPER");
                   String term=rs.getString("KEYWORD");
                   String value=rs.getString("VALUE");
                   String restl="Paper: "+paper+"&nbsp;||Term: "+term+"&nbsp;||Value:"+value;
                   out.println(restl);
                   out.println("<br>");
                  
                }
            
            out.println("</body>");
            out.println("</html>");
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(output.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(output.class.getName()).log(Level.SEVERE, null, ex);
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
