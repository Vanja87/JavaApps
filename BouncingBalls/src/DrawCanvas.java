import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class DrawCanvas extends JPanel {
	
	private static int currentNumBalls = 10;
	private List<Balls> balls;
	private ContainerBox box;
	int canvasWidth;
	int canvasHeight;
	
	public DrawCanvas(List<Balls> balls, ContainerBox box, int canvasWidth, int canvasHeight) {
		this.balls = balls;
		this.box = box;
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
	}	

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		box.draw(g);
		for (int i = 0; i < currentNumBalls; i++) {
			balls.get(i).draw(g);
		}
	}
	@Override
	public Dimension getPreferredSize() {
		return (new Dimension(canvasWidth, canvasHeight));
	}
}

