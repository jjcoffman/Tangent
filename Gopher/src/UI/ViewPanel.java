package UI;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.JPanel;


public class ViewPanel extends JPanel
{
	private static final long serialVersionUID = 6230048633623396057L;
	BufferedImage img = null;
	
	public ViewPanel()
	{
		super();
		this.setLayout(new BorderLayout());
		WebViewer browser = new WebViewer(940, 720);
        browser.setVisible(true);
        browser.loadURL("http://www.bleepingcomputer.com/");
        this.add(browser, BorderLayout.NORTH);
	}
}
