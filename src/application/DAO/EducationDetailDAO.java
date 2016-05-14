package application.DAO;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.bean.*;
import application.Util.DBconnection;

public class EducationDetailDAO {

	 private Connection con=null;
	  private Statement stmt=null;
	  private int flag;
	  private String query=null;
	  
	  public EducationDetailDAO(){
		  try {
	        	con = DBconnection.getConnection();
	            stmt = con.createStatement();
				stmt.execute("SET SEARCH_PATH TO egov;");
				
					
				       
			   } catch (SQLException e) {
				// TODO Auto-generated catch block
			   e.printStackTrace();}
			  }
		  
		  public boolean insert(EducationDetails eDetails) throws SQLException{
			  try {
		          stmt=con.createStatement();
			       query="insert into educationdetails(enroll_id, edu_id, qualificationname, yearofpassing)values("+eDetails.getEnroll_id()+","+
		          eDetails.getEdu_id() +",'"+eDetails.getQualification()+"','"+eDetails.getYearofpassing()+"')";
			       
			       flag=stmt.executeUpdate(query);
			       
		          System.out.println("flag insert: "+ flag);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
					   e.printStackTrace(); }
			            finally{
				              
				                  System.out.println("connection closed after inserting into education"); 
				                }
			   if(flag!=0)
				   return true;     
			   else
			     return false;
		  }
		  
		  public boolean update(EducationDetails eDetails) throws SQLException{
			     
				int flag=0; 
				try {
					stmt=con.createStatement();
					 query="update educationdetails set enroll_id='"+ eDetails.getEnroll_id() +"',yearofpassing"+
				   eDetails.getYearofpassing()+"',qualificationname='"+
                   eDetails.getQualification()+"' where edu_id='"+  eDetails.getEdu_id()+"'";
			         flag=stmt.executeUpdate(query);
			       System.out.println("flag in update" + flag);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					
					System.out.println("connection closed for update education");
				}
				  if(flag!=0){
			     	 return true;	 
			      }else{
			    	  return false;	  
			      }
		}
		  
		  public ArrayList listdatabyid(int enroll_id) throws SQLException{
			  EducationDetails eDetails=null;
			  ArrayList data=new ArrayList();
			  ResultSet rs=null;
				try {
					 query="select * from educationdetails where enroll_id='"+ enroll_id+"'  order by edu_id;";
					rs = stmt.executeQuery(query);
					
					 while(rs.next()){
						 
				        eDetails=new EducationDetails();
					    eDetails.setEnroll_id(rs.getInt("enroll_id"));
					    eDetails.setEdu_id(rs.getInt("edu_id"));
					    eDetails.setQualification(rs.getString("qualificationname"));
					    eDetails.setYearofpassing(rs.getInt("yearofpassing"));
					    data.add(eDetails);
					 	   }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("at educationdao:" + e.getMessage());
			         e.printStackTrace();
				}
				finally{
					
					System.out.println("connection closed FOR LISTDATA");
				}
			   
			    	return data;
	             }
		  
		  public boolean delete(EducationDetails eDetails) throws SQLException{
				
				int flag=0;

			       try {
					stmt=con.createStatement();
					 query="delete from educationdetails where ='" + eDetails.getEnroll_id()+"'";
				       flag=stmt.executeUpdate(query);
				       
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			      finally{
					
					System.out.println("connection closed for delete education");
				}
			       if(flag!=0)return true;
			       else return false;		 

          }
		  public boolean deletebyedu_id(EducationDetails eDetails) throws SQLException{
				
					int flag=0;

				       try {
						stmt=con.createStatement();
						 query="delete from educationdetails where ='" + eDetails.getEdu_id()+"'";
					       flag=stmt.executeUpdate(query);
					       
							
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
				      finally{
						
						System.out.println("connection closed for delete education");
					}
				       if(flag!=0)return true;
				       else return false;		 

	            }
	
}
