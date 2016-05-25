package UI;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
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
        browser.loadURL("https://www.reddit.com/r/Technic_News/");
        this.add(browser, BorderLayout.NORTH);
	}
}
