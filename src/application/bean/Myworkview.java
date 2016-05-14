package application.bean;
public class Myworkview {

	private Mywork mywork;
	private Standards standards;
	public Mywork getMywork() {
		return mywork;
	}
	public void setMywork(Mywork mywork) {
		this.mywork = mywork;
	}
	public Standards getStandards() {
		return standards;
	}
	public void setStandards(Standards standards) {
		this.standards = standards;
	}
	public Subjects getSubjects() {
		return subjects;
	}
	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}
	private Subjects subjects;
	
}
