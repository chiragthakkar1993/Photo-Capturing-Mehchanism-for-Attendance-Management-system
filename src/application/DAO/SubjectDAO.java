package application.DAO;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import application.bean.*;
import application.Util.DBconnection;

public class SubjectDAO {

	 private Connection con=null;
	  private Statement stmt=null;
	  private int flag;
	  private String query=null;
	  
	  public SubjectDAO(){
		  try {
	        	con = DBconnection.getConnection();
	            stmt = con.createStatement();
				stmt.execute("SET SEARCH_PATH TO egov;");
				
					
				       
			   } catch (SQLException e) {
				// TODO Auto-generated catch block
			   e.printStackTrace();}
			  }
	  
	  public boolean insert(Subjects subjects) throws SQLException{
		  try {
	          stmt=con.createStatement();
		       query="insert into subjects(subjectname)values('"+
	          subjects.getSubjectname()+"')";
		       
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
	  
	  
	  public boolean update(Subjects subjects) throws SQLException{
		     
			int flag=0; 
			try {
				stmt=con.createStatement();
				 query="update subjects set  subjectname='" + subjects.getSubjectname()
			      + "' where sub_id='"+ subjects.getSub_id() +"'";
				 
		         flag=stmt.executeUpdate(query);
		       System.out.println("flag in update" + flag);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				
				System.out.println("connection closed for update subjects ");
			}
			  if(flag!=0){
		     	 return true;	 
		      }else{
		    	  return false;	  
		      }
	  } 
	  
	  public boolean delete(Subjects subjects) throws SQLException{
			
			int flag=0;

		       try {
				stmt=con.createStatement();
				 query="delete from subjects where sub_id='" + subjects.getSub_id() +"'";
			       flag=stmt.executeUpdate(query);
			       
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		      finally{
				
				System.out.println("connection closed for delete subjects");
			}
		       if(flag!=0)return true;
		       else return false;		 

   }
	  
	  public ArrayList<Subjects> getallsubjects() throws SQLException{
		  ArrayList data=new ArrayList();
		  Subjects subjects=null;
		  ResultSet rs=null;
			try {
          query="select * from subjects order by sub_id;";
				rs = stmt.executeQuery(query);
				
				 while(rs.next()){
					subjects=new Subjects();
					subjects.setSub_id(rs.getInt("sub_id"));
					subjects.setSubjectname(rs.getString("subjectname"));
					data.add(subjects);
			        
				 	   }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("at subjects:" + e.getMessage());
		         e.printStackTrace();
			}
			finally{
				
				System.out.println("connection closed FOR LISTDATA");
			}
		   
		     return data;
             }
	  
	 
	  
	  
}

