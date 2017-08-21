import java.awt.*;
import java.sql.Time;
import java.util.Formatter;


public class Balls {
	   float x, y;
	   double speedX, speedY; 
	   float radius; 
	   float speed;
	   private Color color; 
	   private static final Color DEFAULT_COLOR = Color.BLUE;
	   private double theta;
	   double angleX = 0;
	   double angleY = 0;
	   double steps = 50;
	   
	   
	  
	   public double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}

	public double getSpeedY() {
		return speedY;
	}

	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}

	public Balls(float x, float y, float radius, float speed, float angleInDegree,
		         Color color){
		      this.x = x;
		      this.y = y;
		      
		      
		    
		      this.speedX = (float)(speed * Math.cos(Math.toRadians(angleX)));
		      this.speedY = (float)(speed * (float)Math.sin(Math.toRadians(angleY)));
		      this.radius = radius;
		      this.color = color;
		   }
	  
//	   public Balls(float x, float y, float radius, float speed, float angleInDegree, Color color ) {
//		      this(x, y, radius, speed, angleInDegree, DEFAULT_COLOR);
//		   }
	   
	   public void draw(Graphics g) {
		      g.setColor(color);
		      g.fillOval((int)(x - radius), (int)(y - radius), (int)(2 * radius), (int)(2 * radius));
		   }
	   
	   public void moveOneStepWithCollisionDetection(ContainerBox box) {
		      
		     
		      sine();
		      cosine();
		      
		      
//		      theta = theta + Math.toRadians(10);
//		      x = (float) (x + radius*Math.cos(theta));
//		      y = (float) (y + radius*Math.sin(theta));
		      
		      
//		      x += speedX;
//		      y += speedY;
//		      
//		      if (x < ballMinX) {
//		          speedX = -speedX; 
//		          x = ballMinX;     
//		       } else if (x > ballMaxX) {
//		          speedX = -speedX;
//		          x = ballMaxX;
//		       }
//		       
//		       if (y < ballMinY) {
//		          speedY = -speedY;
//		          y = ballMinY;
//		       } else if (y > ballMaxY) {
//		          speedY = -speedY;
//		          y = ballMaxY;
//		       }
//		    }
	   }
	   
	public void sine(){ 
           angleY += (2*Math.PI/steps);
           y += radius*Math.sin(angleY); 
    }
    public void cosine(){
           angleX += (2*Math.PI/steps);
           x += radius*Math.sin(angleX+Math.PI/2);
           
    }

	   public float getSpeed() {
		   	  return (float)Math.sqrt(speedX * speedX + speedY * speedY);
 }
	   
	   public float getMoveAngle() {
		      return (float)Math.toDegrees(Math.atan2(-speedY, speedX));
		   }

//	   public float getMass() {
//		      return radius * radius * radius / 1000f;  
//		   }
	   public Color getColor() {
		return color;
	}
}

	   
//	   public float getKineticEnergy() {
//		      return 0.5f * getMass() * (speedX * speedX + speedY * speedY);
//		   }
	   
//	   public String toString() {
//		      sb.delete(0, sb.length());
//		      formatter.format("@(%3.0f,%3.0f) r=%3.0f V=(%2.0f,%2.0f) " +
//		            "S=%4.1f \u0398=%4.0f KE=%3.0f", 
//		            x, y, radius, speedX, speedY, getSpeed(), getMoveAngle(),
//		            getKineticEnergy());  // \u0398 is theta
//		      return sb.toString();
//		   }
//	   
//	   private StringBuilder sb = new StringBuilder();
//	   private Formatter formatter = new Formatter(sb);
//	}




