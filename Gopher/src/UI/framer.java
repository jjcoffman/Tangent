package UI;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import java.awt.ScrollPane;

/**
 * This is the frame that we are adding components to. SINGLETON
 * @author Jonathan Coffman
 *
 */
public class framer extends JFrame
{

	private static final long serialVersionUID = 8955275819049246901L;
	private static framer Framer = null;
	
	
	private framer()
	{
		super("SMARMY");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1024, 768);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		SidePane panel = new SidePane();
		getContentPane().add(panel, BorderLayout.WEST);
		
		ViewPanel panel_1 = new ViewPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		ScrollPane scrollPane = new ScrollPane();
		panel_1.add(scrollPane);
		
		JMenuBar menuBar = new MenuBar();
		setJMenuBar(menuBar);
		
		
		
		
		this.setVisible(true);
	}
	
	public static framer getFramer()
	{
		if(Framer == null)
			Framer = new framer();
		return Framer;
	}
	
}

