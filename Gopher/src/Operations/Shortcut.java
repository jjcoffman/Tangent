package Operations;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class Shortcut extends AbstractAction
{
	private String[] command;
	
	public Shortcut(String[] cmd)
	{
		command = cmd;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(command != null)
			Execute.getExecute().exec(command);
	}
}
