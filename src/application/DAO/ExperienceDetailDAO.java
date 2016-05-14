package application.DAO;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.bean.*;
import application.Util.DBconnection;

public class ExperienceDetailDAO {

	private Connection con = null;
	private Statement stmt = null;
	private int flag;
	private String query = null;

	public ExperienceDetailDAO() {
		try {
			con = DBconnection.getConnection();
			stmt = con.createStatement();
			stmt.execute("SET SEARCH_PATH TO egov;");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean insert(ExperienceDetails eDetails) throws SQLException {
		try {
			stmt = con.createStatement();
			query = "insert into experiencedetails(enroll_id, organizationname, experienceyears)values('"
					+ eDetails.getEnroll_id()
					+ "','"
					+ eDetails.getOrganizationname()
					+ "','"
					+ eDetails.getExperienceyears() + "')";

			flag = stmt.executeUpdate(query);

			System.out.println("flag insert: " + flag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			System.out
					.println("connection closed after inserting into ExperienceDetails");
		}
		if (flag != 0)
			return true;
		else
			return false;
	}

	public boolean update(ExperienceDetails eDetails) throws SQLException {

		int flag = 0;
		try {
			stmt = con.createStatement();
			query = "update experiencedetails set organizationname='"
					+ eDetails.getOrganizationname() + "', experienceyears='"
					+ eDetails.getExperienceyears() + "' where exp_id='"
					+ eDetails.getExp_id() + "' and enroll_id='"
					+ eDetails.getEnroll_id() + "'";
			flag = stmt.executeUpdate(query);
			System.out.println("flag in update" + flag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			System.out
					.println("connection closed for update experiencedetails ");
		}
		if (flag != 0) {
			return true;
		} else {
			return false;
		}
	}

	public ArrayList listdatabyid(int enroll_id) throws SQLException {
		ExperienceDetails eDetails = null;
		ArrayList data = new ArrayList();
		ResultSet rs = null;
		try {
			query = "select * from educationdetails where enroll_id='"
					+ enroll_id + "' order by edu_id;";
			rs = stmt.executeQuery(query);

			while (rs.next()) {

				eDetails = new ExperienceDetails();
				eDetails.setExp_id(rs.getInt("exp_id"));
				eDetails.setEnroll_id(rs.getInt("enroll_id"));
				eDetails.setOrganizationname(rs.getString("organizationname"));
				eDetails.setExperienceyears(rs.getInt("experienceyears"));
				data.add(eDetails);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("at experiencedao:" + e.getMessage());
			e.printStackTrace();
		} finally {
			
			System.out.println("connection closed FOR LISTDATA");
		}

		return data;
	}

	public boolean delete(ExperienceDetails eDetails) throws SQLException {

		int flag = 0;

		try {
			stmt = con.createStatement();
			query = "delete from experiencedetails where ='"
					+ eDetails.getEnroll_id() + "'";
			flag = stmt.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			
			System.out
					.println("connection closed for delete experiencedetails");
		}
		if (flag != 0)
			return true;
		else
			return false;

	}

	public boolean deletebyexp_id(ExperienceDetails eDetails)
			throws SQLException {

		int flag = 0;

		try {
			stmt = con.createStatement();
			query = "delete from experiencedetails where ='"
					+ eDetails.getExp_id() + "'";
			flag = stmt.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			
			System.out
					.println("connection closed for delete experiencedetails");
		}
		if (flag != 0)
			return true;
		else
			return false;

	}

}
