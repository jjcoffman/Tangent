package UI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class ViewPanel extends JPanel
{
	private static final long serialVersionUID = 6230048633623396057L;
	BufferedImage img = null;
	
	public ViewPanel()
	{
		super();
		
		this.setBackground(Color.GRAY);
		this.setSize(320, 400);
		this.setLayout(new BorderLayout(0, 0));
		
		try {
		    img = ImageIO.read(new File("FShow.jpg"));
		} catch (IOException e) {
		}
		JLabel picLabel = new JLabel(new ImageIcon(img));
		picLabel.setBounds(0, 0, 530, 370);
		add(picLabel);
		this.setVisible(true);
	}
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null); // see javadoc for more info on the parameters            
    }
}
