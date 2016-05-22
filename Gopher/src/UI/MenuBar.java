package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

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
		
		JMenuItem mnLink = new JMenuItem("Link 1");
		mnResources.add(mnLink);
	}
	
}
