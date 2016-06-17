package Operations;

import java.io.File;

import javax.swing.JOptionPane;

public class SystemInfo 
{
	private static SystemInfo sysInfo;
	private static String separator = null;
	private static int OS = -1;
	private static int Mac = 1;
	private static int Win = 0;
	
	private SystemInfo()
	{
		separator = File.separator;
		if(System.getProperty("os.name").matches("Windows.*"))
				OS = Win;
		else if(System.getProperty("os.name").matches("Mac OS X"))
			OS = Mac;
		else if(System.getProperty("os.name").matches("Kali Linux")) //TODO
			;
		if(OS == -1)
		{
			JOptionPane.showMessageDialog(null, "Must be operated on a Windows or Mac machine");
			System.exit(-1);
		}
	}
	
	public static SystemInfo getInfo()
	{
		if(sysInfo == null)
			sysInfo = new SystemInfo();
		return sysInfo;
	}
	
	public boolean isWindows()
	{
		if(OS == Win)
			return true;
		return false;
	}
	public boolean isMac()
	{
		if(OS == Mac)
			return true;
		return false;
	}

	public String getSeparator()
	{
		return separator;
	}
	
}
