package application.DAO;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.bean.*;
import application.Util.DBconnection;

public class StandardDAO {

	 private Connection con=null;
	  private Statement stmt=null;
	  private int flag;
	  private String query=null;
	  
	  public StandardDAO(){
		  try {
	        	con = DBconnection.getConnection();
	            stmt = con.createStatement();
				stmt.execute("SET SEARCH_PATH TO egov;");
				
					
				       
			   } catch (SQLException e) {
				// TODO Auto-generated catch block
			   e.printStackTrace();}
			  }
	  
	  public boolean insert(Standards standards) throws SQLException{
		  try {
	          stmt=con.createStatement();
		       query="insert into standards(standardname)values('"+
	          standards.getStandardname()+"')";
		       
		       flag=stmt.executeUpdate(query);
		       
	          System.out.println("flag insert: "+ flag);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				   e.printStackTrace(); }
		            finally{
			              
			                  System.out.println("connection closed after inserting into standard"); 
			                }
		   if(flag!=0)
			   return true;     
		   else
		     return false;
	  }
	  
	  
	  public boolean update(Standards standards) throws SQLException{
		     
			int flag=0; 
			try {
				stmt=con.createStatement();
				 query="update standards set  standardname='" + standards.getStandardname()
			      + "' where stand_id='"+ standards.getStand_id() +"'";
				 
		         flag=stmt.executeUpdate(query);
		       System.out.println("flag in update" + flag);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				
				System.out.println("connection closed for update standards ");
			}
			  if(flag!=0){
		     	 return true;	 
		      }else{
		    	  return false;	  
		      }
	  } 
	  
	  public boolean delete(Standards standards ) throws SQLException{
			
			int flag=0;

		       try {
				stmt=con.createStatement();
				 query="delete from standards where stand_id='" + standards.getStand_id() +"'";
			       flag=stmt.executeUpdate(query);
			       
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		      finally{
				
				System.out.println("connection closed for delete standards");
			}
		       if(flag!=0)return true;
		       else return false;		 

   }
	  
	  public ArrayList getallstandards() throws SQLException{
		  ArrayList data=new ArrayList();
		  Standards standards=null;
		  ResultSet rs=null;
			try {
          query="select * from standards order by stand_id;";
				rs = stmt.executeQuery(query);
				
				 while(rs.next()){
					standards=new Standards();
					standards.setStand_id(rs.getInt("stand_id"));
					standards.setStandardname(rs.getString("standardname"));
			        data.add(standards);
				 	   }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("at standards:" + e.getMessage());
		         e.printStackTrace();
			}
			finally{
				
				System.out.println("connection closed FOR LISTDATA");
			}
		   
		    	return data;
             }
	  
	  
}

