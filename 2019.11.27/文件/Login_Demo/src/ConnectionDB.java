import java.sql.*;
public class ConnectionDB {
	private static Connection cn;
	private String url="jdbc:mysql://localhost:3306/info";
	private String user="root";
	private String password="root";
	

	public ConnectionDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		     cn=DriverManager.getConnection(url,user,password);
			System.out.println("数据库连接成功 ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static Connection getConnection (){
		return cn;
	}
	public  void close(){
		if(this.cn!=null){
			try {
				this.cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
