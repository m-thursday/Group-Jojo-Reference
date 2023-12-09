import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

class ViewOne extends JPanel
{
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20,
    lb0, lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11, lb12, lb13, lb14, lb15, lb16, lb17, lb18, lb19;

    JButton[] buttons = new JButton[]{b0, b1, b2, b3, b4, b5, b6, b7, b8, b9,
    b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20};

    JButton[] loadButtons = new JButton[]{lb0, lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9,
        lb10, lb11, lb12, lb13, lb14, lb15, lb16, lb17, lb18, lb19, b20};

    Model model;


	ViewOne(Controller c, Model m)
	{
        
        for (int i = 0; i < loadButtons.length - 1; i++){
            loadButtons[i] = new JButton("Level " + (i+1));
            loadButtons[i].addActionListener(c);
            loadButtons[i].setPreferredSize(new Dimension(150,150));
            loadButtons[i].setFont(new Font("", Font.BOLD, 20));
            this.add(loadButtons[i]);
        }

            b20 = new JButton("Back");
            b20.addActionListener(c);
            b20.setPreferredSize(new Dimension(150,150));
            b20.setFont(new Font("", Font.BOLD, 20));
            this.add(b20);


		// Link up to other objects
		c.setViewOne(this);
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

