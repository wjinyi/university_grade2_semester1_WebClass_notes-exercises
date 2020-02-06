import java.io.IOException;
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
//
///**
// * Servlet implementation class Connect
// */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection cn=null;
	private Statement st=null;
	private ResultSet rs=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
    
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String psd=request.getParameter("psd");
		boolean flag=false;
		Connection cn=new ConnectionDB().getConnection();
        try {
		    st=cn.createStatement();
			String sql="select name,password from tb_user";
			rs=st.executeQuery(sql);
			while(rs.next()){
		    	String name=rs.getString("name");
		        String password=rs.getString("password");
		    	if((name.trim().equals(username))&&(password.trim().equals(psd))){
			    flag=true;
				break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      request.getSession().setAttribute("username", username);
        
		if(flag){
                request.getRequestDispatcher("success.jsp").forward(request, response);
                }
         else{
                request.getRequestDispatcher("error.jsp").forward(request, response);
	         }

}
}
