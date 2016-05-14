package application.DAO;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.omg.CORBA.PUBLIC_MEMBER;

import application.bean.*;
import application.Util.DBconnection;

public class AttendanceDAO {
	 private Connection con=null;
	  private Statement stmt=null;
	  private int flag;
	  private String query=null;
	  
	  public AttendanceDAO(){
		  try {
	        	con = DBconnection.getConnection();
	            stmt = con.createStatement();
				stmt.execute("SET SEARCH_PATH TO egov;");
				
					
				       
			   } catch (SQLException e) {
				// TODO Auto-generated catch block
			   e.printStackTrace();}
			  }
		  
		  public boolean insert(Attendance attendance,int enroll_id) throws SQLException{
			  try {
		          stmt=con.createStatement();
			       query="insert into attendance() values('"+enroll_id+"','"+attendance.getCreatedate()+"','0','"+attendance.getIntime()
			        +"','"+attendance.getOuttime()+"')";
			       
			       flag=stmt.executeUpdate(query);
			       
		          System.out.println("flag insert: "+ flag);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
					   e.printStackTrace(); }
			            finally{
				              con.close();
				                  System.out.println("connection closed after inserting into attendance "); 
				                }
			   if(flag!=0)
				   return true;     
			   else
			     return false;
		  }
		  
		  public boolean update(Attendance attendance) throws SQLException{
			     
				int flag=0; 
				try {
					stmt=con.createStatement();
					 query="update attendance set status='1',outtime='"+ attendance.getOuttime()+"', comments='"+
					   attendance.getComments()+"' where createdate='"+ attendance.getCreatedate()+"'";
			         flag=stmt.executeUpdate(query);
			       System.out.println("flag in update" + flag);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					con.close();
					System.out.println("connection closed for update attendance");
				}
				  if(flag!=0){
			     	 return true;	 
			      }else{
			    	  return false;	  
			      }
		}
		  
		  public boolean delete(Attendance attendance) throws SQLException{
				
					int flag=0;

				       try {
						stmt=con.createStatement();
						 query="delete from attendance where createdate='" + attendance.getCreatedate() +"'";
					       flag=stmt.executeUpdate(query);
					       
							
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
				      finally{
						con.close();
						System.out.println("connection closed for delete attendance");
					}
				       if(flag!=0)return true;
				       else return false;		 

	            }
		  
		  public ArrayList admin_listdata(Attendance attendance,int month) throws SQLException {
				// TODO Auto-generated method stub
				ArrayList data=new ArrayList();
				Attendance viewattendance=null;
			
			// id and  by month  
			  
				  query="select * from attendance where enroll_id='"+attendance.getEnroll_id()+"' and " +
				  		"extract(month from createdate)='"+month+"' order by createdate desc;";
			 
			// count by month 
	//select count(enroll_id) from attendance where extract(month from createdate)='11' 
				  //and enroll_id='1001' and status='1' group by enroll_id;
			 
			    ResultSet rs=null;
				try {
					rs = stmt.executeQuery(query);
					
					 while(rs.next()){
						 
					    viewattendance=new Attendance();
					    viewattendance.setEnroll_id(rs.getInt("enroll_id"));
					    viewattendance.setCreatedate(rs.getDate("createdate"));
					    viewattendance.setStatus(rs.getInt("status"));
					    viewattendance.setIntime(rs.getDate("intime"));
					    viewattendance.setOuttime(rs.getDate("outtime"));
					    viewattendance.setComments(rs.getString("comments"));
					    data.add(viewattendance);
					 	   }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("at attendanceDAO:" + e.getMessage());
			         e.printStackTrace();
				}
				finally{
					con.close();
					System.out.println("connection closed FOR LISTDATA");
				}
			   
			    	return data;
	             }
		  
		  public ArrayList employee_listdata(int enroll_id) throws SQLException {
				// TODO Auto-generated method stub
				ArrayList data=new ArrayList();
				Attendance attendance=null;
				
				query="select * from attendance where enoll_id='"+enroll_id+"' order by createdate desc;";
			    
			    ResultSet rs=null;
				try {
					rs = stmt.executeQuery(query);
					
					 while(rs.next()){
						 
					    attendance=new Attendance();
					   attendance.setEnroll_id(rs.getInt("enroll_id"));
					    attendance.setCreatedate(rs.getDate("createdate"));
					    attendance.setStatus(rs.getInt("status"));
					    attendance.setIntime(rs.getDate("intime"));
					    attendance.setOuttime(rs.getDate("outtime"));
					    attendance.setComments(rs.getString("comments"));
					    data.add(attendance);
					 	   }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("at attendanceDAO:" + e.getMessage());
			         e.printStackTrace();
				}
				finally{
					con.close();
					System.out.println("connection closed FOR LISTDATA");
				}
			   
			    	return data;
	             }
}
