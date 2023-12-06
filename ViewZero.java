import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
// import java.awt.image.BufferedImage;
// import javax.imageio.ImageIO;
// import java.io.File;
// import java.util.ArrayList;
// import java.awt.*;

class ViewZero extends JPanel
{
	JButton b0, b1;
	// BufferedImage curr_image = null;
	// ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
	Model model;
	int scrollX;
	int scrollY;
	static int t;


	
	ViewZero(Controller c, Model m)
	{
		// level edirot button
		b0 = new JButton("Level Editor");
		b0.addActionListener(c);
		b0.setPreferredSize(new Dimension(500, 150));
		this.add(b0);

        // level selector button
        b1 = new JButton("Level Selector");
        b1.addActionListener(c);
        b1.setPreferredSize(new Dimension(500, 150));
        this.add(b1);

		// Link up to other objects
		c.setViewZero(this);
		model = m;

		// Send mouse events to the controller
		this.addMouseListener(c);
		this.addMouseMotionListener(c);
	}


	public void paintComponent(Graphics g){
	

		// Clear the background
		g.setColor(new Color(51, 0, 102));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());


	}

}

