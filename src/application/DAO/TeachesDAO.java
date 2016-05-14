package application.DAO;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.bean.*;
import application.Util.DBconnection;

public class TeachesDAO {

	 private Connection con=null;
	  private Statement stmt=null;
	  private int flag;
	  private String query=null;
	  
	  public TeachesDAO(){
		  try {
	        	con = DBconnection.getConnection();
	            stmt = con.createStatement();
				stmt.execute("SET SEARCH_PATH TO egov;");
				
					
				       
			   } catch (SQLException e) {
				// TODO Auto-generated catch block
			   e.printStackTrace();}
			  }
	  
	  public boolean insert(Myworkview myworkview) throws SQLException{
		  try {
	          stmt=con.createStatement();
		       query="insert into teaches(enroll_id, sub_id, stand_id)values('"+ myworkview.getMywork().getEnroll_id()
	         +"','"+myworkview.getSubjects().getSub_id()+"','"+myworkview.getStandards().getStand_id()+"')";
		       
		       flag=stmt.executeUpdate(query);
		       
	          System.out.println("flag insert: "+ flag);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				   e.printStackTrace(); }
		            finally{
			              
			                  System.out.println("connection closed after inserting into teaches"); 
			                }
		   if(flag!=0)
			   return true;     
		   else
		     return false;
	  }
	  
	  
	  
	  public boolean update(Myworkview myworkview,Myworkview oldMyworkview) throws SQLException{
		     
			int flag=0; 
			try {
				stmt=con.createStatement();
				 query="update teaches set enroll_id='"+ myworkview.getMywork().getEnroll_id() +
						 "', sub_id='" + myworkview.getSubjects().getSub_id()  +"',stand_id='"+myworkview.getStandards().getStand_id() 
			      + "' where enroll_id='"+ oldMyworkview.getMywork().getEnroll_id() +"' and sub_id='" + oldMyworkview.getSubjects().getSub_id() 
			      +"' and stand_id='"+ oldMyworkview.getStandards().getStand_id()+"';";
				 
		         flag=stmt.executeUpdate(query);
		       System.out.println("flag in update" + flag);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				
				System.out.println("connection closed for update teaches ");
			}
			  if(flag!=0){
		     	 return true;	 
		      }else{
		    	  return false;	  
		      }
	  
	 }
	  
	  public boolean delete(Myworkview myworkview) throws SQLException{
			
			int flag=0;

		       try {
				stmt=con.createStatement();
				 query="delete from teaches where enroll_id='"+myworkview.getMywork().getEnroll_id()+"'" +
				" and sub_id='" + myworkview.getSubjects().getSub_id() +"' and stand_id='"+myworkview.getStandards().getStand_id()+"'";
			       flag=stmt.executeUpdate(query);
			       
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		      finally{
				
				System.out.println("connection closed for delete assigned work");
			}
		       if(flag!=0)return true;
		       else return false;		 

 }
	  
	  public ArrayList get_assignedwork(int enroll_id) throws SQLException{
		  ArrayList data=new ArrayList();
		 Myworkview myworkview=null;
		  ResultSet rs=null;
			try {
          query="select standardname,subjectname from teaches join standards on teaches.stand_id=standards.stand_id join subjects  on teaches.sub_id=subjects.sub_id where enroll_id='"+enroll_id+"';";
          
				rs = stmt.executeQuery(query);
				
				 while(rs.next()){
					 myworkview=new Myworkview();
					 myworkview.setSubjects(new Subjects());
					 myworkview.setStandards(new Standards());
					myworkview.getStandards().setStandardname(rs.getString("standardname"));
					myworkview.getSubjects().setSubjectname(rs.getString("subjectname"));
			        data.add(myworkview);
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
