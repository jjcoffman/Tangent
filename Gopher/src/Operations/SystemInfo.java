package Operations;

import java.io.File;

public class SystemInfo 
{
	private static SystemInfo sysInfo;
	private static String separator = null;
	private static String OS = null;
	
	private SystemInfo()
	{
		separator = File.separator;
		OS = "";
	}
	
	public static SystemInfo getInfo()
	{
		if(sysInfo == null)
			sysInfo = new SystemInfo();
		return sysInfo;
	}
	
	public String getName()
	{
		return OS;
	}
	public String getSeparator()
	{
		return separator;
	}
	
}
