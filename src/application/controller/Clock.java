package application.controller;

import java.util.Calendar;
import java.util.TimeZone;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * 
 * @author Saravanababu
 */
public class Clock extends Application {

	private double initX;
	private double initY;
	private Timeline delayTimeline, secondTimeline;

	@Override
	public void start(final Stage primaryStage) {

		// creating root node with StackPane Layout, because every controls in
		// clock overlaps each other
		StackPane root = new StackPane();
		// set stackpane's alignment to center so that all the controls like
		// hour hand min hond etc will place at center
		root.setAlignment(Pos.CENTER);
		// background strip for clock
//		ImageView image = new ImageView(new Image(getClass()
//				.getResourceAsStream("clock.png")));
//		root.getChildren().add(image);
		// Make stage style as transparent
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		// change the scene color to transparent
		Scene scene = new Scene(root, 220, 220, Color.TRANSPARENT);

		// create a lineargradient to display half of the line shape and rest as
		// transparent.
		LinearGradient linear = new LinearGradient(0, 0, 1, 1, true,
				CycleMethod.NO_CYCLE, new Stop[] { new Stop(0, Color.WHITE),
						new Stop(0.6, Color.TRANSPARENT) });

		// create line shapes for hour,minute and second for clock hands
		final Line hour = new Line(300, 300, 300, 420);
		hour.setStrokeWidth(5);
		hour.setStroke(linear);
		final Line min = new Line(330, 330, 330, 500);
		min.setStrokeWidth(3);
		min.setStroke(linear);
		final Line sec = new Line(330, 330, 330, 500);
		sec.setStrokeWidth(1);
		sec.setStroke(linear);
		root.getChildren().addAll(hour, min, sec);
		root.setStyle("-fx-background-color: red;");
//		ImageView fv = new ImageView(new Image(getClass().getResourceAsStream(
//				"faviicon.png")));
		final Button close = new Button("Close");
		close.setDefaultButton(true);
		close.setVisible(false);
//		root.getChildren().addAll(fv, close);
		scene.setCursor(Cursor.MOVE);
		primaryStage.centerOnScreen();
	
		// when mouse button is pressed, save the initial position of screen

		root.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				initX = me.getScreenX() - primaryStage.getX();
				initY = me.getScreenY() - primaryStage.getY();
			}
		});

		// when screen is dragged, translate it accordingly
		root.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				primaryStage.setX(me.getScreenX() - initX);
				primaryStage.setY(me.getScreenY() - initY);
			}
		});

		root.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				close.setVisible(true);
			}
		});
		root.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				close.setVisible(false);
			}
		});
		close.setCursor(Cursor.HAND);
		close.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				primaryStage.close();
			}
		});

		primaryStage.setTitle("AnalogClock");
		primaryStage.setScene(scene);
		primaryStage.show();

		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		int hours = cal.getTime().getHours();
		int minut = cal.getTime().getMinutes();
		hours = hours * 30 + minut / 2;
		minut = minut * 6;
		int second = cal.getTime().getSeconds();
		minut = minut + second / 10;
		second = second * 6;
		hour.setRotate(hours);
		min.setRotate(minut);
		sec.setRotate(second);
		delayTimeline = new Timeline();
		delayTimeline.getKeyFrames().add(
				new KeyFrame(new Duration(
						1000 - (System.currentTimeMillis() % 1000)),
						new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								secondTimeline = new Timeline();
								secondTimeline
										.setCycleCount(Timeline.INDEFINITE);
								secondTimeline
										.getKeyFrames()
										.add(new KeyFrame(
												Duration.seconds(1),
												new EventHandler<ActionEvent>() {
													@Override
													public void handle(
															ActionEvent event) {
														Calendar cal = Calendar
																.getInstance(TimeZone
																		.getDefault());
														int hours = cal
																.getTime()
																.getHours();
														int minut = cal
																.getTime()
																.getMinutes();
														hours = hours * 30
																+ minut / 2;
														minut = minut * 6;
														int second = cal
																.getTime()
																.getSeconds();
														minut = minut + second
																/ 10;
														second = second * 6;

														hour.setRotate(hours);
														min.setRotate(minut);
														sec.setRotate(second);

													}
												}));
								secondTimeline.play();
							}
						}));
		delayTimeline.play();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
