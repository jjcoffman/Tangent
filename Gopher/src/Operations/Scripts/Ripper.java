package Operations.Scripts;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Operations.SystemInfo;

public class Ripper extends AbstractAction implements Script
{
	private static Ripper ripper;
	
	private Ripper()
	{
		JFrame ripFrame = new JFrame("Ripper");
		JPanel ripPane = new JPanel();
		ripFrame.add(ripPane);
		
		
		ripFrame.pack();
		ripFrame.setVisible(true);
	}
	
	public Ripper getScript()
	{
		if(ripper == null)
			ripper = new Ripper();
		return ripper;
	}
	
	
	public void actionPerformed(ActionEvent arg0) 
	{
		if(SystemInfo.getInfo().isWindows())
			winRipper();
		else if(SystemInfo.getInfo().isMac())
			MacRipper(); 
		
	}


	private void MacRipper() 
	{
		// TODO Need to run the automator script
		
	}

	private void winRipper() 
	{
		/*  TODO
		 * -popup window with options maybe
		 * -execute based on designated options
		 * -needs to be dynamic and operate based on inputs
		 * -break up each operation as a new class?
		 * 
		 * Diagnostics
		 * chkdsk
		 * scanners
		 * adwareregscanner
		 * policy cleaner
		 * sfc /scannow
		 * dism if win 8 or 10
		 * updates
		 * ninite
		 */
		
	}

}
