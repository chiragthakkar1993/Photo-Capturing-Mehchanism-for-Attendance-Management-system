package application.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import application.RootWindow;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class EditEmpProfileController implements Initializable {
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
	private TextField txtQualification;

	@FXML
	private Button btnUpload;

	@FXML
	private Button btnEdit1;
	@FXML
	private Button btnEdit2;
	@FXML
	private Button btnSave1;
	@FXML
	private Button btnSave2;
	@FXML
	private Button btnSave3;

	@FXML
	private ImageView imgPhoto;

	@FXML
	private RadioButton radioTrue;
	@FXML
	private RadioButton radioFalse;

	@FXML
	private TableView tableViewEducationalDetails;
	@FXML
	private TableColumn columnQualification;
	@FXML
	private TableColumn columnYearOfPassing;

	@FXML
	private TableView tableViewExperienceDetails;
	@FXML
	private TableColumn columnOrganization;
	@FXML
	private TableColumn columnExperience;

	private Stage stage;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println(paneEducationDetail);
		System.out.println(paneExperienceDetail);
		System.out.println(paneImage);
		System.out.println(paneMain);
		System.out.println(panePersonalDetail);
		System.out.println(tableViewEducationalDetails);
		System.out.println(tableViewExperienceDetails);
		System.out.println(columnExperience);
		System.out.println(columnOrganization);
		System.out.println(columnQualification);
		System.out.println(columnYearOfPassing);
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

		System.out.println(btnEdit1);
		System.out.println(btnEdit2);
		System.out.println(btnSave1);
		System.out.println(btnSave2);
		System.out.println(btnSave3);
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

	}
}
