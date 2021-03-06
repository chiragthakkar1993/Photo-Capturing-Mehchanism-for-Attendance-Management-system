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

public class AddWorkForEmployeeController implements Initializable {

	@FXML
	private Button btnCancel;
	@FXML
	private Button btnAddWork;

	@FXML
	private Label lblDate;
	@FXML
	private ComboBox comboStd;
	@FXML
	private ComboBox comboSubject;
	@FXML
	private TextArea txtToDo;
	@FXML
	private DatePicker dateWorkDate;

	private Stage stage;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println(lblDate);

		System.out.println(btnAddWork);
		System.out.println(btnCancel);
		System.out.println(txtToDo);
		System.out.println(dateWorkDate);
		System.out.println(comboStd);
		System.out.println(comboSubject);
		btnAddWork.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							Dialogs.create().owner(stage).title("Add Work")
									.message("Work Added Successfully")
									.showInformation();

						}
					}
				});

	}
}
