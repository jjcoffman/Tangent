package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import Operations.Download;
import Operations.Shortcut;
import Operations.SystemInfo;
import Operations.Links.Link;

/**
 * This builds the menubar that will display all the tools used
 * @author Jonathan Coffman
 *
 */
public class MenuBar extends JMenuBar
{
	private static final long serialVersionUID = 3259550375369862849L;
	JMenu mnFile = new JMenu("File");
	JMenuItem mntmAbout = new JMenuItem("About");
	JSeparator separator = new JSeparator();
	JMenuItem mntmSetPreferences = new JMenuItem("Preferences..");
	JMenuItem mntmQuit = new JMenuItem("Quit");
	JMenu mnTools = new JMenu("Tools");
	JMenu mnScripts = new JMenu("Scripts");
	JMenu mnResources = new JMenu("Resources");
	JMenu mnShortcuts = new JMenu("Shortcuts");
	
	public MenuBar()
	{
		super();
		
		this.add(mnFile);
	
		
		mnFile.add(mntmAbout);
		mnFile.add(separator);
		mnFile.add(mntmSetPreferences);
		
		mnFile.add(separator);
		
		mntmQuit.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e) {System.exit(0);}});
		mnFile.add(mntmQuit);
		
		this.add(mnTools);
		this.add(mnScripts);

		
		this.add(mnResources);
		
		
		if(SystemInfo.getInfo().isWindows())
			winAdd();
		if(SystemInfo.getInfo().isMac())
			macAdd();
		
	}
	
	private void macAdd() 
	{
		// TODO Auto-generated method stub
		addMenuDownloadItem("MBAM", "https://store.malwarebytes.org/342/purl-mbamm-dl", mnTools, "mbam.dmg");
		
		//Add Onyx
		JMenu mnOnyx = new JMenu("Onyx");
		mnTools.add(mnOnyx);
		addMenuDownloadItem("10.11", "http://joel.barriere.pagesperso-orange.fr/download/1011/OnyX.dmg", mnOnyx, "Onyx.dmg");
		addMenuDownloadItem("10.10", "http://www.titanium.free.fr/download/1010/OnyX.dmg", mnOnyx, "Onyx.dmg");
		addMenuDownloadItem("10.9", "http://www.titanium.free.fr/download/109/OnyX.dmg", mnOnyx, "Onyx.dmg");
		addMenuDownloadItem("10.8", "http://www.titanium.free.fr/download/108/OnyX.dmg", mnOnyx, "Onyx.dmg");
		addMenuDownloadItem("10.7", "http://www.titanium.free.fr/download/107/OnyX.dmg", mnOnyx, "Onyx.dmg");
		
		addMenuDownloadItem("CCleaner", "https://download.piriform.com/mac/CCMacSetup112.dmg", mnTools, "CCMacSetup112.dmg");
		

		addMenuLinkItem("Kaspersky Threat Map", "https://cybermap.kaspersky.com/", mnResources);
		addMenuLinkItem("Norse Attack Map", "http://map.norsecorp.com", mnResources);
		
	}

	private void winAdd() 
	{
		
		JMenu mnMalware = new JMenu("Malware");
		mnTools.add(mnMalware);
		addMenuDownloadItem("MBAM", "https://downloads.malwarebytes.org/file/mbam_current/", mnMalware, "mbam.exe");
		addMenuDownloadItem("MBAR", "https://downloads.malwarebytes.org/file/mbar/", mnMalware, "mbar.zip");
		addMenuDownloadItem("NPE", "https://liveupdate.symantec.com/upgrade/NPE/1033/NPE.exe", mnMalware, "nrt.zip");
		
		
		addMenuDownloadItem("CCleaner", "http://download.piriform.com/ccsetup518.exe", mnTools, "ccsetup518.exe");
		
		
		this.add(mnShortcuts);
		AddShortcut("Control Panel" , new String[]{"control.exe"});
		AddShortcut("System Info" , new String[]{"msinfo32"});
		AddShortcut("Device Manager" , new String[]{"cmd", "/c devmgmt"});
		if(!System.getProperty("os.name").matches("Windows 10"))
			AddShortcut("Windows Update" , new String[]{"wuapp"});
		else if(System.getProperty("os.name").matches("Windows 10"))
			AddShortcut("Windows Update" , new String[]{"explorer.exe", "ms-settings:windowsupdate"});
		AddShortcut("Task Manager" , new String[]{"taskmgr"});
		AddShortcut("Event Viewer" , new String[]{"eventvwr"});
		AddShortcut("Internet Options" , new String[]{"cmd", "/c inetcpl.cpl"});
		AddShortcut("Services", new String[]{"cmd", "/c services.msc"});
		AddShortcut("MSConfig", new String[]{"cmd", "/c msconfig"});
		AddShortcut("System Restore", new String[]{"cmd", "/c rstrui.exe"});
		
		AddShortcut("Restart" , new String[]{"shutdown", "-r", "-t", "00"});		
		AddShortcut("Shutdown" , new String[]{"shutdown", "-s", "-t", "00"});
		
		addMenuLinkItem("ninite", "https://ninite.com/", mnResources);
		addMenuLinkItem("Kaspersky", "https://cybermap.kaspersky.com/", mnResources);
		addMenuLinkItem("Norse Attack Map", "http://map.norsecorp.com/", mnResources);
		addMenuLinkItem("Win10 Media", "http://www.microsoft.com/en-us/software-download/windows10", mnResources);
		addMenuLinkItem("Win8 Media", "http://www.microsoft.com/en-us/software-download/windows8", mnResources);
	}

	private void AddShortcut(String name, String[] cmd) 
	{
		JMenuItem item = new JMenuItem(name);
		item.addActionListener(new Shortcut(cmd));
		mnShortcuts.add(item);
		
	}

	/**
	 * this adds a menu item with is respective name and to the respective menu
	 * @param name
	 * @param url
	 * @param menu
	 */
	private void addMenuDownloadItem(String name, String url, JMenu menu, String downloadName) 
	{
		JMenuItem item = new JMenuItem(name);
		Download down = new Download(downloadName, url);
		item.addActionListener(down);
		menu.add(item);
		
	}

	/**
	 * this adds Link items to the resources menu
	 * @param name
	 * @param url
	 * @param menu
	 */
	public void addMenuLinkItem(String name, String url, JMenu menu)
	{
		JMenuItem item = new JMenuItem(name);
		Link link = new Link();
		link.setURL(url);
		item.addActionListener(link);
		menu.add(item);
		
	}
	
}
