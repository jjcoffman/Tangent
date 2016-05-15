package UI;

import javax.swing.JFrame;


public class framer extends JFrame
{
	private static framer Framer = null;
	private framer()
	{
		super("SMARMY");
		
		//TODO ADD COMPONENTS
		
		setSize();
		setVisible();
	}
	
	public framer getFramer()
	{
		if(Framer == null)
			Framer = new framer();
		return Framer;
	}
	
	private void setSize()
	{
		//TODO
	}
	
	private void setVisible()
	{
		//TODO
	}
}

private 
