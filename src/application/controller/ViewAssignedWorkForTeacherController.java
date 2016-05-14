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

public class ViewAssignedWorkForTeacherController implements Initializable {

	@FXML
	private TableView tableViewAssignWork;
	@FXML
	private TableColumn columnStd;
	@FXML
	private TableColumn columnSub;

	private Stage stage;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(tableViewAssignWork);
		System.out.println(columnStd);
		System.out.println(columnSub);

		// tableSearchEmp.setEditable(true);
		ObservableList<Person> data = FXCollections.observableArrayList(
				new Person("Maths", "7th", ""), new Person("Hindi", "8th", ""));
		columnStd.setCellValueFactory(new PropertyValueFactory<Person, String>(
				"firstName"));

		columnSub.setCellValueFactory(new PropertyValueFactory<Person, String>(
				"lastName"));
		tableViewAssignWork.setItems(data);
		columnStd.setEditable(true);
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
		tableViewAssignWork.setItems(data);
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
