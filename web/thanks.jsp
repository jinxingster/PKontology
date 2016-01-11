<%-- 
    Document   : thanks
    Created on : 2-Jan-2016, 12:19:27 AM
    Author     : Jin Xing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection,java.sql.DriverManager,java.sql.PreparedStatement,java.sql.SQLException" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thank you</title>
    </head>
    <body>
        <h1>Thank you for submitting   <%= request.getParameter("title") %> of <%= request.getParameter("nofkeys") %> keywords :</h1>
       <%
          int j=Integer.parseInt(request.getParameter("nofkeys"));
          
          try{
          String paper=request.getParameter("title").toString();
          // store the paper-keyword relationship in mysql first.
           String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
           String DB_URL = "jdbc:mysql://localhost/pkmodel";
           String USER="jin";
           String PASS="P123assword26";
           Connection conn = null;
           PreparedStatement stmt = null;
           Class.forName("com.mysql.jdbc.Driver");
           conn = DriverManager.getConnection(DB_URL,USER,PASS);
              
           stmt = conn.prepareStatement("INSERT INTO tterm (PAPER, KEYWORD, RELATIONSHIP, VALUE)  VALUES(?,?,?,?)");
           for (int i=1;i<=j;i++)
           {
              String a="term"+i;
              String b="value"+i;
              String c=request.getParameter(a);
              String d=request.getParameter(b);
              out.println(c +"  is tagged as  "+d+"</br>");
              stmt.setString(1, paper);
              stmt.setString(2,c);
              stmt.setString(3,"CORRELATION");
              stmt.setInt(4, Integer.parseInt(d));
              stmt.executeUpdate();
              stmt.clearParameters();
           }
           
           //close the database connection
           stmt.close();
           conn.close();
          }catch(Exception e){
              e.printStackTrace();
          }
       
         
          
       
       %>

    </body>
</html>
