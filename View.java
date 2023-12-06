import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;
// import java.awt.Dimension;
import java.util.ArrayList;
// import java.awt.*;

class View extends JPanel
{
	JButton b1, b2, b3, b4, b5;
	BufferedImage curr_image = null;
	ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
	Model model;
	int scrollX;
	int scrollY;
	static int t;
	Thing Imagesc;


	
	View(Controller c, Model m)
	{

			// Make save button
			b1 = new JButton("Save");
			b1.addActionListener(c);
			this.add(b1);

			// make load button
			b2 = new JButton("Load");
			b2.addActionListener(c);
			this.add(b2);

			b3 = new JButton("Clear");
			b3.addActionListener(c);
			this.add(b3);

			b4 = new JButton("Back");
			b4.addActionListener(c);
			this.add(b4);

		// Link up to other objects
		c.setView(this);
		model = m;



		// Send mouse events to the controller
		this.addMouseListener(c);
		this.addMouseMotionListener(c);

		// Load the images
		try
		{
			for (int i = 0; i < Game.Things.length; i++){
				images.add(ImageIO.read(new File("images/" + Game.Things[i] + ".png")));
			}

		} 
		
		catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}

			curr_image = images.get(0);

	}


	public void paintComponent(Graphics g){
	
		//update counter
		t++;

		// Clear the background
		g.setColor(new Color(119, 236, 154));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		

		// draw model
		for(int i = 0; i <  model.things.size(); i++){
			Imagesc = model.things.get(i);
			g.drawImage(images.get(Imagesc.kind),((Imagesc.getPosition().x) - (images.get(Imagesc.kind).getWidth() / 2) - scrollX), ((Imagesc.getPosition().y) - (images.get(Imagesc.kind).getHeight() / 2) - scrollY), null);
		}

		//purple box
		g.setColor(new Color(180, 12, 255));
		g.fillRect(0,0, 300,300);

		// Draw the image so that its bottom center is at (x,y)
		int w = this.curr_image.getWidth();
		int h = this.curr_image.getHeight();
		g.drawImage(this.curr_image, model.image_x - w / 2, model.image_y - h, null);

	}

}

