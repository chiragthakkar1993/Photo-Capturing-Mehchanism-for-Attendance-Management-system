package application.bean;

import java.util.Date;

public class Mywork {

	 private int enroll_id;
	 private Subjects subjects;
	 private Standards standards;
   
	private String to_dolist;
 private Date  createdate;
 private Date workdate;
 
 
 public Subjects getSubjects() {
		return subjects;
	}
	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}
	public Standards getStandards() {
		return standards;
	}
	public void setStandards(Standards standards) {
		this.standards = standards;
	}
 public int getEnroll_id() {
		return enroll_id;
	}
	public void setEnroll_id(int enroll_id) {
		this.enroll_id = enroll_id;
	}
	
	
 public String getTo_dolist() {
	return to_dolist;
  }
public void setTo_dolist(String to_dolist) {
	this.to_dolist = to_dolist;
}
public Date getCreatedate() {
	return createdate;
}
public void setCreatedate(Date createdate) {
	this.createdate = createdate;
}
public Date getWorkdate() {
	return workdate;
}
public void setWorkdate(Date workdate) {
	this.workdate = workdate;
}
 
}
