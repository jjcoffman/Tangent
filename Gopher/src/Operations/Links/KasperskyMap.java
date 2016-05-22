package Operations.Links;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import javax.swing.AbstractAction;
import Operations.Execute;

public class KasperskyMap extends AbstractAction implements Link
{
	private static final long serialVersionUID = 2880456018698358489L;
	private static final String url = "https://cybermap.kaspersky.com/";

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		runCommand();
	}

	@Override
	public boolean runCommand() 
	{
		//if(System.getProperty("os.name").matches("Mac OS"))
			return macExec();
		//else		
			//return winExec();
	}


	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean macExec()
	{


		File file = new File(System.getProperty("user.home") + "/Desktop/scriptFile.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//use buffering
		Writer output = null;
		try {
			output = new BufferedWriter(new FileWriter(file));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			//FileWriter always assumes default encoding is OK!
			output.write("/Applications/Safari.app/Contents/MacOS/Safari & sleep 1 && osascript -e 'tell application \"Safari\" to open location \"https://cybermap.kaspersky.com/\"'");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String[] chmod = new String[3];
		chmod[0] = "chmod";
		chmod[1] = "+x";
		chmod[2] = System.getProperty("user.home") + "/Desktop/scriptFile.txt";

		Execute.getExecute().exec(chmod);

		String[] run = new String[1];
		run[0] = System.getProperty("user.home") + "/Desktop/./scriptFile.txt";


		Execute.getExecute().exec(run);
		return true;

	}

	@Override
	public boolean winExec() 
	{
		//start cmd.exe @cmd /k "Command"
		String separator = System.getProperty("file.separator");
		String[] exec = new String[2];
		exec[0] = "iexplore.exe";
		exec[1] = "https://cybermap.kaspersky.com/";
		
		Execute.getExecute().exec(exec);
		return true;
	}

}
