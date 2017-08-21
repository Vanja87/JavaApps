import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;


public class BallWorld extends JPanel {
	private static final int UPDATE_RATE = 30;
	private Balls balls1;
	private Balls balls2;
	private Balls balls3;
	private Balls balls4;
	private Balls balls5;
	private Balls balls6;
	private Balls balls7;
	private Balls balls8;
	private Balls balls9;
	private Balls balls10;
	private ContainerBox box;
	boolean paused = false;
	private DrawCanvas canvas;
	private int canvasWidth;
	private int canvasHeight;
	double angleX = 0;
	double angleY = 0;
	double steps;
	float speed;
	
	   

	private ControlPanel control;

	List<Balls> balls = new ArrayList<>();

	public BallWorld(int width, int height) {

		canvasWidth = width;
		canvasHeight = height;
		
		box = new ContainerBox(0, 0, canvasWidth, canvasHeight, Color.BLACK, Color.WHITE);

		balls1 = new Balls(canvasWidth/2, canvasHeight/2, 5, 0, 0, Color.YELLOW);
		balls2 = new Balls(270, 10, 25, 55, 40, Color.BLUE);
		balls3 = new Balls(250, 20, 22, 2, -114, Color.RED);
		balls4 = new Balls(290, 120, 10, 3, 14, Color.GREEN);
		balls5 = new Balls(270, 150, 12, 3, 14, Color.ORANGE);
		balls6 = new Balls(320, 220, 7, 15, 47, Color.PINK);
		balls7 = new Balls(320, 220, 3, 100, 114, Color.CYAN);
		balls8 = new Balls(250, 150, 20, 2, -42, Color.MAGENTA);
		balls9 = new Balls(300, 80, 14, 100, -84, Color.WHITE);
		balls10 = new Balls(300, 210, 6, 4, 34, Color.RED);
		
		balls.add(balls1);
		balls.add(balls2);
		balls.add(balls3);
		balls.add(balls4);
		balls.add(balls5);
		balls.add(balls6);
		balls.add(balls7);
		balls.add(balls8);
		balls.add(balls9);
		balls.add(balls10);
//		
//		float rad = 1;
//		for (int i = 1; i < 11; ++i) {
////	         balls = new Ball(20, CANVAS_HEIGHT - 20, 15, 5, 45, Color.RED);
//			balls1 = new Balls(200, 200, rad, 0, 0, Color.YELLOW);
//			rad += 5;
//			balls.add(balls1);
//	      }
		
		canvas = new DrawCanvas(balls, box, canvasHeight, canvasWidth);
		control = new ControlPanel(balls);

		this.setLayout(new BorderLayout());
		this.add(canvas, BorderLayout.CENTER);
		this.add(control, BorderLayout.SOUTH);
		

		this.addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(ComponentEvent e) {
				Component c = (Component) e.getSource();
				Dimension dim = c.getSize();
				canvasWidth = dim.width;
				canvasHeight = dim.height;

				box.set(0, 0, canvasWidth, canvasHeight);
			}
		});

		gameStart();
	}

	public void gameStart() {
		Thread gameThread = new Thread() {
	         public void run() {
	             while (true) {
	                long beginTimeMillis, timeTakenMillis, timeLeftMillis;
	                beginTimeMillis = System.currentTimeMillis();
	                
	                if (!control.isPaused()) {
	                   // Execute one game step
	                   gameUpdate();
	                   // Refresh the display
	                   repaint();
	                }
	                
	                // Provide the necessary delay to meet the target rate
	                timeTakenMillis = System.currentTimeMillis() - beginTimeMillis;
	                timeLeftMillis = 1000L / UPDATE_RATE - timeTakenMillis;
	                if (timeLeftMillis < 5) timeLeftMillis = 5; // Set a minimum
	                
	                // Delay and give other thread a chance
	                try {
	                   Thread.sleep(timeLeftMillis);
	                } catch (InterruptedException ex) {}
	             }
	          }
		};
		gameThread.start();
	}

	public void gameUpdate() {
		for (Balls ball : balls) {
			if(!ball.getColor().equals(Color.YELLOW)){
			   ball.moveOneStepWithCollisionDetection(box);
			}
		}
	}
}
	                  

		       
		   
		 
	   
		     
	   
	   


	   

