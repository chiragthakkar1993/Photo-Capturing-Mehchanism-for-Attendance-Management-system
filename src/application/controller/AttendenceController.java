package application.controller;

import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;
import javax.jws.Oneway;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import application.bean.WebCamBean;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

import application.RootWindow;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.embed.swing.JFXPanel;
import javafx.embed.swing.SwingNode;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressBarBuilder;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class AttendenceController implements Initializable {
	@FXML
	private Pane DateTimePane;
	@FXML
	private Pane inOutPane;
	@FXML
	private Pane middlePane;

	@FXML
	private Label lblDate;
	@FXML
	private Label lblTime;
	@FXML
	private Label pressDate;
	@FXML
	private Label pressTime;
	@FXML
	private Label lblName;

	@FXML
	private RadioButton pressIn;
	@FXML
	private RadioButton pressOut;

	@FXML
	private TextField txtEnroll;
	@FXML
	private TextArea commentBox;

	@FXML
	private Button btnRetake;
	@FXML
	private Button btnMakeAttendence;
	@FXML
	private Button btnCancel;
	@FXML
	private ImageView imgview1;
	@FXML
	private Pane webcamePane;
	@FXML
	private AnchorPane rootpane;
	private Stage stage;

	/* ****************************************************************************************** */

	private Executor executor = Executors.newSingleThreadExecutor();

	private Dimension size = WebcamResolution.QQVGA.getSize();

	private List<Webcam> webcams = Webcam.getWebcams();
	private List<WebcamPanel> panels = new ArrayList<WebcamPanel>();

	public void stopWebcam() {
		for (WebcamPanel panel : panels) {
			panel.stop();
		}
	}

	public boolean isWebcamStarted() {
		boolean result = false;
		for (WebcamPanel panel : panels) {
			if (panel.isStarted())
				result = true;

		}
		return result;
	}

	public void startWebcam() {
		// Runnable r = new Runnable() {

		// @Override
		// public void run() {
		for (WebcamPanel panel : panels) {
			panel.start();
		}

		// }
		// };

		// Thread t = new Thread(r);
		// t.start();

	}

	public void TakeSnapshotFromVideoExample() {

		for (Webcam webcam : webcams) {
			webcam.setViewSize(size);
			WebcamPanel panel = new WebcamPanel(webcam, size, false);
			panel.setFPSDisplayed(true);
			panel.setFillArea(true);
			panels.add(panel);
		}

		for (WebcamPanel panel : panels) {
			SwingNode node = new SwingNode();
			node.setContent(panel);

			webcamePane.getChildren().addAll(node);
		}

	}

	/*
	 * *****************************digital clock pad
	 * method****************************************
	 */
	public static String pad(int fieldWidth, char padChar, String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length(); i < fieldWidth; i++) {
			sb.append(padChar);
		}
		sb.append(s);

		return sb.toString();
	}

	/* ****************************************************************************************** */

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		WebCamBean.setPanels(panels);

		TakeSnapshotFromVideoExample();
		Task<Void> task = new Task<Void>() {

			@Override
			protected Void call() throws Exception {
				startWebcam();

				if (isCancelled() || isDone()) {
					System.out.println("cancelled");
					stopWebcam();

				}
				return null;
			}

		};
		Thread t1 = new Thread(task);
		t1.start();
		System.out.println(DateTimePane);

		System.out.println(inOutPane);
		System.out.println(middlePane);

		System.out.println(lblDate);

		System.out.println(lblTime);

		System.out.println(pressDate);

		System.out.println(pressTime);

		System.out.println(lblName);

		System.out.println(pressIn);

		System.out.println(pressOut);

		System.out.println(txtEnroll);

		System.out.println(commentBox);

		System.out.println(btnRetake);

		System.out.println(btnMakeAttendence);

		System.out.println(btnCancel);
		Calendar calendar = Calendar.getInstance();
		// SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		// SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		// String pressTimeStr = sdf.format(Calendar.getInstance().getTime());
		// String pressDateStr = sdf2.format(Calendar.getInstance().getTime());
		String am_pm = calendar.get(Calendar.AM_PM) == Calendar.AM ? "AM"
				: "PM";
		String PressTM = String.valueOf(calendar.get(Calendar.HOUR) == 0 ? "12"
				: calendar.get(Calendar.HOUR) + "")
				+ ":"

				+ String.valueOf(calendar.get(Calendar.MINUTE))
				+ ":"
				+ String.valueOf(calendar.get(Calendar.SECOND)) + " " + am_pm

		;

		String PressDT = String.valueOf(calendar.get(Calendar.DATE)) + "/"
				+ String.valueOf(calendar.get(Calendar.MONTH) + 1) + "/"
				+ String.valueOf(calendar.get(Calendar.YEAR));
		pressTime.setText(PressTM);
		pressDate.setText(PressDT);
		lblDate.setText(PressDT);	
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0),
				new EventHandler<javafx.event.ActionEvent>() {
					@Override
					public void handle(javafx.event.ActionEvent actionEvent) {
						Calendar time = Calendar.getInstance();
						String hourString = pad(
								2,
								' ',
								time.get(Calendar.HOUR) == 0 ? "12" : time
										.get(Calendar.HOUR) + "");
						String minuteString = pad(2, '0',
								time.get(Calendar.MINUTE) + "");
						String secondString = pad(2, '0',
								time.get(Calendar.SECOND) + "");
						String ampmString = time.get(Calendar.AM_PM) == Calendar.AM ? "AM"
								: "PM";
						lblTime.setText(hourString + ":" + minuteString + ":"
								+ secondString + " " + ampmString);
					}
				}), new KeyFrame(Duration.seconds(1)));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();

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
									// stopWebcam();
									ApplicationController
											.setAttendenWindowToClose();
								}
							});
							for (WebcamPanel panel : panels) {
								panel.stop();
							}

							stage.close();
						}
					}
				});
		btnMakeAttendence.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							try {
								Calendar calendar = Calendar.getInstance();
								for (int i = 0; i < webcams.size(); i++) {
									Webcam webcam = webcams.get(i);
									System.out.println();
									File file = new File(
											"src/application/webcamImages/test-1.jpg");
									ImageIO.write(webcam.getImage(), "JPG",
											file);
									System.out.format(
											"Image for %s saved in %s \n",
											webcam.getName(), file);

									stopWebcam();
									String am_pm = calendar.get(Calendar.AM_PM) == Calendar.AM ? "AM"
											: "PM";
									String PressTM = String.valueOf(calendar
											.get(Calendar.HOUR) == 0 ? "12"
											: calendar.get(Calendar.HOUR) + "")
											+ ":"

											+ String.valueOf(calendar
													.get(Calendar.MINUTE))
											+ ":"
											+ String.valueOf(calendar
													.get(Calendar.SECOND))
											+ " " + am_pm

									;

									String PressDT = String.valueOf(calendar
											.get(Calendar.DATE))
											+ "/"
											+ String.valueOf(calendar
													.get(Calendar.MONTH) + 1)
											+ "/"
											+ String.valueOf(calendar
													.get(Calendar.YEAR));
									pressTime.setText(PressTM);
									pressDate.setText(PressDT);

								}
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				});
		btnRetake.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						if (event.isPrimaryButtonDown()) {
							// TakeSnapshotFromVideoExample();
							if (!isWebcamStarted())
								startWebcam();

						}
					}
				});

	}
}
