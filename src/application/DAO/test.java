package application.DAO;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import application.bean.*;

public class test {
	
	public static void main(String arg[]) throws SQLException {
		//insert
		/*UserProfileDAO userProfileDAO=new UserProfileDAO();
		
		UserProfile userProfile=new UserProfile();
		userProfile.setEnroll_id(1009);
		userProfile.setFname("fname");
		userProfile.setMname("mname");
		userProfile.setLname("lname");
		userProfile.setGeneder('m');
		userProfile.setDob(new Date("5/4/1990"));
		userProfile.setJoindate(new Date("5/4/1990"));
		userProfile.setRoleas("teacher");
		userProfile.setStreet("street");
		userProfile.setCity("jdj");
		userProfile.setState("satet");
		userProfile.setMobileno("666666");
		userProfile.setEmail_id("test@gmail.com");
		userProfile.setIsactive(true);
		userProfile.setImageurl("image.png");
         
         try {
			Boolean flag= userProfileDAO.insert(userProfile);
			if(flag){
		  System.out.println("inserted succesfully");	
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         //delete
        userProfile.setEnroll_id(1001);
       Boolean flag=userProfileDAO.delete(userProfile);
       if(flag)System.out.println("delete successfully");
       else System.out.println("error in delete");
       
       //update
       userProfile.setEnroll_id(1001);
     
		userProfile.setStreet("street");
		userProfile.setCity("jdj");
		userProfile.setState("satet");
		userProfile.setMobileno("666666");
		userProfile.setEmail_id("test@gmail.com");
	
		userProfile.setImageurl("image.png");
		Boolean status=userProfileDAO.update(userProfile);
		 if(status)System.out.println("update successfully");
	       else System.out.println("error in update");
	}
	
	public void attendanceadmin(){
		
	}*/

	//addsubjects();	
	//addstabdards();
	//manageuserprofile();
//	manageteaches();
	
	//	managemywork();
	
		manageattendance();
		
}

	 public static void manageattendance(){
		 boolean flag=true;
		 
	 }
	public static void managemywork() throws SQLException{
		boolean flag=true;
		Mywork mywork=new Mywork();
		MyworkDAO myworkDAO=null;
		myworkDAO=new MyworkDAO();
		mywork.setEnroll_id(1009);
		mywork.setStandards(new Standards());
		mywork.getStandards().setStand_id(4002);
		mywork.setSubjects(new Subjects());
		mywork.getSubjects().setSub_id(3003);
		
		mywork.setCreatedate(new Date("11/15/2014"));
		mywork.setTo_dolist("work on chapter 7 ");
		mywork.setWorkdate(new Date("6/7/2014"));
		
		//list data by today date by enrollid 
		
/*	ArrayList<Mywork> data=myworkDAO.employee_viewdata_forupdate(mywork.getEnroll_id());
		
		for(int index=0;index < data.size() ; index++){
		 System.out.println("" + data.get(index).getWorkdate()+""+data.get(index).getStandards().getStandardname()+" "+data.get(index).getSubjects().getSubjectname()+""+data.get(index).getTo_dolist());	
		}
	*/
		
		//listbyid 
		/*Mywork setmywork=new Mywork();
		setmywork.setEnroll_id(1009);
		setmywork.setCreatedate(new Date("8/9/2014"));
		ArrayList<Mywork> data=myworkDAO.listdatabyid(setmywork);
		
		for(int index=0;index < data.size() ;index++){
			System.out.println("  " + data.get(index).getWorkdate()+"  "+data.get(index).getStandards().getStandardname()+"  "+data.get(index).getSubjects().getSubjectname()+"  "+data.get(index).getTo_dolist());
		}  /*
		
		// code for update by employee side 
	/*	Myworkview myworkview=new Myworkview();
		myworkview.setMywork(new Mywork());
		myworkview.setStandards(new Standards());
		myworkview.setSubjects(new Subjects());
		myworkview.getMywork().setEnroll_id(1009);
		myworkview.getStandards().setStand_id(4002);
		myworkview.getSubjects().setSub_id(3003);
		myworkview.getMywork().setTo_dolist("updated chapter 7");
		myworkview.getMywork().setWorkdate(new Date("8/9/2014"));
		myworkview.getMywork().setCreatedate(new Date("11/15/2014"));
		*/
//		flag=myworkDAO.update(myworkview);
	
		
		// insert for
		
	//  flag=myworkDAO.insert(mywork);
		
		   // delete 
		Mywork setmywork=new Mywork();
		setmywork.setCreatedate(new Date("8/9/2014"));
		setmywork.setStandards(new Standards());
		setmywork.setSubjects(new Subjects());
		setmywork.getStandards().setStand_id(4002);
		setmywork.getSubjects().setSub_id(3003);
		flag=myworkDAO.delete(setmywork);
		
	   if(flag) System.out.println("inserted");
	   else System.out.println("not inserted");
	   

	   
	   
	   
	   
	}
	public static void manageteaches() throws SQLException{
	boolean	flag=true;
		Myworkview myworkview=new Myworkview();
		myworkview.setMywork(new Mywork());
		myworkview.setStandards(new Standards());
		myworkview.setSubjects(new Subjects());
		myworkview.getMywork().setEnroll_id(1009);
		myworkview.getStandards().setStand_id(4005);
		myworkview.getSubjects().setSub_id(3001);
		
		TeachesDAO dao=new TeachesDAO();
		//flag=dao.insert(myworkview);
		//flag=dao.delete(myworkview);
		
	/*	Myworkview oldMyworkview=new Myworkview();
		oldMyworkview.setMywork(new Mywork());
		oldMyworkview.setStandards(new Standards());
        oldMyworkview.setSubjects(new Subjects());
		oldMyworkview.getMywork().setEnroll_id(1009);
		oldMyworkview.getStandards().setStand_id(4004);
		oldMyworkview.getSubjects().setSub_id(3003);
		
		//flag=dao.update(myworkview, oldMyworkview);*/
		
		ArrayList<Myworkview>data=dao.get_assignedwork(1009);
		for(int index=0;index < data.size() ; index++){
			
System.out.println("standard: " + data.get(index).getStandards().getStandardname() +" subject:"+ data.get(index).getSubjects().getSubjectname());

		}
	    if(flag) System.out.println("inserted");
	    else System.out.println("not inserted");
	    
	}
	public static void manageuserprofile() throws SQLException{
		boolean flag;
		UserProfile uProfile=new UserProfile();
		UserProfileDAO userProfileDAO=new UserProfileDAO();
		uProfile=userProfileDAO.listbyid(1001);
		System.out.println("id:" + uProfile.getEnroll_id());
	    System.out.println("name"+uProfile.getFname());
	    System.out.println(uProfile.getMname());
	    System.out.println(uProfile.getLname());
	    System.out.println(uProfile.getGeneder());
	    System.out.println(uProfile.getDob());
	    System.out.println(uProfile.getJoindate());
        System.out.println(uProfile.getRoleas());
        System.out.println(	uProfile.getStreet());
        System.out.println(uProfile.getCity());
        System.out.println(uProfile.getState());
        System.out.println(uProfile.getMobileno());
        System.out.println(uProfile.getEmail_id());
	System.out.println(uProfile.getIsactive());
	System.out.println(uProfile.getImageurl());
	
	UserProfileDAO uDao=new UserProfileDAO();
	//uProfile.setEmail_id("ripalg1993@gmail.com");
	uProfile.setEnroll_id(5);
//	flag=uDao.update(uProfile);
	flag=uDao.delete(uProfile);
	if(flag)System.out.println("updated");
	else System.out.println("not updated");
	
	//list data
	/*UserProfileDAO uDao=new UserProfileDAO();
	ArrayList<UserProfile> data=uDao.listdata();
	for(int index=0;index <data.size();index++){
		
	
	System.out.println("\nid:" + data.get(index).getEnroll_id());
    System.out.println("name"+data.get(index).getFname());
    System.out.println(data.get(index).getMname());
    System.out.println(data.get(index).getLname());
    System.out.println(data.get(index).getGeneder());
    System.out.println(data.get(index).getDob());
    System.out.println(data.get(index).getJoindate());
    System.out.println(data.get(index).getRoleas());
    System.out.println(data.get(index).getStreet());
    System.out.println(data.get(index).getCity());
    System.out.println(data.get(index).getState());
    System.out.println(data.get(index).getMobileno());
    System.out.println(data.get(index).getEmail_id());
System.out.println(data.get(index).getIsactive());
System.out.println(data.get(index).getImageurl());
	}*/
	}
	public static void addstabdards() throws SQLException
	{
		boolean flag;
		StandardDAO standardDAO=new StandardDAO();
        Standards standards=new Standards();
		
        standards.setStandardname("std-6");
        standards.setStand_id(4003);
        flag=standardDAO.update(standards);
        //flag=standardDAO.delete(standards);
        //boolean flag=standardDAO.insert(standards);
        if(flag) System.out.println("inserted");
        else System.out.println("not inserted");
		/*  list standards print 
		 ArrayList<Standards>data=standardDAO.getallstandards();
		  for(int index=0;index < data.size();index++){
			 System.out.println("id: "+data.get(index).getStand_id()+" name: "+ data.get(index).getStandardname());
			 
			 } */		  
	}
	public static void addsubjects() throws SQLException{
		boolean flag=true;
		Subjects subjects=new Subjects();
		//subjects.setSubjectname("p.t");
		SubjectDAO subjectDAO=new SubjectDAO();
		
		subjects.setSub_id(1);
		subjects.setSubjectname("science");
		
		//flag=subjectDAO.insert(subjects);
		//flag=subjectDAO.delete(subjects);
		
		 //flag=subjectDAO.update(subjects);
		
		Standards standards=new Standards();
		
		ArrayList<Subjects>data=subjectDAO.getallsubjects();
		  for(int index=0;index < data.size();index++){
			 System.out.println(data.get(index).getSub_id()+"name:"+ data.get(index).getSubjectname());
			 
			 }
		 
		if(flag)
			System.out.println("insert sucessfully");
		else System.out.println("not inserted");
	}
	
}