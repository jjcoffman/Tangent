package UI;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;


/**ViewPanel creates a javaFX browser panel that loads the passed webpage
 * @author DoubleJ
 *
 */
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
        browser.loadURL("https://news.ycombinator.com");  
        this.add(browser, BorderLayout.NORTH);
	}
}
