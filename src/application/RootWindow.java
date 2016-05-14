package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageBuilder;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class RootWindow extends Application {
	ProgressBar loadingbar;
	final Float[] values = new Float[] { -1.0f, 0f, 0.6f, 1.0f };

	@Override
	public void start(Stage primaryStage) {
		try {
			final Stage stage = new Stage();
			loadingbar = new ProgressBar();
			FXMLLoader loader = new FXMLLoader(
					RootWindow.class
							.getResource("/application/applicationXML/common/startupScreen.fxml"));
			AnchorPane rootpane = (AnchorPane) loader.load();
			loadingbar.setScaleX(5.00);
			loadingbar.setScaleY(2.00);
			rootpane.setRightAnchor(loadingbar, 250.0);
			rootpane.setBottomAnchor(loadingbar, 10.0);
			rootpane.getChildren().addAll(loadingbar);
			Scene scene = new Scene(rootpane);
			// scene.getStylesheets().add(
			// getClass().getClassLoader()
			// .getResource("application/background.css")
			// .toExternalForm());
			// scene.getStylesheets().add(
			// getClass().getClassLoader()
			// .getResource("application/library.css")
			// .toExternalForm());

			stage.setScene(scene);
			stage.setResizable(false);
			// primaryStage.getIcons().add(new Image("application/logo3.png"));
			stage.setTitle("Attendance Tracking System");
			stage.sizeToScene();
			stage.show();

			final Timeline timeline = new Timeline(new KeyFrame(
					Duration.millis(0), new KeyValue(
							loadingbar.progressProperty(), 0)), new KeyFrame(
					Duration.millis(3000), new KeyValue(
							loadingbar.progressProperty(), 1)));
			timeline.play();
			timeline.setOnFinished(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					stage.close();
					FXMLLoader loader = new FXMLLoader(
							RootWindow.class.getResource("applicationXML/common/loginWindow.fxml"));
//									.getRe	source("applicationXML/Admin/AdminWindow.fxml"));
//					 .getResource("applicationXML/Employee/EmployeeWindow.fxml"));
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
				}
			});

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);

	}
}