package application.bean;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Employee {
	private SimpleIntegerProperty enrollId;
	private SimpleStringProperty name;
	private SimpleStringProperty designation;

	public Employee(int enrollId, String name, String designation) {
		this.enrollId = new SimpleIntegerProperty(enrollId);
		this.name = new SimpleStringProperty(name);
		this.designation = new SimpleStringProperty(designation);
	}

	public int getEnrollId() {

		return enrollId.get();
	}

	public void setEnrollId(int enrollId) {
		this.enrollId.set(enrollId);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getDesignation() {
		return designation.get();
	}

	public void setDesignation(String designation) {
		this.designation.set(designation);
	}

}
