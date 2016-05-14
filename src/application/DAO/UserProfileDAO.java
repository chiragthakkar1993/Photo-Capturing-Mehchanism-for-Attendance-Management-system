package application.DAO;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.text.StyledEditorKit.BoldAction;

import application.bean.UserProfile;
import application.Util.DBconnection;

public class UserProfileDAO {
	private Connection con = null;
	private Statement stmt = null;
	private int flag;
	private String query = null;
	String convert;

	public UserProfileDAO() {
		try {
			con = DBconnection.getConnection();
			stmt = con.createStatement();
			stmt.execute("SET SEARCH_PATH TO egov;");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList getteacher_name() throws SQLException {
		ArrayList data = new ArrayList();
		UserProfile userProfile = null;

		query = "select fname,mname,lname from employee;";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(query);

			while (rs.next()) {

				userProfile = new UserProfile();
				userProfile.setFname(rs.getString("fname"));
				userProfile.setMname(rs.getString("mname"));
				userProfile.setLname(rs.getString("lname"));
				data.add(userProfile);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("at userprofileDAO:" + e.getMessage());
			e.printStackTrace();
		} finally {
		}

		return data;
	}

	public ArrayList getidbyname(UserProfile userProfile) throws SQLException {

		ArrayList data = new ArrayList();
		UserProfile uProfile = null;

		query = "select enroll_id from employee where fname='"
				+ userProfile.getFname() + "' and mname='"
				+ userProfile.getMname() + "' and lname='"
				+ userProfile.getLname() + "';";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(query);

			while (rs.next()) {

				uProfile = new UserProfile();
				uProfile.setEnroll_id(rs.getInt("enroll_id"));
				data.add(uProfile);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("at userprofileDAO:" + e.getMessage());
			e.printStackTrace();
		} finally {
		}

		return data;
	}

	public int getIdByProfile(UserProfile userProfile) {

		int data = 0;
		UserProfile uProfile = null;

		query = "select enroll_id from employee where fname='"
				+ userProfile.getFname() + "' and mname='"
				+ userProfile.getMname() + "' and lname='"
				+ userProfile.getLname() + "';";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				uProfile = new UserProfile();
				data = rs.getInt("enroll_id");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("at userprofileDAO:" + e.getMessage());
			e.printStackTrace();
		} finally {
		}

		return data;
	}

	public boolean insert(UserProfile userProfile) throws Exception {
		try {

			stmt = con.createStatement();
			query = "insert into employee(fname, mname, lname, gender, dob, joindate, roleas,street, city, state, mobileno, email_id, password, isactive, imageurl)"
					+ "values('"
					+ userProfile.getFname()
					+ "','"
					+ userProfile.getMname()
					+ "','"
					+ userProfile.getLname()
					+ "','"
					+ userProfile.getGeneder()
					+ "','"
					+ userProfile.getDob()
					+ "','"
					+ userProfile.getJoindate()
					+ "','"
					+ userProfile.getRoleas()
					+ "','"
					+ userProfile.getStreet()
					+ "','"
					+ userProfile.getCity()
					+ "','"
					+ userProfile.getState()
					+ "','"
					+ userProfile.getMobileno()
					+ "','"
					+ userProfile.getEmail_id()
					+ "','"
					+ userProfile.getPassword()
					+ "','"
					+ userProfile.getIsactive()
					+ "','"
					+ userProfile.getImageurl() + "')";

			flag = stmt.executeUpdate(query);

			System.out.println("flag insert: " + flag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
		if (flag != 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean update(UserProfile userProfile) throws SQLException {

		int flag = 0;
		try {
			stmt = con.createStatement();
			query = "update employee set fname='" + userProfile.getFname()
					+ "',mname='" + userProfile.getMname() + "',lname='"
					+ userProfile.getLname() + "',street='"
					+ userProfile.getStreet() + "',city='"
					+ userProfile.getCity() + "',state='"
					+ userProfile.getState() + "',mobileno='"
					+ userProfile.getMobileno() + "',email_id='"
					+ userProfile.getEmail_id() + "',imageurl='"
					+ userProfile.getImageurl() + "' where enroll_id='"
					+ userProfile.getEnroll_id() + "'";
			flag = stmt.executeUpdate(query);
			System.out.println("flag in update" + flag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
		if (flag != 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean delete(UserProfile userProfile) throws SQLException {

		int flag = 0;

		try {
			stmt = con.createStatement();
			query = "delete from employee where enroll_id='"
					+ userProfile.getEnroll_id() + "'";
			flag = stmt.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
		}
		if (flag != 0)
			return true;
		else
			return false;

	}

	public ArrayList listdata()  {
		// TODO Auto-generated method stub
		ArrayList data = new ArrayList();
		UserProfile userProfile = null;

		query = "select enroll_id,fname, mname, lname, gender, dob, joindate, roleas,street, city, state, mobileno, email_id,isactive, imageurl from employee order by enroll_id;";

		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(query);

			while (rs.next()) {

				userProfile = new UserProfile();
				userProfile.setEnroll_id(rs.getInt("enroll_id"));
				userProfile.setFname(rs.getString("fname"));
				userProfile.setMname(rs.getString("mname"));
				userProfile.setLname(rs.getString("lname"));
				convert = rs.getString("gender");
				userProfile.setGeneder(convert.charAt(0));

				userProfile.setDob(rs.getDate("dob"));
				userProfile.setJoindate(rs.getDate("joindate"));
				userProfile.setRoleas(rs.getString("roleas"));
				userProfile.setStreet(rs.getString("street"));
				userProfile.setCity(rs.getString("city"));
				userProfile.setState(rs.getString("state"));
				userProfile.setMobileno(rs.getString("mobileno"));
				userProfile.setEmail_id(rs.getString("email_id"));
				userProfile.setIsactive(rs.getBoolean("isactive"));
				userProfile.setImageurl(rs.getBytes("imageurl"));
				

				
				
				data.add(userProfile);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("at userprofileDAO:" + e.getMessage());
			e.printStackTrace();
		} finally {
		}

		return data;
	}

	public UserProfile listbyid(int enrollid) throws SQLException {
		UserProfile userProfile = new UserProfile();
		userProfile.setEnroll_id(enrollid);
		query = "select enroll_id,fname, mname, lname, gender, dob, joindate, roleas,street, city, state, mobileno, email_id,isactive,imageurl from employee where enroll_id='"
				+ userProfile.getEnroll_id() + "';";

		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				userProfile.setEnroll_id(rs.getInt("enroll_id"));
				userProfile.setFname(rs.getString("fname"));
				userProfile.setMname(rs.getString("mname"));
				userProfile.setLname(rs.getString("lname"));
				convert = rs.getString("gender");
				userProfile.setGeneder(convert.charAt(0));

				userProfile.setDob(rs.getDate("dob"));
				userProfile.setJoindate(rs.getDate("joindate"));
				userProfile.setRoleas(rs.getString("roleas"));
				userProfile.setStreet(rs.getString("street"));
				userProfile.setCity(rs.getString("city"));
				userProfile.setState(rs.getString("state"));
				userProfile.setMobileno(rs.getString("mobileno"));
				userProfile.setEmail_id(rs.getString("email_id"));

				userProfile.setIsactive(rs.getBoolean("isactive"));
				userProfile.setImageurl(rs.getBytes("imageurl"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error in userprofile");
			e.printStackTrace();
		} finally {
		}
		return userProfile;
	}

}