package Project.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	private final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL="jdbc:mysql://127.0.0.1:3306/project";
	private final String JDBC_USERNAME="root";
	private final String JDBC_PASS="*****";
	private Connection conn=null;
	
	//私有化
	private DBUtils() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static DBUtils getDB(){
		return new DBUtils();
	}
	
	public Connection getCnn() {
		try {
			conn=DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	

	
	public void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void close(PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void close(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
