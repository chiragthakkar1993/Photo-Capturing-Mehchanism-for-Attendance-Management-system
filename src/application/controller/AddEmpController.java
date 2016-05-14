package application.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.controlsfx.dialog.Dialogs;

import application.RootWindow;
import application.DAO.EducationDetailDAO;
import application.DAO.ExperienceDetailDAO;
import application.DAO.UserProfileDAO;
import application.Util.Email;
import application.Util.RandomString;
import application.bean.EducationDetails;
import application.bean.ExperienceDetails;
import application.bean.UserProfile;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressBarBuilder;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class AddEmpController implements Initializable {
	@FXML
	private AnchorPane paneMain;
	@FXML
	private AnchorPane paneEducationDetail;
	@FXML
	private Pane paneImage;
	@FXML
	private TabPane tabpaneAddEmp;
	@FXML
	private Tab tabEducationalDetail;
	@FXML
	private Tab tabExperienceDetail;

	@FXML
	private Tab tabPersonalDetail;
	@FXML
	private AnchorPane panePersonalDetail;
	@FXML
	private AnchorPane paneExperienceDetail;
	@FXML
	private TextField txtFirstName;
	@FXML
	private TextField txtMidName;
	@FXML
	private TextField txtSurname;
	@FXML
	private DatePicker dateDOB;
	@FXML
	private RadioButton radioFemale;
	@FXML
	private RadioButton radioMale;
	@FXML
	private DatePicker dateJoinDate;

	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtEduId;
	@FXML
	private TextField txtExperienceId;
	@FXML
	private TextField txtOrganizationName;
	@FXML
	private TextField txtExperience;
	@FXML
	private TextField txtMobileNo;
	@FXML
	private TextArea txtStreet;
	@FXML
	private TextField txtYearOfPassing;
	@FXML
	private ComboBox comboState;
	@FXML
	private ComboBox comboCity;
	@FXML
	private ComboBox comboRole;

	@FXML
	private ToggleGroup gender;
	@FXML
	private ToggleGroup IsActive;
	@FXML
	private TextField txtQualification;

	@FXML
	private Button btnUpload;

	@FXML
	private Button btnCancel;
	@FXML
	private Button btnCancel2;
	@FXML
	private Button btnCancel3;
	@FXML
	private Button btnAdd;
	@FXML
	private Button btnAdd2;
	@FXML
	private Button btnAdd3;

	@FXML
	private ImageView imgPhoto;

	@FXML
	private RadioButton radioTrue;
	@FXML
	private RadioButton radioFalse;

	private Stage stage;
	byte[] thumbnail;
	UserProfile userProfileBean;
	EducationDetails educationDetailsBean;
	ExperienceDetails experienceDetailsBean;
	UserProfileDAO dao;
	EducationDetailDAO eduDao;
	ExperienceDetailDAO expDao;
	String enrollId;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("pwd = " + new RandomString(6).nextString());
		radioMale.setUserData("Male");
		radioFemale.setUserData("Female");
		radioFalse.setUserData("true");
		radioTrue.setUserData("false");
		ObservableList<String> stateOptions = FXCollections
				.observableArrayList("Gujarat", "Punjab", "Haryana"

				);
		comboState.getItems().setAll(stateOptions);
		comboState.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				comboCity.getSelectionModel().clearSelection();

				if (t1.equals("Gujarat")) {
					comboCity.getItems().setAll("Diyodar", "Vapi", "Radhanpur",
							"Bhabhar");
				} else if (t1.equals("Punjab")) {
					comboCity.getItems().setAll("Kubba", "Goslan", "Madpur",
							"Aliwal");
				} else if (t1.equals("Haryana")) {
					comboCity.getItems().setAll("Gahra", "jhagroli", "Kasan",
							"Palri");
				}
			}
		});
		comboRole.getItems().setAll("Teacher", "Clerk", "Assitant");
		userProfileBean = new UserProfile();
		dao = new UserProfileDAO();
		educationDetailsBean = new EducationDetails();
		experienceDetailsBean = new ExperienceDetails();
		eduDao = new EducationDetailDAO();
		expDao = new ExperienceDetailDAO();
		System.out.println(paneEducationDetail);
		System.out.println(paneExperienceDetail);
		System.out.println(paneImage);
		System.out.println(paneMain);
		System.out.println(panePersonalDetail);

		System.out.println(txtEduId);
		System.out.println(txtEmail);
		System.out.println(txtExperience);
		System.out.println(txtExperienceId);
		System.out.println(txtFirstName);
		System.out.println(txtMidName);
		System.out.println(txtMobileNo);
		System.out.println(txtOrganizationName);
		System.out.println(txtQualification);
		System.out.println(txtStreet);
		System.out.println(txtSurname);
		System.out.println(txtYearOfPassing);

		System.out.println(btnAdd);
		System.out.println(btnAdd2);
		System.out.println(btnAdd3);
		System.out.println(btnCancel);
		System.out.println(btnCancel2);
		System.out.println(btnCancel3);
		System.out.println(btnUpload);

		System.out.println(radioFalse);
		System.out.println(radioFemale);
		System.out.println(radioMale);
		System.out.println(radioTrue);

		System.out.println(comboCity);
		System.out.println(comboRole);
		System.out.println(comboState);

		System.out.println(imgPhoto);

		System.out.println(dateDOB);
		System.out.println(dateJoinDate);

		System.out.println(tabEducationalDetail);
		System.out.println(tabExperienceDetail);
		System.out.println(tabpaneAddEmp);
		System.out.println(tabPersonalDetail);

		btnUpload.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							System.out.println("upload image");
							FileChooser fileChooser = new FileChooser();
							fileChooser.setTitle("Upload Image");
							FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter(
									"JPG files (*.jpg)", "*.jpg");
							FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter(
									"PNG files (*.png)", "*.png");

							fileChooser.getExtensionFilters().addAll(
									extFilterJPG, extFilterPNG);
							Stage stage = (Stage) ((Button) event.getSource())
									.getScene().getWindow();
							File file = fileChooser.showOpenDialog(stage);

							thumbnail = new byte[(int) file.length()];
							try {
								// convert file into array of bytes

								BufferedImage bfimage = ImageIO.read(file);
								Image image = SwingFXUtils.toFXImage(bfimage,
										null);
								imgPhoto.setImage(image);
								imgPhoto.setFitWidth(153);
								imgPhoto.setFitHeight(167);
								imgPhoto.setPreserveRatio(true);
								imgPhoto.setSmooth(true);
								imgPhoto.setCache(true);
								FileInputStream fis = new FileInputStream(file);
								fis.read(thumbnail);
								fis.close();

								System.out.println("Done");
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				});
		btnAdd.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {

							userProfileBean.setImageurl(thumbnail);
							userProfileBean.setFname(txtFirstName.getText());
							userProfileBean.setMname(txtMidName.getText());
							userProfileBean.setLname(txtSurname.getText());
							SimpleDateFormat sdf = new SimpleDateFormat(
									"yyyy-MM-dd");

							try {
								userProfileBean.setDob(sdf.parse(dateDOB
										.getValue().toString()));
								userProfileBean.setJoindate(sdf
										.parse(dateJoinDate.getValue()
												.toString()));

							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							System.out.println("gender = "
									+ gender.getSelectedToggle().getUserData()
											.toString().charAt(0));
							userProfileBean.setGeneder(gender
									.getSelectedToggle().getUserData()
									.toString().charAt(0));
							userProfileBean.setEmail_id(txtEmail.getText());
							userProfileBean.setMobileno(txtMobileNo.getText());
							userProfileBean.setStreet(txtStreet.getText());
							userProfileBean.setState(comboState
									.getSelectionModel().getSelectedItem()
									.toString());
							System.out.println("ccity = " + comboCity);
							userProfileBean.setCity(comboCity
									.getSelectionModel().getSelectedItem()
									.toString());
							userProfileBean.setRoleas(comboRole
									.getSelectionModel().getSelectedItem()
									.toString());

							userProfileBean.setIsactive(Boolean.valueOf(gender
									.getSelectedToggle().getUserData()
									.toString()));
							String pwd = new RandomString(6).nextString();

							userProfileBean.setPassword(pwd);
							boolean result = false;
							try {
								result = dao.insert(userProfileBean);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (result) {
								String message = "You have been Registered Successfully in Attendance Tracking System Please Change Your Password at first login.<br><br><br>"
										+ "Username: "
										+ userProfileBean.getEmail_id()
										+ "<br>Password: "
										+ pwd;
										
										
								Email.sendMail(
										"attendancetrackingsys@gmail.com",
										"attendance", "Registration Details",
										message, new String[] { userProfileBean
												.getEmail_id() });
								Dialogs.create()
										.owner(stage)
										.title("Success")
										.message(
												"Enrollment is done Successfully...")
										.showInformation();
							} else {
								Dialogs.create()
										.owner(stage)
										.title("Success")
										.message(
												"Problem occured while Enrollment")
										.showError();
							}

						}
					}
				});

		btnAdd2.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							educationDetailsBean.setEnroll_id(dao
									.getIdByProfile(userProfileBean));
							educationDetailsBean.setEdu_id(Integer
									.valueOf(txtEduId.getText()));
							educationDetailsBean
									.setQualification(txtQualification
											.getText());
							educationDetailsBean.setYearofpassing(Integer
									.valueOf(txtYearOfPassing.getText()));
							boolean result = false;
							try {
								result = eduDao.insert(educationDetailsBean);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (result) {
								Dialogs.create()
										.owner(stage)
										.title("Success")
										.message(
												"Enrolled an employee Successfully...")
										.showInformation();
							} else {
								Dialogs.create()
										.owner(stage)
										.title("Success")
										.message(
												"Problem occured while saving data")
										.showError();
							}

						}
					}
				});
		btnAdd3.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {

							experienceDetailsBean.setEnroll_id(dao
									.getIdByProfile(userProfileBean));
							experienceDetailsBean.setExp_id(Integer
									.valueOf(txtExperienceId.getText()));
							experienceDetailsBean.setExperienceyears(Integer
									.valueOf(txtExperience.getText()));
							experienceDetailsBean.setOrganizationname(txtOrganizationName.getText());

							boolean result = false;
							try {
								result = expDao.insert(experienceDetailsBean);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (result) {
								Dialogs.create()
										.owner(stage)
										.title("Success")
										.message(
												"Enrolled an employee Successfully...")
										.showInformation();
							} else {
								Dialogs.create()
										.owner(stage)
										.title("Success")
										.message(
												"Problem occured while saving data")
										.showError();
							}

						}
					}
				});

	}
}
