package UI;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import Operations.Scripts.ScriptAction;

import java.awt.Color;
import java.awt.FlowLayout;

public class SidePane extends JPanel
{
	private static final long serialVersionUID = 3131393817925138721L;

	public SidePane()
	{
		super();
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		addButton("Ripper", "---------PATH--------");
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	
	}

	private void addButton(String name, String path) 
	{
		JButton button = new JButton(name);
		ScriptAction action = new ScriptAction(path);
		button.addActionListener(action);
		this.add(button);
		
	}
	
}
