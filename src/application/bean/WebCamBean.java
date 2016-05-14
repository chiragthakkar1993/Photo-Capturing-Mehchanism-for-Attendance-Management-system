package application.bean;

import java.util.ArrayList;
import java.util.List;

import com.github.sarxos.webcam.WebcamPanel;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class WebCamBean {
	private static List<WebcamPanel> panels;

	public static List<WebcamPanel> getPanels() {
		return panels;
	}

	public static void setPanels(List<WebcamPanel> panels) {
		WebCamBean.panels = panels;
	}

	

}
