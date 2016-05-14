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

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

public class ViewAssignedWorkForAdminController implements Initializable {

	@FXML
	private TableView tableViewAssignWork;
	@FXML
	private TableColumn columnStd;
	@FXML
	private TableColumn columnSub;
	@FXML
	private Label lblEnrollId;
	@FXML
	private ComboBox comboTeacher;

	private Stage stage;
	ObservableList<Person> data = null;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println(tableViewAssignWork);
		System.out.println(columnStd);
		System.out.println(columnSub);
		System.out.println(lblEnrollId);
		System.out.println(comboTeacher);
		ObservableList<String> teacherOptions = FXCollections
				.observableArrayList("Chirag", "Jolly", "Aziz"

				);

		comboTeacher.getItems().setAll(teacherOptions);
		comboTeacher.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {

				if (t1.equals("Chirag")) {
					lblEnrollId.setText("12");
					data = FXCollections
							.observableArrayList(
									new Person("Maths", "7th", ""), new Person(
											"Hindi", "8th", ""));
					columnStd
							.setCellValueFactory(new PropertyValueFactory<Person, String>(
									"firstName"));

					columnSub
							.setCellValueFactory(new PropertyValueFactory<Person, String>(
									"lastName"));
					tableViewAssignWork.setItems(data);

				} else if (t1.equals("Jolly")) {
					lblEnrollId.setText("13");
					data = FXCollections.observableArrayList(new Person(
							"Science", "9th", ""), new Person("Hindi", "6th",
							""));
					columnStd
							.setCellValueFactory(new PropertyValueFactory<Person, String>(
									"firstName"));

					columnSub
							.setCellValueFactory(new PropertyValueFactory<Person, String>(
									"lastName"));
					tableViewAssignWork.setItems(data);

				} else if (t1.equals("Aziz")) {
					lblEnrollId.setText("14");
					data = FXCollections.observableArrayList(new Person(
							"Maths", "7th", ""), new Person("Science", "8th",
							""));
					columnStd
							.setCellValueFactory(new PropertyValueFactory<Person, String>(
									"firstName"));

					columnSub
							.setCellValueFactory(new PropertyValueFactory<Person, String>(
									"lastName"));
					tableViewAssignWork.setItems(data);

				}
			}
		});

		// tableSearchEmp.setEditable(true);
		// columnStd.setEditable(true);
		// columnDate.setCellFactory(TextFieldTableCell.forTableColumn());
		// columnDate
		// .setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
		// @Override
		// public void handle(CellEditEvent<Person, String> t) {
		// ((Person) t.getTableView().getItems()
		// .get(t.getTablePosition().getRow()))
		// .setFirstName(t.getNewValue());
		// }
		// });

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
	}
}
