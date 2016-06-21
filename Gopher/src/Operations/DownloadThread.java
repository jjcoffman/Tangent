package Operations;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadThread extends Thread
{
	String url, filename;
	String home = System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop" + System.getProperty("file.separator");
	DownloadThread(String url, String name)
	{
		this.url = url;
		this.filename = name;
	}
	
	public void run()
	{
		//if the file exists, dont download
				if(!new File(home + filename).exists()) 
				{
					try
					{
					System.out.println("Downloading file...");
					URL website;
					website = new URL(url);
					File file = new File(home + filename);
					
					ReadableByteChannel rbc = Channels.newChannel(website.openStream());
					FileOutputStream fos = new FileOutputStream(file);
					fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
					fos.close();
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					System.out.println("...finished downloading");
				}
				
				//TODO instead of downloading an incomplete file to the desktop, download elsewhere and move when complete
	}
}
