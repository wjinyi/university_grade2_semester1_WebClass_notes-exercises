package com.cn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.apache.catalina.connector.Request;

public class SearchInfoServlet extends HttpServlet {	
	private Connection cn=null;
	private Statement st=null;
	private ResultSet rs=null;	
    public SearchInfoServlet() {       
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		
		response.setContentType("text/html; charset=utf-8");	
		
		PrintWriter out = response.getWriter();		
		Connection cn=new ConnectionDB().getConnection();		
		String jsonString = "[";		
        try {
        	String param = request.getParameter("kkk");
        	
		    st=cn.createStatement();
			String sql="select * from users where name like '%" + param + "%'";
			rs = st.executeQuery(sql);			
			int k = 0;
			while(rs.next()) {
				if (k != 0) {
					jsonString += ", ";
				}				
		    	String name=rs.getString("name");
		        String date=rs.getString("birthday");
		        String email=rs.getString("email");		        
		        StudentInfo ss = new StudentInfo(name, date, email);		       
		        jsonString += ss.toJsonString();		        
		        k += 1;
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
        jsonString += "]";		
//		String testString = "[{\"sno\":\"123\",\"sname\":\"name\",\"score\":\"99\"}]";
        out.print(jsonString);
//		System.out.println(testString);
	}	
}
