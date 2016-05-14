package application.bean;
import java.sql.Blob;
import java.util.Date;

import javax.print.DocFlavor.BYTE_ARRAY;

public class UserProfile {
private int enroll_id;
private String fname=null;
private String mname=null;
private String lname=null;
private char geneder;
private Date dob;
private Date joindate;
private String roleas=null;
private String  street=null;
private String  city=null;
private String state=null;
private String mobileno=null;
private String email_id;
private String password;
private boolean isactive;
private byte[] imageurl;

public int getEnroll_id() {
	return enroll_id;
}
public void setEnroll_id(int enroll_id) {
	this.enroll_id = enroll_id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getMname() {
	return mname;
}
public void setMname(String mname) {
	this.mname = mname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public char getGeneder() {
	return geneder;
}
public void setGeneder(char geneder) {
	this.geneder = geneder;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public Date getJoindate() {
	return joindate;
}
public void setJoindate(Date joindate) {
	this.joindate = joindate;
}
public String getRoleas() {
	return roleas;
}
public void setRoleas(String roleas) {
	this.roleas = roleas;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getMobileno() {
	return mobileno;
}
public void setMobileno(String mobileno) {
	this.mobileno = mobileno;
}
public String getEmail_id() {
	return email_id;
}
public void setEmail_id(String email_id) {
	this.email_id = email_id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public  boolean getIsactive() {
	return isactive;
}
public void setIsactive(boolean isactive) {
	this.isactive = isactive;
}
public byte[] getImageurl() {
	return imageurl;
}
public void setImageurl(byte[] imageurl) {
	this.imageurl = imageurl;
}


}
