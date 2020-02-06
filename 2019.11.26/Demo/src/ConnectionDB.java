import java.sql.*;
//ConnectionDB连接数据库
public class ConnectionDB {
	private static Connection cn;
	private String url="jdbc:mysql://localhost:3306/info";
	private String user="root";
	private String password="123";
	

	public ConnectionDB() {
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接类
		     cn=DriverManager.getConnection(url,user,password);
			System.out.println("数据库连接成功！");
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
	//关闭数据库
	public  void close(){
		if(this.cn!=null){
			try {
				//关闭数据库
				this.cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
