package Operations.Links;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.AbstractAction;

import Operations.Execute;
/**
 * This class executes Links for anything. Simply call setURL(String) to set the URL and on an action it will launch a 
 * browser with the required website
 * @author Jonathan Coffman
 */
public class Link extends AbstractAction implements ILink
{

	private static final long serialVersionUID = -4880583250621328535L;
	private String URL = "";

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(!URL.equals(""))
			runCommand();
	}
	
	@Override
	public boolean runCommand() 
	{
		if(System.getProperty("os.name").matches("Mac OS X"))
			return macExec();
		else		
			return winExec();
	}


	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean macExec()
	{


		File file = new File(System.getProperty("user.home") + "/scriptFile.txt");
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
			output.write("/Applications/Safari.app/Contents/MacOS/Safari & sleep 1 && osascript -e 'tell application \"Safari\" to open location \""+ URL + "\"'");
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
		chmod[2] = System.getProperty("user.home") + "/scriptFile.txt";

		Execute.getExecute().exec(chmod);

		String[] run = new String[1];
		run[0] = System.getProperty("user.home") + "/./scriptFile.txt";


		Execute.getExecute().exec(run);
		file.delete();
		return true;

	}
	
	public void setURL(String url)
	{
		URL = url;
	}

	@Override
	public boolean winExec() 
	{
		String[] exec = new String[2];
		exec[0] = "cmd";
		exec[1] = "/c start iexplore \"" + URL + "\"";
		
		System.out.println(URL);
		
		Execute.getExecute().exec(exec);
		return true;
	}

}
