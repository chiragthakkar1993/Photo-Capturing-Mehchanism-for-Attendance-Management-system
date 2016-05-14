package application.bean;

import java.util.Date;

public class Attendance {

	private int enroll_id;
	
	private Date createdate;
	private int status;
	private Date intime;
	private Date outtime;
	private String comments;
	
	public int getEnroll_id() {
		return enroll_id;
	}
	public void setEnroll_id(int enroll_id) {
		this.enroll_id = enroll_id;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getIntime() {
		return intime;
	}
	public void setIntime(Date intime) {
		this.intime = intime;
	}
	public Date getOuttime() {
		return outtime;
	}
	public void setOuttime(Date outtime) {
		this.outtime = outtime;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}
