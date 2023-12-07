import javax.swing.JFrame;
import java.awt.Toolkit;

public class Game extends JFrame
{
	Model model;
	Controller controller;
	View view;
	ViewZero viewZ;
	ViewOne viewO;

	public Game()
	{
		// Instantiate the three main objects
		model = new Model();
		controller = new Controller(model, this);
		view = new View(controller, model);
		viewZ = new ViewZero(controller, model);
		viewO = new ViewOne(controller, model);

		// Set some window properties
		this.setTitle("OH That's a Baseball!!");
		this.setSize(900, 900);
		this.setFocusable(true);
		this.getContentPane().add(viewZ);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(controller);

		
	}
	
	public static final String[] Things = {
				"birdo", 	//0
				"cat",		//1
				"chair", 	//2
				"dog", 	 	//3
				"lamp",  	//4
				"landon",	//5
				"lettuce",	//6
				"mushroom",	//7
				"outhouse",	//8
				"pillar", 	//9
				"pond",	  	//10
				"robot",  	//11
				"rock",   	//12
				"statue", 	//13
				"stockton", //14
				"tree",		//15
				"turtle",	//16
			};

	public static void main(String[] args)
	{
		Game g = new Game();
		g.run();
	}
	
	public void run()
	{
		// Main loop
		while(true)
		{
			controller.update();
			model.update();
			view.repaint(); // Indirectly calls View.paintComponent
			Toolkit.getDefaultToolkit().sync(); // Updates screen

			// Go to sleep for a brief moment
			try
			{
				Thread.sleep(25);
			} catch(Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}
