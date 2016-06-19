package Operations.Scripts;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Operations.SystemInfo;

public class Ripper extends AbstractAction
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
	
	public static Ripper getRipper()
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
			macRipper();
		
	}

	private void macRipper() 
	{
		/*  TODO
		 * -Need to workout diagnostics
		 * -Diskutil repair (can be done during onyx probably)
		 * -mbam
		 * -onyx
		 * 
		 */
		
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
