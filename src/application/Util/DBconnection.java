package application.Util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBconnection {

	private static String db_url="jdbc:postgresql://localhost:5432/eGovDB";
	private static String db_user="postgres";
	private static String db_password="77777";
	private static String db_driver="org.postgresql.Driver";
	
	public static Connection getConnection(){
		Connection con=null;
		try{
		Class.forName(db_driver);
		con=DriverManager.getConnection(db_url,db_user,db_password);
	   }
		catch(ClassNotFoundException e){
			  System.out.println("PostgreSQL Driver not found");
			e.printStackTrace();
		}
		catch(SQLException e){
			System.out.println("DB Connection could not be established");
			e.printStackTrace();
		}
		
		return con;
		
		
	}
	public static void main(String a[]){
		Connection con=getConnection();
		if(con!=null){
			System.out.println("connected");
		
			
		}
		else{
			System.out.println("not connected");
			
		}
	}
	
	
}

