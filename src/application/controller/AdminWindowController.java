package application.controller;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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

public class AdminWindowController implements Initializable {
	@FXML
	private TabPane tabPaneManageEmp;
	@FXML
	private TabPane tabPaneManageTeacher;
	@FXML
	private Tab tabAddEmp;
	@FXML
	private Tab tabViewEmpProfile;
	@FXML
	private Tab tabAssignWork;
	@FXML
	private Tab tabAssignedWork;
	@FXML
	private AnchorPane mainPane;
	@FXML
	private AnchorPane paneAssignWork;
	@FXML
	private AnchorPane paneAssignedWork;
	@FXML
	private AnchorPane paneAddEmp;
	@FXML
	private AnchorPane paneViewEmpProfile;

	@FXML
	private Pane paneAddSub;
	@FXML
	private Pane paneViewAttendance;
	@FXML
	private Pane paneViewWorkDetails;
	@FXML
	private Pane leftPane;

	@FXML
	private Pane paneAddStd;
	@FXML
	private Pane SecondaryPane;
	@FXML
	private Label lblManageEmp;
	@FXML
	private Label lblManageTeacher;
	@FXML
	private Label lblAddStd;
	@FXML
	private Label lblAddSub;
	@FXML
	private Label lblViewAttendance;
	@FXML
	private Label lblViewWorkDetail;
	@FXML
	private Label lblChangePwd;
	@FXML
	private Label lblLogout;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(tabPaneManageEmp);
		System.out.println(tabPaneManageTeacher);
		System.out.println(leftPane);
		System.out.println(mainPane);
		System.out.println(SecondaryPane);
		System.out.println(lblAddStd);
		System.out.println(lblAddSub);
		System.out.println(lblChangePwd);
		System.out.println(lblLogout);
		System.out.println(lblManageEmp);
		System.out.println(lblManageTeacher);
		System.out.println(lblViewAttendance);
		System.out.println(lblViewWorkDetail);
		System.out.println(paneAddEmp);
		System.out.println(paneAssignedWork);
		System.out.println(paneAssignWork);
		System.out.println(paneViewEmpProfile);
		System.out.println(paneAddStd);
		System.out.println(tabAddEmp);
		System.out.println(tabAssignedWork);
		System.out.println(tabAssignWork);
		System.out.println(tabViewEmpProfile);
		System.out.println(paneAddSub);
		System.out.println(paneViewAttendance);
		paneAddStd.setVisible(false);
		paneAddSub.setVisible(false);
		paneViewAttendance.setVisible(false);
		paneViewWorkDetails.setVisible(false);
		tabPaneManageEmp.setVisible(false);
		tabPaneManageTeacher.setVisible(false);

		lblAddStd.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblAddStd.setTextFill(Color.BLUE);
					}
				});

		lblAddStd.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblAddStd.setTextFill(Color.BLACK);
					}
				});
		lblAddStd.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							paneAddStd.setVisible(true);
							paneAddSub.setVisible(false);
							paneViewAttendance.setVisible(false);
							paneViewWorkDetails.setVisible(false);
							tabPaneManageEmp.setVisible(false);
							tabPaneManageTeacher.setVisible(false);

							FXMLLoader loader = new FXMLLoader(
									AdminWindowController.class
											.getResource("/application/applicationXML/Admin/Admin-Addstandard.fxml"));
							AnchorPane rootPane = null;
							try {
								rootPane = (AnchorPane) loader.load();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							//
							paneAddStd.setPrefSize(rootPane.getPrefWidth(),
									rootPane.getPrefHeight());
							paneAddStd.getChildren().setAll(rootPane);
							paneAddStd.setLayoutX(5.0);
							paneAddStd.setLayoutY(5.0);
						}
					}
				});
		lblAddSub.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblAddSub.setTextFill(Color.BLUE);
					}
				});
		lblAddSub.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblAddSub.setTextFill(Color.BLACK);
					}
				});
		lblAddSub.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							paneAddStd.setVisible(false);
							paneAddSub.setVisible(true);
							paneViewAttendance.setVisible(false);
							paneViewWorkDetails.setVisible(false);
							tabPaneManageEmp.setVisible(false);
							tabPaneManageTeacher.setVisible(false);
							FXMLLoader loader = new FXMLLoader(
									AdminWindowController.class
											.getResource("/application/applicationXML/Admin/Admin-Addsubjects.fxml"));
							AnchorPane rootPane = null;
							try {
								rootPane = (AnchorPane) loader.load();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							//
							paneAddSub.setPrefSize(rootPane.getPrefWidth(),
									rootPane.getPrefHeight());
							paneAddSub.getChildren().setAll(rootPane);
							paneAddSub.setLayoutX(5.0);
							paneAddSub.setLayoutY(5.0);
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
									AdminWindowController.class
											.getResource("/application/applicationXML/common/ChangePassword.fxml"));
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
									AdminWindowController.class
											.getResource("/application/applicationXML/common/loginWindow.fxml"));
							AnchorPane rootpane = null;
							try {
								rootpane = (AnchorPane) loader.load();
							} catch (IOException ex) {
								Logger.getLogger(
										AdminWindowController.class.getName())
										.log(Level.SEVERE, null, ex);
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
		lblManageEmp.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblManageEmp.setTextFill(Color.BLUE);
					}
				});
		lblManageEmp.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblManageEmp.setTextFill(Color.BLACK);
					}
				});
		lblManageEmp.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							paneAddStd.setVisible(false);
							paneAddSub.setVisible(false);
							paneViewAttendance.setVisible(false);
							paneViewWorkDetails.setVisible(false);
							tabPaneManageEmp.setVisible(true);
							tabPaneManageTeacher.setVisible(false);
							FXMLLoader loader = new FXMLLoader(
									AdminWindowController.class
											.getResource("/application/applicationXML/Admin/Manage EmployeeProfile/Admin-AddEmployeeProfile.fxml"));
							AnchorPane rootPane = null;
							try {
								rootPane = (AnchorPane) loader.load();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							// SecondaryPane.setPrefSize(rootpane.getPrefWidth(),
							// rootpane.getPrefHeight());
							paneAddEmp.getChildren().setAll(rootPane);
							paneAddEmp.setLayoutX(370.0);
							paneAddEmp.setLayoutY(120.0);
						}
					}
				});
		lblManageTeacher.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblManageTeacher.setTextFill(Color.BLUE);
					}
				});
		lblManageTeacher.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblManageTeacher.setTextFill(Color.BLACK);
					}
				});
		lblManageTeacher.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							paneAddStd.setVisible(false);
							paneAddSub.setVisible(false);
							paneViewAttendance.setVisible(false);
							paneViewWorkDetails.setVisible(false);
							tabPaneManageEmp.setVisible(false);
							tabPaneManageTeacher.setVisible(true);
							FXMLLoader loader = new FXMLLoader(
									AdminWindowController.class
											.getResource("/application/applicationXML/Admin/Admin-AssignTeacherWork.fxml"));
							AnchorPane rootPane = null;
							try {
								rootPane = (AnchorPane) loader.load();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							// SecondaryPane.setPrefSize(rootpane.getPrefWidth(),
							// rootpane.getPrefHeight());
							paneAssignWork.getChildren().setAll(rootPane);
							paneAddEmp.setLayoutX(370.0);
							paneAddEmp.setLayoutY(120.0);
						}
					}
				});
		lblViewAttendance.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblViewAttendance.setTextFill(Color.BLUE);
					}
				});
		lblViewAttendance.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblViewAttendance.setTextFill(Color.BLACK);
					}
				});
		lblViewAttendance.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							paneAddStd.setVisible(false);
							paneAddSub.setVisible(false);
							paneViewAttendance.setVisible(true);
							paneViewWorkDetails.setVisible(false);
							tabPaneManageEmp.setVisible(false);
							tabPaneManageTeacher.setVisible(false);
							FXMLLoader loader = new FXMLLoader(
									AdminWindowController.class
											.getResource("/application/applicationXML/Admin/Admin-viewAttendance.fxml"));
							AnchorPane rootPane = null;
							try {
								rootPane = (AnchorPane) loader.load();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							//
							paneViewAttendance.setPrefSize(
									rootPane.getPrefWidth(),
									rootPane.getPrefHeight());
							paneViewAttendance.getChildren().setAll(rootPane);
							paneViewAttendance.setLayoutX(5.0);
							paneViewAttendance.setLayoutY(5.0);
						}
					}
				});
		lblViewWorkDetail.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblViewWorkDetail.setTextFill(Color.BLUE);
					}
				});
		lblViewWorkDetail.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						lblViewWorkDetail.setTextFill(Color.BLACK);
					}
				});
		lblViewWorkDetail.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							paneAddStd.setVisible(false);
							paneAddSub.setVisible(false);
							paneViewAttendance.setVisible(false);
							paneViewWorkDetails.setVisible(true);
							tabPaneManageEmp.setVisible(false);
							tabPaneManageTeacher.setVisible(false);
							FXMLLoader loader = new FXMLLoader(
									AdminWindowController.class
											.getResource("/application/applicationXML/Admin/Admin-ViewWorkDetails.fxml"));
							AnchorPane rootPane = null;
							try {
								rootPane = (AnchorPane) loader.load();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							//
							paneViewWorkDetails.setPrefSize(
									rootPane.getPrefWidth(),
									rootPane.getPrefHeight());
							paneViewWorkDetails.getChildren().setAll(rootPane);
							paneViewWorkDetails.setLayoutX(5.0);
							paneViewWorkDetails.setLayoutY(5.0);
						}
					}
				});
		// tabAddEmp.setOnSelectionChanged(new EventHandler<Event>() {
		// @Override
		// public void handle(Event t) {
		// if (tabAddEmp.isSelected()) {
		// FXMLLoader loader = new FXMLLoader(
		// AdminWindowController.class
		// .getResource("/application/applicationXML/Admin/Manage EmployeeProfile/Admin-AddEmployeeProfile.fxml"));
		// AnchorPane rootPane = null;
		// try {
		// rootPane = (AnchorPane) loader.load();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// // SecondaryPane.setPrefSize(rootpane.getPrefWidth(),
		// // rootpane.getPrefHeight());
		// paneAddEmp.getChildren().setAll(rootPane);
		// paneAddEmp.setLayoutX(370.0);
		// paneAddEmp.setLayoutY(120.0);
		// }
		// }
		// });
		tabViewEmpProfile.setOnSelectionChanged(new EventHandler<Event>() {
			@Override
			public void handle(Event t) {
				if (tabViewEmpProfile.isSelected()) {
					FXMLLoader loader = new FXMLLoader(
							AdminWindowController.class
									.getResource("/application/applicationXML/Admin/Manage EmployeeProfile/ViewEmployeeProfile.fxml"));
					AnchorPane rootPane = null;
					try {
						rootPane = (AnchorPane) loader.load();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// SecondaryPane.setPrefSize(rootpane.getPrefWidth(),
					// rootpane.getPrefHeight());
					paneViewEmpProfile.getChildren().setAll(rootPane);
					paneViewEmpProfile.setLayoutX(370.0);
					paneViewEmpProfile.setLayoutY(120.0);
				}
			}
		});
		tabAssignedWork.setOnSelectionChanged(new EventHandler<Event>() {
			@Override
			public void handle(Event t) {
				if (tabAssignedWork.isSelected()) {
					FXMLLoader loader = new FXMLLoader(
							AdminWindowController.class
									.getResource("/application/applicationXML/Admin/Admin-viewAssignTeacherWork.fxml"));
					AnchorPane rootPane = null;
					try {
						rootPane = (AnchorPane) loader.load();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// SecondaryPane.setPrefSize(rootpane.getPrefWidth(),
					// rootpane.getPrefHeight());
					paneAssignedWork.getChildren().setAll(rootPane);
					paneAssignedWork.setLayoutX(370.0);
					paneAssignedWork.setLayoutY(120.0);
				}
			}
		});

	}
}
