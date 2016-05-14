package application.controller;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.github.sarxos.webcam.WebcamPanel;

import application.bean.WebCamBean;

import application.RootWindow;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressBarBuilder;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class ApplicationController implements Initializable {
	@FXML
	private ImageView imgLogin;

	@FXML
	private ImageView img;
	@FXML
	private ImageView imgUtility;
	@FXML
	private ImageView addEmp;

	private static Stage loginStage;
	private static Stage addEmpStage;
	private static Stage attendenceStage;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println(imgLogin);
		System.out.println(imgUtility);

		imgLogin.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							if (loginStage == null) {
								FXMLLoader loader = new FXMLLoader(
										RootWindow.class
												.getResource("/applicationXML/loginWindow.fxml"));
								AnchorPane rootpane;
								try {
									rootpane = (AnchorPane) loader.load();
									Scene scene = new Scene(rootpane);
									loginStage = new Stage();
									loginStage.setScene(scene);
									loginStage
											.initModality(Modality.WINDOW_MODAL);
									loginStage.initOwner(((Node) event
											.getSource()).getScene()
											.getWindow());

									loginStage.setResizable(false);
									// primaryStage.getIcons().add(new
									// Image("application/logo3.png"));
									loginStage.setTitle("Login");
									loginStage.sizeToScene();
									loginStage.initStyle(StageStyle.UTILITY);
									loginStage.centerOnScreen();
									loginStage.show();
									event.consume();
								} catch (IOException e) {
									e.printStackTrace();
								}
							} else {

								loginStage.toFront();
							}
							loginStage
									.setOnCloseRequest(new EventHandler<WindowEvent>() {
										public void handle(WindowEvent we) {

											loginStage = null;
										}
									});
						}
					}
				});

		imgUtility.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							System.out
									.println("attendence= " + attendenceStage);
							if (attendenceStage == null) {
								attendenceStage = new Stage();
								AnchorPane rootpane;
								FXMLLoader loader = new FXMLLoader(
										RootWindow.class
												.getResource("/applicationXML/attendence.fxml"));

								try {
									rootpane = (AnchorPane) loader.load();
									Scene scene = new Scene(rootpane);
									System.out.println("stage before = "
											+ attendenceStage);
									attendenceStage.setScene(scene);
									attendenceStage
											.initModality(Modality.WINDOW_MODAL);
									attendenceStage.initOwner(((Node) event
											.getSource()).getScene()
											.getWindow());
									attendenceStage.setResizable(false);
									// primaryStage.getIcons().add(new
									// Image("application/logo3.png"));
									attendenceStage
											.setTitle("My Attendance Panel");
									attendenceStage.sizeToScene();
									attendenceStage
											.initStyle(StageStyle.UTILITY);
									attendenceStage.centerOnScreen();
									attendenceStage.show();
									attendenceStage
											.setOnHiding(new EventHandler<WindowEvent>() {
												public void handle(
														WindowEvent we) {
													System.out
															.println("stopped");
													for (WebcamPanel panel : WebCamBean
															.getPanels()) {
														panel.stop();
													}
												}
											});

									event.consume();
								} catch (IOException e) {
									e.printStackTrace();
								}

							} else {
								attendenceStage.toFront();
							}

							attendenceStage
									.setOnCloseRequest(new EventHandler<WindowEvent>() {
										public void handle(WindowEvent we) {

											attendenceStage = null;
										}
									});
						}
					}

				});
		addEmp.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							if (addEmpStage == null) {
								FXMLLoader loader = new FXMLLoader(
										RootWindow.class
												.getResource("/applicationXML/attendenceForm.fxml"));
								AnchorPane rootpane;
								try {
									rootpane = (AnchorPane) loader.load();
									Scene scene = new Scene(rootpane);
									addEmpStage = new Stage();
									addEmpStage.setScene(scene);
									addEmpStage
											.initModality(Modality.WINDOW_MODAL);
									addEmpStage.initOwner(((Node) event
											.getSource()).getScene()
											.getWindow());

									addEmpStage.setResizable(false);
									// primaryStage.getIcons().add(new
									// Image("application/logo3.png"));
									addEmpStage.setTitle("Login");
									addEmpStage.sizeToScene();
									addEmpStage.initStyle(StageStyle.UTILITY);
									addEmpStage.centerOnScreen();
									addEmpStage.show();
									event.consume();
								} catch (IOException e) {
									e.printStackTrace();
								}
							} else {

								addEmpStage.toFront();
							}
							addEmpStage
									.setOnCloseRequest(new EventHandler<WindowEvent>() {
										public void handle(WindowEvent we) {

											addEmpStage = null;
										}
									});
						}
					}
				});

	}

	public static void setAttendenWindowToClose() {

		attendenceStage = null;
	}

	public static void setLoginWindowToClose() {

		loginStage = null;
	}

	public static void setAddEmpWindowToClose() {

		addEmpStage = null;
	}
}
