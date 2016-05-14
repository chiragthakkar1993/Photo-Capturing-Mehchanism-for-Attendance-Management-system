package application.controller;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.scene.BoundsAccessor;
import com.sun.media.ui.MessageBox;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.embed.swing.SwingNode;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.Effect;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialogs;

public class ChangePasswordController implements Initializable {

	@FXML
	private Button btnSave;
	@FXML
	private Button btnCancel;
	@FXML
	private TextField txtOldPwd;
	@FXML
	private PasswordField txtNewPwd;
	@FXML
	private PasswordField txtConfirmPwd;

	private Pane SecondaryPane;
	private Stage stage;
	private Scene scene;
	AnchorPane rootpane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println(btnCancel);

		System.out.println(btnSave);

		System.out.println(txtOldPwd);

		System.out.println(txtNewPwd);
		System.out.println(txtConfirmPwd);
		btnCancel.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {

						if (event.isPrimaryButtonDown()) {
							System.out.println("cancel");
							txtOldPwd.clear();
							txtNewPwd.clear();
							txtConfirmPwd.clear();
							Stage stage = (Stage) ((Button) event.getSource())
									.getScene().getWindow();
							stage.close();
						}
					}
				});

		btnSave.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {

						if (event.isPrimaryButtonDown()) {
							System.out.println("Save");
							if (txtNewPwd.getText().equals(
									txtConfirmPwd.getText())) {
								try {
									// LoginStatus status = LoginStatusBean
									// .getStatus();
									// service.consumption.services
									// .changePassword(status.getUserid(),
									// txtOldPwd.getText(),
									// txtNewPwd.getText());
									Dialogs.create()
											.owner(stage)
											.title("Login")
											.message(
													"Password Changed Successfully")
											.showInformation();
									txtOldPwd.clear();
									txtNewPwd.clear();
									txtConfirmPwd.clear();
									Stage stage = (Stage) ((Button) event
											.getSource()).getScene()
											.getWindow();
									stage.close();
								} catch (Exception ex) {
									Action response = Dialogs
											.create()
											.owner(stage)
											.title("Login")
											.message(
													"Wrong Username/Password Combination")
											.showError();
								}
							} else {
								Action response = Dialogs.create().owner(stage)
										.title("Login")
										.message("Password Does not Match")
										.showError();
							}
						}
					}
				});

	}
}
