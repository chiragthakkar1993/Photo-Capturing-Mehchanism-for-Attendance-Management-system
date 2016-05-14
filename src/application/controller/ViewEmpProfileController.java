package application.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.controlsfx.dialog.Dialogs;

import application.RootWindow;
import application.bean.Person;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ViewEmpProfileController implements Initializable {
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
	private TextField txtEduId;
	@FXML
	private TextField txtExperienceId;
	@FXML
	private TextField txtOrganizationName;
	@FXML
	private TextField txtExperience;
	@FXML
	private TextField txtYearOfPassing;

	@FXML
	private TextField txtQualification;

	@FXML
	private Button btnView1;
	@FXML
	private Button btnView2;

	@FXML
	private ImageView imgPhoto;

	@FXML
	private Label lblFirstName;
	@FXML
	private Label lblMiddleName;
	@FXML
	private Label lblSurname;
	@FXML
	private Label lblDOB;
	@FXML
	private Label lblGender;
	@FXML
	private Label lblJoinDate;
	@FXML
	private Label lblEmailId;
	@FXML
	private Label lblMobile;
	@FXML
	private TextArea txtAddress;
	@FXML
	private Label lblState;
	@FXML
	private Label lblCity;
	@FXML
	private Label lblRole;
	@FXML
	private Label lblStatus;
	/*******************/

	@FXML
	private AnchorPane paneViewEmp;
	@FXML
	private TableView tableViewEducationalDetails;
	@FXML
	private TableView tableViewExperienceDetails;
	@FXML
	private TableColumn columnEduId;
	@FXML
	private TableColumn columnQualification;

	@FXML
	private TableColumn columnExperienceId;
	@FXML
	private TableColumn columnOrganization;

	private Stage stage;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(btnView1);
		System.out.println(btnView2);
		System.out.println(paneViewEmp);
		System.out.println(tableViewEducationalDetails);
		System.out.println(tableViewExperienceDetails);

		System.out.println(columnEduId);
		System.out.println(columnExperienceId);
		System.out.println(columnOrganization);
		System.out.println(columnQualification);
		System.out.println(paneEducationDetail);
		System.out.println(paneExperienceDetail);
		System.out.println(paneImage);
		System.out.println(paneMain);
		System.out.println(panePersonalDetail);

		System.out.println(txtEduId);
		System.out.println(txtExperience);
		System.out.println(txtExperienceId);
		System.out.println(txtOrganizationName);
		System.out.println(txtQualification);
		System.out.println(txtYearOfPassing);

		System.out.println(lblCity);
		System.out.println(lblDOB);
		System.out.println(lblEmailId);
		System.out.println(lblFirstName);
		System.out.println(lblGender);
		System.out.println(lblJoinDate);
		System.out.println(lblMiddleName);
		System.out.println(lblMobile);
		System.out.println(lblRole);
		System.out.println(lblState);
		System.out.println(lblStatus);
		System.out.println(lblSurname);

		System.out.println(imgPhoto);

		System.out.println(tabEducationalDetail);
		System.out.println(tabExperienceDetail);
		System.out.println(tabpaneAddEmp);
		System.out.println(tabPersonalDetail);

		tableViewEducationalDetails.setEditable(true);
		tableViewExperienceDetails.setEditable(true);
		final ObservableList<Person> data = FXCollections.observableArrayList(
				new Person("Chirag", "Aziz", "Chirag.Aziz@example.com"),
				new Person("Chirag", "Aziz", "Chirag.Aziz@example.com"),
				new Person("Chirag", "Aziz", "Chirag.Aziz@example.com"),
				new Person("Chirag", "Aziz", "Chirag.Aziz@example.com"),
				new Person("Chirag", "Aziz", "Chirag.Aziz@example.com"),
				new Person("Chirag", "Aziz", "Chirag.Aziz@example.com"),
				new Person("Chirag", "Aziz", "Chirag.Aziz@example.com"),
				new Person("Chirag", "Aziz", "Chirag.Aziz@example.com"),
				new Person("Chirag", "Aziz", "Chirag.Aziz@example.com"),
				new Person("Chirag", "Aziz", "Chirag.Aziz@example.com"),
				new Person("Chirag", "Aziz", "Chirag.Aziz@example.com"),
				new Person("Chirag", "Aziz", "Chirag.Aziz@example.com"));
		columnEduId.setEditable(true);
		columnEduId
				.setCellValueFactory(new PropertyValueFactory<Person, String>(
						"firstName"));

		columnExperienceId
				.setCellValueFactory(new PropertyValueFactory<Person, String>(
						"lastName"));

		columnOrganization
				.setCellValueFactory(new PropertyValueFactory<Person, String>(
						"firstName"));

		columnQualification
				.setCellValueFactory(new PropertyValueFactory<Person, String>(
						"lastName"));
		// columnName.setCellFactory(TextFieldTableCell.forTableColumn());
		// columnName
		// .setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
		// @Override
		// public void handle(CellEditEvent<Person, String> t) {
		// ((Person) t.getTableView().getItems()
		// .get(t.getTablePosition().getRow()))
		// .setFirstName(t.getNewValue());
		// }
		// });
		tableViewEducationalDetails.setItems(data);
		tableViewExperienceDetails.setItems(data);
		btnView1.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							Person person = (Person) tableViewEducationalDetails
									.getSelectionModel().getSelectedItem();

							System.out.println();
							Dialogs.create()
									.owner(stage)
									.title("Login")
									.message(
											person.getFirstName() + " = "
													+ person.getLastName()
													+ " = " + " "
													+ person.getEmail())
									.showInformation();

						}
					}
				});
		btnView2.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							Person person = (Person) tableViewExperienceDetails
									.getSelectionModel().getSelectedItem();

							System.out.println();
							Dialogs.create()
									.owner(stage)
									.title("")
									.message(
											person.getFirstName() + " = "
													+ person.getLastName()
													+ " = " + " "
													+ person.getEmail())
									.showInformation();

						}
					}
				});
	}
}
