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
	
	private String name, url;
	public Download(String nam, String ur)
	{
		name = nam;
		url = ur;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		DownloadThread thread = new DownloadThread(url, name);
		new Thread(thread).start();
		
	}
}
