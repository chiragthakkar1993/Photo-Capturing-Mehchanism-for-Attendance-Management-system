package application.DAO;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.bean.*;
import application.Util.DBconnection;

public class MyworkDAO {
	private Connection con=null;
	  private Statement stmt=null;
	  private int flag;
	  private String query=null;
	  
	  public  MyworkDAO() {
		// TODO Auto-generated constructor stub
		  try {
	        	con = DBconnection.getConnection();
	            stmt = con.createStatement();
				stmt.execute("SET SEARCH_PATH TO egov;");
				
					
				       
			   } catch (SQLException e) {
				// TODO Auto-generated catch block
			   e.printStackTrace();}
			  }
		  
	  
		  public boolean insert(Mywork mywork) throws SQLException{
			  try {
		          stmt=con.createStatement();
			       query="insert into mywork(enroll_id, todolist,workdate,sub_id,std_id,createddate)values('"+mywork.getEnroll_id()+"','"+
		           mywork.getTo_dolist()+"','"+ mywork.getWorkdate()+"','"+ mywork.getSubjects().getSub_id() +"','"+mywork.getStandards().getStand_id()+"','"+mywork.getCreatedate()+"')";
			       
			       flag=stmt.executeUpdate(query);
			       
		          System.out.println("flag insert: "+ flag);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
					   e.printStackTrace(); }
			            finally{
				              
				                  System.out.println("connection closed after inserting into mywork"); 
				                }
			   if(flag!=0)
				   return true;     
			   else
			     return false;
		  }
		  
		  public ArrayList employee_viewdata_forupdate(int enroll_id) throws SQLException{
			 
			  ArrayList data=new ArrayList();
			  Mywork mywork=null;
			
			  
			  ResultSet rs=null;
				try {
					 query="select workdate,standardname,subjectname,todolist from mywork join subjects on subjects.sub_id=mywork.sub_id join standards on standards.stand_id=mywork.std_id where " +
						 		"mywork.enroll_id='"+ enroll_id +"' and createddate=now()::date;";
					
					 rs = stmt.executeQuery(query);
					
					 while(rs.next()){
						  mywork=new Mywork();
					      mywork.setStandards(new Standards());
					      mywork.setSubjects(new Subjects());
					        
							mywork.setWorkdate(rs.getDate("workdate"));
							mywork.getStandards().setStandardname(rs.getString("standardname"));
							mywork.getSubjects().setSubjectname(rs.getString("subjectname"));
							mywork.setTo_dolist(rs.getString("todolist"));
							
					         data.add(mywork);
						
				        
				       
					 	   }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("at myworkdao:" + e.getMessage());
			         e.printStackTrace();
				}
				finally{
					
					System.out.println("connection closed FOR LISTDATA");
				}
			   return data;
			  
		  }
		 public boolean update(Myworkview myworkview) throws SQLException{
			     
				int flag=0; 
				try {
					stmt=con.createStatement();
					 query="update mywork set workdate='"+myworkview.getMywork().getWorkdate()+ "', todolist='" + myworkview.getMywork().getTo_dolist()+"' where enroll_id='"+myworkview.getMywork().getEnroll_id()+"' and createddate='"+ myworkview.getMywork().getCreatedate() 
                    + "' and sub_id='"+ myworkview.getSubjects().getSub_id() +"' and std_id='"+ myworkview.getStandards().getStand_id()+"'";
					 
			         flag=stmt.executeUpdate(query);
			       System.out.println("flag in update" + flag);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					
					System.out.println("connection closed for update mywork ");
				}
				  if(flag!=0){
			     	 return true;	 
			      }else{
			    	  return false;	  
			      }
		}
		  
		  public ArrayList listdatabyid(Mywork setmywork) throws SQLException{
			  Mywork mywork=null;
			 
			  ArrayList data=new ArrayList();
			  ResultSet rs=null;
				try {
	 query="select workdate,standardname,subjectname,todolist from mywork join subjects on subjects.sub_id=mywork.sub_id join standards on standards.stand_id=mywork.std_id where " +
	 		"mywork.enroll_id='"+ setmywork.getEnroll_id()  +"' and createddate='"+setmywork.getCreatedate() +"';";
					
					
					rs = stmt.executeQuery(query);
					
					 while(rs.next()){
						 
						
				        mywork=new Mywork();
				        mywork.setStandards(new Standards());
				        mywork.setSubjects(new Subjects());
				        
				        mywork.setWorkdate(rs.getDate("workdate"));
				        mywork.getStandards().setStandardname(rs.getString("standardname"));
						mywork.getSubjects().setSubjectname(rs.getString("subjectname"));
						mywork.setTo_dolist(rs.getString("todolist"));
						
				      
				       
					    data.add(mywork);
					 	   }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("at myworkdao:" + e.getMessage());
			         e.printStackTrace();
				}
				finally{
					
					System.out.println("connection closed FOR LISTDATA");
				}
			   
			    	return data;
	}
		  
		 
			   
		
		  public boolean delete(Mywork mywork) throws SQLException{
				
				int flag=0;

			       try {
					stmt=con.createStatement();
					 query="delete from mywork where enroll_id='" + mywork.getEnroll_id()+"' and createddate='"+mywork.getCreatedate() +"' and sub_id='"+ mywork.getSubjects().getSub_id() +"' and std_id='"+ mywork.getStandards().getStand_id()+"'";
				       flag=stmt.executeUpdate(query);
				       
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			      finally{
					
					System.out.println("connection closed for delete mywork");
				}
			       if(flag!=0)return true;
			       else return false;		 

       }
		 
	
}
