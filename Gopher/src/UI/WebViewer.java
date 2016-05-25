package UI; 

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;

import static javafx.concurrent.Worker.State.FAILED;

public class WebViewer extends JPanel {

	private final JFXPanel jfxPanel = new JFXPanel();
	private WebEngine engine;

	public WebViewer(int x, int y) 
	{
		super();
		initComponents(x, y);
	}


	private void initComponents(int x, int y) 
	{
		this.setLayout(new BorderLayout());
		createScene();
		this.add(jfxPanel, BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(x, y));
		//this.
	}

	private void createScene() {

		Platform.runLater(new Runnable() {
			@Override 
			public void run() {

				WebView view = new WebView();
				engine = view.getEngine();

				engine.titleProperty().addListener(new ChangeListener<String>() {
					@Override
					public void changed(ObservableValue<? extends String> observable, String oldValue, final String newValue) {
						SwingUtilities.invokeLater(new Runnable() {
							@Override 
							public void run() {
								WebViewer.this.setName(newValue);
							}
						});
					}
				});
				jfxPanel.setScene(new Scene(view));
			}
		});
	}

	public void loadURL(final String url) {
		Platform.runLater(new Runnable() {
			@Override 
			public void run() {
				String tmp = toURL(url);

				if (tmp == null) {
					tmp = toURL("http://" + url);
				}

				engine.load(tmp);
			}
		});
	}

	private static String toURL(String str) {
		try {
			return new URL(str).toExternalForm();
		} catch (MalformedURLException exception) {
			return null;
		}
	}

}