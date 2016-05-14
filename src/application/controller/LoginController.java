package application.controller;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import org.controlsfx.dialog.Dialogs;

import application.RootWindow;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressBarBuilder;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class LoginController implements Initializable {
	@FXML
	private TextField txtUname;
	@FXML
	private PasswordField txtPwd;

	@FXML
	private Button btnLogin;
	@FXML
	private Button btnCancel;
	@FXML
	private Hyperlink recoverPwd;

	private Stage stage;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println(txtUname);

		System.out.println(txtPwd);

		System.out.println(btnLogin);

		System.out.println(btnCancel);

		System.out.println(recoverPwd);
		btnLogin.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						Node source = (Node) event.getSource();
						stage = (Stage) source.getScene().getWindow();
						String type = null;
						if (event.isPrimaryButtonDown()) {
							if (txtUname.getText().equals("admin")
									&& txtPwd.getText().equals("admin123")) {
								type = "admin";
							} else if (txtUname.getText().equals(
									"chirag.thakkar1993@gmail.com")
									&& txtPwd.getText().equals("chirag")) {
								type = "employee";
							} else {
								type = null;
							}
							if (type.equals("admin")) {
								stage.close();
								FXMLLoader loader = new FXMLLoader(
										RootWindow.class
												.getResource("applicationXML/Admin/AdminWindow.fxml"));
								// .getResource("applicationXML/Admin/AdminWindow.fxml"));
								// .getResource("applicationXML/Employee/EmployeeWindow.fxml"));
								AnchorPane rootpane;
								try {
									rootpane = (AnchorPane) loader.load();
									Scene scene = new Scene(rootpane);
									Stage stage = new Stage();
									stage.setScene(scene);
									stage.setResizable(false);
									// primaryStage.getIcons().add(new
									// Image("application/logo3.png"));
									stage.setTitle("Attendance Tracking System");
									stage.sizeToScene();
									stage.show();
									stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
										public void handle(WindowEvent we) {

											Platform.exit();
										}
									});

								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} else if (type.equals("employee")) {
								stage.close();
								FXMLLoader loader = new FXMLLoader(
										RootWindow.class
												.getResource("applicationXML/Employee/EmployeeWindow.fxml"));

								AnchorPane rootpane;
								try {
									rootpane = (AnchorPane) loader.load();
									Scene scene = new Scene(rootpane);
									Stage stage = new Stage();
									stage.setScene(scene);
									stage.setResizable(false);
									// primaryStage.getIcons().add(new
									// Image("application/logo3.png"));
									stage.setTitle("Attendance Tracking System");
									stage.sizeToScene();
									stage.show();
									stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
										public void handle(WindowEvent we) {

											Platform.exit();
										}
									});

								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} else {
								Dialogs.create()
										.owner(stage)
										.title("Login")
										.message(
												"You might have entered Wrong credentials for Login")
										.showError();
							}
						}
					}
				});

		btnCancel.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							Node source = (Node) event.getSource();
							stage = (Stage) source.getScene().getWindow();
							System.out.println("stage after = " + stage);
							stage.setOnHiding(new EventHandler<WindowEvent>() {
								public void handle(WindowEvent we) {
									ApplicationController
											.setLoginWindowToClose();
								}
							});
							stage.close();
						}
					}
				});
	}
}
