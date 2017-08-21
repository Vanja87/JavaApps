import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControlPanel extends JPanel {
	
	// Balls
	private static final double MAX_BALLS = 10; // Max number allowed
	private boolean paused = false;
	 double angleX = 0;
	 double angleY = 0;
	 double steps = 50;

	/** Constructor to initialize UI components */
    public ControlPanel(List<Balls> balls) {
       // A checkbox to toggle pause/resume all the balls' movement
       JCheckBox pauseControl = new JCheckBox();
       this.add(new JLabel("Pause"));
       this.add(pauseControl);
       pauseControl.addItemListener(new ItemListener() {
          @Override
          public void itemStateChanged(ItemEvent e) {
             paused = !paused;  // Toggle pause/resume flag
          }
       });

       // A slider for adjusting the speed of all the balls by a factor
        double angleX = new double[MAX_BALLS];
        double angleY = new double[MAX_BALLS];
       for (int i = 0; i < MAX_BALLS; ++i) {
          angleX = balls.get(i).getSpeedX();
          angleY = balls.get(i).getSpeedY();
       }
       int minFactor = 5;    // percent
       int maxFactor = 400;  // percent
       JSlider speedControl = new JSlider(JSlider.HORIZONTAL, minFactor, maxFactor, 100);
       this.add(new JLabel("Speed"));
       this.add(speedControl);
       speedControl.addChangeListener(new ChangeListener() {
          @Override
          public void stateChanged(ChangeEvent e) {
             JSlider source = (JSlider)e.getSource();
             if (!source.getValueIsAdjusting()) {
                int percentage = (int)source.getValue();
                for (int i = 0; i < MAX_BALLS; ++i) {
                   
				   balls.get(i).setSpeedX(angleX * percentage / 100.0f);
                   balls.get(i).setSpeedY(angleY * percentage / 100.0f);
                }
             }
          }
       });  
    }

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}
 }
