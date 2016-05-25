package Operations;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import javax.swing.AbstractAction;

/**
 * Downloads the Requested File
 * @author Jonathan Coffman
 */
public class Download extends AbstractAction
{
	private static final long serialVersionUID = -88878302525435599L;
	String home = System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop" + System.getProperty("file.separator");
	private String name, url;
	public Download(String nam, String ur)
	{
		name = nam;
		url = ur;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//if the file exists, dont download
		if(!new File(home + name).exists()) 
		{
			try
			{
			System.out.println("Downloading file...");
			URL website;
			website = new URL(url);
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream(new File(home + name + ".exe"));
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
		
	}
}
