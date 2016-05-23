package UI;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;

public class SidePane extends JPanel
{
	private static final long serialVersionUID = 3131393817925138721L;

	public SidePane()
	{
		super();
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.add(new JButton("TEST"));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	
	}
	
}
