package application.controller;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import application.bean.WebCamBean;

import com.github.sarxos.webcam.WebcamPanel;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class EmployeeWindowController implements Initializable {
	@FXML
	private Pane paneMyProfile;
	@FXML
	private Pane paneAddWork;
	@FXML
	private Pane paneMyWork;
	@FXML
	private Pane paneViewMyAttendance;
	@FXML
	private Pane paneViewAssignedWork;
	// @FXML
	// private AnchorPane paneAssignWork;
	// @FXML
	// private AnchorPane paneAssignedWork;
	// @FXML
	// private AnchorPane paneAddEmp;
	// @FXML
	// private AnchorPane paneViewEmpProfile;
	// @FXML
	// private Pane paneAddStd;
	// @FXML
	// private Pane paneAddSub;
	// @FXML
	// private Pane paneViewAttendance;
	// @FXML
	// private Pane paneViewWorkDetails;
	@FXML
	private Pane leftPane;

	@FXML
	private Pane SecondaryPane;
	@FXML
	private Label lblMyProfile;
	@FXML
	private Label lblMyWork;
	@FXML
	private Label lblViewMyAttendance;
	@FXML
	private Label lblViewAssignedWork;
	@FXML
	private Label lblMakeAttebdance;
	@FXML
	private Label lblChangePwd;
	@FXML
	private Label lblAddWork;
	@FXML
	private Label lblLogout;
	@FXML
	private Label lblEnrollId;
	@FXML
	private Label lblUserName;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(leftPane);
		System.out.println(SecondaryPane);
		System.out.println(lblChangePwd);
		System.out.println(lblLogout);
		System.out.println(lblMakeAttebdance);
		System.out.println(lblMyProfile);
		System.out.println(lblAddWork);
		System.out.println(lblMyWork);
		System.out.println(lblViewAssignedWork);
		System.out.println(lblViewMyAttendance);
		System.out.println(lblViewAssignedWork);
		System.out.println(paneMyProfile);
		System.out.println(lblEnrollId);
		System.out.println(lblUserName);
		paneMyProfile.setVisible(false);
		paneAddWork.setVisible(false);
		paneMyWork.setVisible(false);
		paneViewMyAttendance.setVisible(false);
		paneViewAssignedWork.setVisible(false);
		lblMakeAttebdance.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblMakeAttebdance.setTextFill(Color.BLUE);
					}
				});

		lblMakeAttebdance.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblMakeAttebdance.setTextFill(Color.BLACK);
					}
				});
		lblMakeAttebdance.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							FXMLLoader loader = new FXMLLoader(
									EmployeeWindowController.class
											.getResource("/application/applicationXML/Employee/attendence.fxml"));
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
							stage.setTitle("eLibrary");
							stage.sizeToScene();
							stage.show();
							stage.setOnHiding(new EventHandler<WindowEvent>() {
								public void handle(WindowEvent we) {
									System.out.println("stopped");
									for (WebcamPanel panel : WebCamBean
											.getPanels()) {
										panel.stop();
									}
								}
							});

						}
					}
				});

		lblMyProfile.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblMyProfile.setTextFill(Color.BLUE);
					}
				});

		lblMyProfile.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblMyProfile.setTextFill(Color.BLACK);
					}
				});
		lblMyProfile.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							paneMyProfile.setVisible(true);
							paneAddWork.setVisible(false);
							paneMyWork.setVisible(false);
							paneViewMyAttendance.setVisible(false);
							paneViewAssignedWork.setVisible(false);
							FXMLLoader loader = new FXMLLoader(
									EmployeeWindowController.class
											.getResource("/application/applicationXML/Employee/Employee-ViewEmployeeProfile.fxml"));
							AnchorPane rootPane = null;
							try {
								rootPane = (AnchorPane) loader.load();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							//
							paneMyProfile.setPrefSize(rootPane.getPrefWidth(),
									rootPane.getPrefHeight());
							paneMyProfile.getChildren().setAll(rootPane);
							paneMyProfile.setLayoutX(5.0);
							paneMyProfile.setLayoutY(5.0);
						}
					}
				});
		lblChangePwd.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblChangePwd.setTextFill(Color.BLUE);
					}
				});
		lblChangePwd.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblChangePwd.setTextFill(Color.BLACK);
					}
				});
		lblChangePwd.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {

							FXMLLoader loader = new FXMLLoader(
									EmployeeWindowController.class
											.getResource("/application/applicationXML/common/ChangePassword.fxml"));
							AnchorPane rootpane = null;
							try {
								rootpane = (AnchorPane) loader.load();
							} catch (IOException ex) {
								Logger.getLogger(
										EmployeeWindowController.class
												.getName()).log(Level.SEVERE,
										null, ex);
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
							stage.setTitle("eLibrary Login ");
							stage.sizeToScene();
							stage.show();

						}
					}
				});
		lblLogout.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblLogout.setTextFill(Color.BLUE);
					}
				});
		lblLogout.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblLogout.setTextFill(Color.BLACK);
					}
				});
		lblLogout.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {

							FXMLLoader loader = new FXMLLoader(
									EmployeeWindowController.class
											.getResource("/application/applicationXML/common/loginWindow.fxml"));
							AnchorPane rootpane = null;
							try {
								rootpane = (AnchorPane) loader.load();
							} catch (IOException ex) {
								Logger.getLogger(
										EmployeeWindowController.class
												.getName()).log(Level.SEVERE,
										null, ex);
							}
							Scene scene = new Scene(rootpane);
							Stage stage = (Stage) ((Label) event.getSource())
									.getScene().getWindow();
							stage.close();
							// scene.getStylesheets().add(
							// getClass().getClassLoader()
							// .getResource("application/css/background.css")
							// .toExternalForm());
							// scene.getStylesheets().add(
							// getClass().getClassLoader()
							// .getResource("application/css/library.css")
							// .toExternalForm());
							stage = new Stage();
							stage.setScene(scene);
							stage.setResizable(false);
							// stage.getIcons().add(
							// new Image("application/images/logo3.png"));
							stage.setTitle("eLibrary Login ");
							stage.sizeToScene();
							stage.show();
						}
					}
				});
		lblAddWork.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblAddWork.setTextFill(Color.BLUE);
					}
				});

		lblAddWork.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblAddWork.setTextFill(Color.BLACK);
					}
				});
		lblAddWork.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							paneMyProfile.setVisible(false);
							paneAddWork.setVisible(true);
							paneMyWork.setVisible(false);
							paneViewMyAttendance.setVisible(false);
							paneViewAssignedWork.setVisible(false);
							FXMLLoader loader = new FXMLLoader(
									EmployeeWindowController.class
											.getResource("/application/applicationXML/Employee/Employee-AddWork.fxml"));
							AnchorPane rootPane = null;
							try {
								rootPane = (AnchorPane) loader.load();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							//
							paneAddWork.setPrefSize(rootPane.getPrefWidth(),
									rootPane.getPrefHeight());
							paneAddWork.getChildren().setAll(rootPane);
							paneAddWork.setLayoutX(5.0);
							paneAddWork.setLayoutY(5.0);
						}
					}
				});
		lblMyWork.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblMyWork.setTextFill(Color.BLUE);
					}
				});

		lblMyWork.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblMyWork.setTextFill(Color.BLACK);
					}
				});
		lblMyWork.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							paneMyProfile.setVisible(false);
							paneAddWork.setVisible(false);
							paneMyWork.setVisible(true);
							paneViewMyAttendance.setVisible(false);
							paneViewAssignedWork.setVisible(false);
							FXMLLoader loader = new FXMLLoader(
									EmployeeWindowController.class
											.getResource("/application/applicationXML/Employee/Employee-MyWork.fxml"));
							AnchorPane rootPane = null;
							try {
								rootPane = (AnchorPane) loader.load();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							//
							paneMyWork.setPrefSize(rootPane.getPrefWidth(),
									rootPane.getPrefHeight());
							paneMyWork.getChildren().setAll(rootPane);
							paneMyWork.setLayoutX(5.0);
							paneMyWork.setLayoutY(5.0);
						}
					}
				});
		lblViewAssignedWork.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblViewAssignedWork.setTextFill(Color.BLUE);
					}
				});

		lblViewAssignedWork.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblViewAssignedWork.setTextFill(Color.BLACK);
					}
				});
		lblViewAssignedWork.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							paneMyProfile.setVisible(false);
							paneAddWork.setVisible(false);
							paneMyWork.setVisible(false);
							paneViewMyAttendance.setVisible(false);
							paneViewAssignedWork.setVisible(true);
							FXMLLoader loader = new FXMLLoader(
									EmployeeWindowController.class
											.getResource("/application/applicationXML/Employee/Employee-viewAssignTeacherWork.fxml"));
							AnchorPane rootPane = null;
							try {
								rootPane = (AnchorPane) loader.load();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							//
							paneViewAssignedWork.setPrefSize(
									rootPane.getPrefWidth(),
									rootPane.getPrefHeight());
							paneViewAssignedWork.getChildren().setAll(rootPane);
							paneViewAssignedWork.setLayoutX(5.0);
							paneViewAssignedWork.setLayoutY(5.0);
						}
					}
				});
		lblViewMyAttendance.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblViewMyAttendance.setTextFill(Color.BLUE);
					}
				});

		lblViewMyAttendance.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblViewMyAttendance.setTextFill(Color.BLACK);
					}
				});
		lblViewMyAttendance.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							paneMyProfile.setVisible(false);
							paneAddWork.setVisible(false);
							paneMyWork.setVisible(false);
							paneViewMyAttendance.setVisible(true);
							paneViewAssignedWork.setVisible(false);
							FXMLLoader loader = new FXMLLoader(
									EmployeeWindowController.class
											.getResource("/application/applicationXML/Employee/Employee-viewAttendanceDetails.fxml"));
							AnchorPane rootPane = null;
							try {
								rootPane = (AnchorPane) loader.load();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							//
							paneViewMyAttendance.setPrefSize(
									rootPane.getPrefWidth(),
									rootPane.getPrefHeight());
							paneViewMyAttendance.getChildren().setAll(rootPane);
							paneViewMyAttendance.setLayoutX(5.0);
							paneViewMyAttendance.setLayoutY(5.0);
						}
					}
				});

	}
}
