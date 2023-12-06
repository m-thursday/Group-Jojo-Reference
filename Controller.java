import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionListener;
// import java.awt.MouseInfo;
// import java.awt.Point;
// import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.lang.Math;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
// import java.awt.MouseInfo;
// import java.awt.Point;
// import java.awt.Robot;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import java.awt.*;

import javax.swing.JOptionPane;

class Controller implements ActionListener, MouseListener, KeyListener, MouseMotionListener
{
	View view;
	ViewZero viewZ;
	ViewOne viewO;
	Model model;
	Game g;
	boolean keyLeft;
	boolean keyRight;
	boolean keyUp;
	boolean keyDown;
	int margin = 100;
	int scroll = 5;
	Object[] ClearOptions = { "Yes", "No", "Um what?" };
	Object[] Options = { "Yes", "No" };

	// void Game (Game g){
	// 	game = g;
	// }

	Controller(Model m, Game game)
	{
		model = m;
		g = game;
	}

	void setView(View v)
	{
		view = v;
	}

	void setViewZero(ViewZero vz){
		viewZ = vz;
	}

	void setViewOne(ViewOne vo){
		viewO = vo;
	}

	void changeView(){
		g.getContentPane().removeAll();
		g.getContentPane().add(view);
		g.getContentPane().revalidate();
		g.getContentPane().repaint();		
}
void changeViewZ(){
	g.getContentPane().removeAll();
	g.getContentPane().add(viewZ);
	g.getContentPane().revalidate();
	g.getContentPane().repaint();
}

void changeViewO(){
	g.getContentPane().removeAll();
	g.getContentPane().add(viewO);
	g.getContentPane().revalidate();
	g.getContentPane().repaint();
}
void print(String s){
	System.out.println(s);
}

	// button events
	public void actionPerformed(ActionEvent e)
	{
		print("something is being pressed");
		// View One buttons

		// Level Selector Back Button
		if (e.getSource() == viewO.b20){
			print("button clicked");
			changeViewZ();
		}
		// Level 1 save
		else if (e.getSource() == viewO.b0){
			print("button clicked");
			model.save("level_1.json");
		}
		// Level 1 load
		else if (e.getSource() == viewO.lb0){
			print("button clicked");
			changeView();
			model.load("level_1.json");
		}

		// View Zero Buttons

		// Level Editor Button
		if (e.getSource() == viewZ.b0){
			changeView();
		}
		// Level Selector Button
		else if (e.getSource() == viewZ.b1){
			changeViewO();
		}

		// set up load and save later
		if (e.getSource() == view.b1){
			
			JFrame savePage = new JFrame();
			savePage.setTitle("The Crazy Diamond Application");
			savePage.setLayout(new GridLayout(10,2));
			savePage.setSize(300, 450);
			savePage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			savePage.setVisible(true);
            for (int j = 0; j < 20; j++){
                viewO.buttons[j] = new JButton("Level " + (j+1));
                viewO.buttons[j].setPreferredSize(new Dimension(150,150));
                viewO.buttons[j].addActionListener(this);
				print("action listener is being called");
                savePage.add(viewO.buttons[j]);
             }


			// model.save("map.json");
		}
		// Load Button
		if (e.getSource() == view.b2){
			model.load("map.json");
			System.out.println("that sh*t back, but how?");
			view.repaint();
		}
		else if (e.getSource() == view.b3){
			System.out.println("that sh*t gone fr fr");
			int ClearChoice = JOptionPane.showOptionDialog(null, "Are you sure you want to ZA HANDO?","OI JOSUKE", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, ClearOptions,  ClearOptions[0]);
			if(ClearChoice == 0){
				for (int i = model.things.size() - 1; i >= 0; i--){
				model.removeThing(i);
				view.repaint();
			}
				JOptionPane.showMessageDialog(null, "Level Cleared.");
			}
			if(ClearChoice == 2){
				JOptionPane.showMessageDialog(null, "The Hand (ザ・ハンド（手） Za Hando) is the Stand of Okuyasu Nijimura, featured in Diamond is Unbreakable.");
				JOptionPane.showMessageDialog(null,"The Hand appears as a humanoid figure typically in attire similar to football pads, though it has several spikes jutting from them.");
				JOptionPane.showMessageDialog(null,"A towel-like object drapes over its shoulders, with a $ symbol on one end and a ¥ symbol on the other - corresponding with Okuyasu's own fashion theme of currency symbols.");
				JOptionPane.showMessageDialog(null, "On each side of the Stand's face are blinders that cover its headlight-shaped eyes and limit its vision, a result of Okuyasu's own impulsive demeanor.");
				JOptionPane.showMessageDialog(null,"Its right hand has spiderweb-like lines on the inside, along with two bumps on its palm. However, these features on its right hand were not shown until later chapters.");
				JOptionPane.showMessageDialog(null,"The Hand is generally portrayed as being white and wearing blue armor with golden decorations.");
				JOptionPane.showMessageDialog(null,"Anything The Hand's right palm touches when it does a swiping motion with its arm is erased from this universe, be it physical matters or space itself.");
				JOptionPane.showMessageDialog(null,"Thanks for reading some epic lore!!!!!!!! >.>");
			}
			
			
		}
		else if(e.getSource() == view.b4){
			int BackChoice = JOptionPane.showOptionDialog(null, "Are you sure you want stop time and go back to the menu?","ZA WARUDO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, Options,  Options[0]);
			if(BackChoice == 0){
				g.getContentPane().removeAll();
				g.getContentPane().add(viewZ);
				g.getContentPane().revalidate();
				g.getContentPane().repaint();
				for (int i = model.things.size() - 1; i >= 0; i--){
					model.removeThing(i);
			}
			}
			
		}
	}


	public void mouseMoved(MouseEvent e){

		// int Xbox = view.getWidth()/2 - 150;
		// int Ybox = 0;
		// int Wbox = 300;
		// int Hbox = 110;
		// Point p = MouseInfo.getPointerInfo().getLocation();
		// // purple box exclusion
		// if ((e.getX() <= 300) && (e.getY() <= 300)){
			
		// }
		// else if (((e.getX() >= Xbox) && (e.getX() <= (Xbox + Wbox))) && ((e.getY() >= Ybox) && (e.getY() <= (Ybox + Hbox)))){

		// }
		
		// else{
		// try{
		// if (p.x >= (view.getWidth() - margin)){ // scrolling right
		// 	Robot MrRoboto = new Robot();

		// 	MrRoboto.mouseMove(view.getWidth() - margin, p.y);
		// 	view.scrollX += scroll;
			
		// }
		// else if (p.x <= margin){ // scrolling left
		// 	Robot MrRobotojr = new Robot();

		// 	MrRobotojr.mouseMove(margin, p.y);
		// 	view.scrollX -= scroll;
			
		// }
		// else if (p.y >= (view.getHeight() - margin )){ // scroll down
		// 	Robot MrRobotoIII = new Robot();

		// 	MrRobotoIII.mouseMove(p.x, view.getHeight() - margin);
		// 	view.scrollY += scroll;
		// }
		// else if (p.y <= margin){ // scroll up
		// 	Robot MrRobotoIV = new Robot();
		// 	MrRobotoIV.mouseMove(p.x, margin);
		// 	view.scrollY -= scroll;
		// }
		// }
	
		// catch (Exception ex){
		// 	ex.printStackTrace(System.err);
		// 	System.exit(1);
		// }
		// }
		}


	public void mousePressed(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();
		
		int currInd = view.images.indexOf(view.curr_image);

        // Check if the click happened within the purple box
        if ((x<300) && (y<300)) {
            // Rotate to the next image in the ArrayList
            currInd = (currInd + 1) % view.images.size();
            view.curr_image = view.images.get(currInd);
            view.repaint();
        }

        else {
            if (e.getButton() == 1) {
				model.addThing(x + view.scrollX, y + view.scrollY, currInd);
            	view.repaint();
			}
			if (e.getButton() == 3) {

				int x1 = e.getX() + view.scrollX;
				int y1 = e.getY() + view.scrollY;
				int minInd = 0;
				double min = Double.MAX_VALUE;
				double temp;
				int w = view.curr_image.getWidth();
				int h = view.curr_image.getHeight();
				int x2 = 0;
				int y2 = 0;

				for (int l = 0; l < model.things.size(); l++) {
					x2 = model.things.get(l).x - w/2;
					y2 = model.things.get(l).y - h/2;

					temp = Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));
					if (temp < min) {
						min = temp;
						minInd = l;
					}
				}
				model.removeThing(minInd);
			}
        }
    }

	public void mouseReleased(MouseEvent e) { 
	}
	
	public void mouseEntered(MouseEvent e) {
	}
	
	public void mouseExited(MouseEvent e) {
	}
	
	public void mouseClicked(MouseEvent e) {
	}
	
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_RIGHT: 
				keyRight = true; 
				view.scrollX += 8;
				break;
			case KeyEvent.VK_LEFT: 
				keyLeft = true;
				view.scrollX -= 8;
				break;
			case KeyEvent.VK_UP: 
				keyUp = true; 
				view.scrollY -= 8;
				break;
			case KeyEvent.VK_DOWN: 
				keyDown = true; 
				view.scrollY += 8;
				break;
			case KeyEvent.VK_D: 
				keyRight = true; 
				view.scrollX += 8;
				break;
			case KeyEvent.VK_A: 
				keyLeft = true;
				view.scrollX -= 8;
				break;
			case KeyEvent.VK_W: 
				keyUp = true; 
				view.scrollY -= 8;
				break;
			case KeyEvent.VK_S: 
				keyDown = true; 
				view.scrollY += 8;
				break;			
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode()) {
			case KeyEvent.VK_RIGHT: 
				keyRight = false; 
				break;
			case KeyEvent.VK_LEFT:
				keyLeft = false; 
				break;
			case KeyEvent.VK_UP: 
				keyUp = false; 
				break;
			case KeyEvent.VK_DOWN: 
				keyDown = false; 
				break;
			case KeyEvent.VK_D: 
				keyRight = false; 
				break;
			case KeyEvent.VK_A: 
				keyLeft = false;
				break;
			case KeyEvent.VK_W: 
				keyUp = false; 
				break;
			case KeyEvent.VK_S: 
				keyDown = false; 
				break;	
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
		}
		char c = Character.toLowerCase(e.getKeyChar());
		if(c == 'q')
			System.exit(0);
        if(c == 'r')
            model.reset();
	}

	public void keyTyped(KeyEvent e) {
	}

	void update() {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}
}
