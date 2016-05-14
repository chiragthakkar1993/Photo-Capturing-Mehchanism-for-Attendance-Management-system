package application.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.controlsfx.dialog.Dialogs;

import com.github.sarxos.webcam.WebcamPanel;

import application.RootWindow;
import application.DAO.UserProfileDAO;
import application.bean.Employee;
import application.bean.Person;
import application.bean.UserProfile;
import application.bean.WebCamBean;

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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class ViewAllEmpProfileController implements Initializable {

	@FXML
	private TableView tableViewEmp;
	@FXML
	private TableColumn columnEnrollId;
	@FXML
	private TableColumn columnName;
	@FXML
	private TableColumn columnDesignation;

	@FXML
	private Button btnView;
	@FXML
	private Button btnDelete;
	@FXML
	private Button btnCancel;

	private Stage stage;
	UserProfileDAO dao;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(tableViewEmp);
		System.out.println(columnDesignation);
		System.out.println(columnEnrollId);
		System.out.println(columnName);
		System.out.println(btnView);
		System.out.println(btnDelete);
		System.out.println(btnCancel);
		dao = new UserProfileDAO();
		ArrayList list = dao.listdata();
		// tableWorkDetails.setEditable(true);
		final ObservableList<Employee> data = FXCollections
				.observableArrayList();
		for (Object profile : list) {
			UserProfile profile2 = (UserProfile) profile;
			Employee e = new Employee(profile2.getEnroll_id(),
					profile2.getFname(), profile2.getRoleas());
			data.add(e);
		}
		columnEnrollId
				.setCellValueFactory(new PropertyValueFactory<Employee, String>(
						"enrollId"));

		columnName
				.setCellValueFactory(new PropertyValueFactory<Employee, String>(
						"name"));
		columnDesignation
				.setCellValueFactory(new PropertyValueFactory<Employee, String>(
						"designation"));

		// columnCreatedDate.setEditable(true);
		// columnCreatedDate.setCellFactory(TextFieldTableCell.forTableColumn());
		// columnCreatedDate
		// .setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
		// @Override
		// public void handle(CellEditEvent<Person, String> t) {
		// ((Person) t.getTableView().getItems()
		// .get(t.getTablePosition().getRow()))
		// .setFirstName(t.getNewValue());
		// }
		// });
		tableViewEmp.setItems(data);
		// btnView.addEventHandler(MouseEvent.MOUSE_PRESSED,
		// new EventHandler<MouseEvent>() {
		//
		// @Override
		// public void handle(MouseEvent event) {
		// if (event.isPrimaryButtonDown()) {
		// Person person = (Person) tableViewEmp
		// .getSelectionModel().getSelectedItem();
		//
		// System.out.println();
		// Dialogs.create()
		// .owner(stage)
		// .title("Login")
		// .message(
		// person.getFirstName() + " = "
		// + person.getLastName()
		// + " = " + " "
		// + person.getEmail())
		// .showInformation();
		//
		// }
		// }
		// });
		btnView.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {
			
					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
			
							FXMLLoader loader = new FXMLLoader(
									EmployeeWindowController.class
											.getResource("/application/applicationXML/Admin/Manage EmployeeProfile/Admin-ViewEmployeeProfile.fxml"));
							AnchorPane rootpane = null;
							try {
								rootpane = (AnchorPane) loader.load();
							} catch (IOException ex) {
								Logger.getLogger(
										AdminWindowController.class.getName())
										.log(Level.SEVERE, null, ex);
							}
							Scene scene = new Scene(rootpane);

							// Stage stage = (Stage) ((Label) event.getSource())
							// .getScene().getWindow();
							// stage.close();
							// scene.getStylesheets().add(
							// getClass().getClassLoader()
							// .getResource("application/css/background.css")
							// .toExternalForm());
							// scene.getStylesheets().add(
							// getClass().getClassLoader()
							// .getResource("application/css/library.css")
							// .toExternalForm());
							Stage stage = new Stage();
							stage.setScene(scene);
							stage.initModality(Modality.WINDOW_MODAL);
							stage.initStyle(StageStyle.UTILITY);
							stage.initOwner(((Node) event.getSource())
									.getScene().getWindow());
							stage.setResizable(false);
							// stage.getIcons().add(
							// new Image("application/images/logo3.png"));
							stage.setTitle("View Profile ");
							stage.sizeToScene();
							stage.show();

						}
					}
				});

	}

}
