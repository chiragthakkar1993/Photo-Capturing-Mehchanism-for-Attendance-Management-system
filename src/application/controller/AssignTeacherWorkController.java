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

public class AssignTeacherWorkController implements Initializable {
	@FXML
	private AnchorPane paneMain;

	@FXML
	private ComboBox comboTeacher;
	@FXML
	private ComboBox comboStd;
	@FXML
	private ComboBox comboSubject;

	@FXML
	private Button btnAssign;

	@FXML
	private Button btnClear;

	@FXML
	private Label lblEnrollId;

	private Stage stage;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println(paneMain);

		System.out.println(btnClear);
		System.out.println(btnAssign);
		System.out.println(comboStd);
		System.out.println(comboSubject);
		System.out.println(comboTeacher);

		System.out.println(lblEnrollId);
		ObservableList<String> standardOptions = FXCollections
				.observableArrayList("7th std", "8th std", "9th std"

				);
		ObservableList<String> subjectOptions = FXCollections
				.observableArrayList("Maths", "Science", "Hindi"

				);
		ObservableList<String> teacherOptions = FXCollections
				.observableArrayList("Chirag", "Jolly", "Aziz"

				);
		
		comboStd.getItems().setAll(standardOptions);
		comboSubject.getItems().setAll(subjectOptions);
		comboTeacher.getItems().setAll(teacherOptions);
		comboTeacher.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				

				if (t1.equals("Chirag")) {
					lblEnrollId.setText("12");
				} else if (t1.equals("Jolly")) {
					lblEnrollId.setText("13");
				} else if (t1.equals("Aziz")) {
					lblEnrollId.setText("14");
				}
			}
		});

		btnAssign.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							Dialogs.create()
									.owner(stage)
									.title("Assign Teacher")
									.message("Teacher Assigned Successfully...")
									.showInformation();

						}
					}
				});

	}
}
