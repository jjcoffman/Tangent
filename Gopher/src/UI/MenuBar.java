package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import Operations.Download;
import Operations.Links.Link;

/**
 * This builds the menubar that will display all the tools used
 * @author Jonathan Coffman
 *
 */
public class MenuBar extends JMenuBar
{
	private static final long serialVersionUID = 3259550375369862849L;

	public MenuBar()
	{
		super();
		
		JMenu mnFile = new JMenu("File");
		this.add(mnFile);
	
		JMenuItem mntmAbout = new JMenuItem("About");
		mnFile.add(mntmAbout);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmSetPreferences = new JMenuItem("Set Preferences..");
		mnFile.add(mntmSetPreferences);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e) {System.exit(0);}});
		mnFile.add(mntmQuit);
		
		JMenu mnTools = new JMenu("Tools");
		this.add(mnTools);
		
		JMenu mnMalware = new JMenu("Malware");
		addMenuDownloadItem("MBAM", "https://downloads.malwarebytes.org/file/mbam_current/", mnMalware);
		mnTools.add(mnMalware);
		
		JMenu mnWindows = new JMenu("Windows");
		mnTools.add(mnWindows);
		
		JMenu mnMacOs = new JMenu("Mac OS");
		mnTools.add(mnMacOs);
		
		JMenu mnScripts = new JMenu("Scripts");
		this.add(mnScripts);
		
		JMenu mnWindows_1 = new JMenu("Windows");
		mnScripts.add(mnWindows_1);
		
		JMenu mnMac = new JMenu("Mac");
		mnScripts.add(mnMac);
		
		JMenuItem rds = new JMenuItem("RDS");
		mnWindows_1.add(rds);
		
		JMenu mnResources = new JMenu("Resources");
		this.add(mnResources);
		
		addMenuLinkItem("Kaspersky", "https://cybermap.kaspersky.com/", mnResources);
		addMenuLinkItem("Norse Attack Map", "http://map.norsecorp.com", mnResources);
	}
	
	/**
	 * this adds a menu item with is respective name and to the respective menu
	 * @param name
	 * @param url
	 * @param menu
	 */
	private void addMenuDownloadItem(String name, String url, JMenu menu) 
	{
		JMenuItem item = new JMenuItem(name);
		Download down = new Download(name, url);
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
