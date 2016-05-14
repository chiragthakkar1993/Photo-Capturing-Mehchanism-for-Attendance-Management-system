package application.bean;

public class EducationDetails {
 private int enroll_id;
 private int edu_id;	
private String qualification=null;
 private int yearofpassing;

 public int getEnroll_id() {
		return enroll_id;
	}
 public void setEnroll_id(int enroll_id) {
		this.enroll_id = enroll_id;
	}
public int getEdu_id() {
	return edu_id;
}
public void setEdu_id(int edu_id) {
	this.edu_id = edu_id;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public int getYearofpassing() {
	return yearofpassing;
}
public void setYearofpassing(int yearofpassing) {
	this.yearofpassing = yearofpassing;
}
}
