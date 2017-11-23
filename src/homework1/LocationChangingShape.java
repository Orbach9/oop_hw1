package homework1;

import java.awt.*;
import java.util.Random;;

/**
 * A LocationChaningShape is a Shape that can change its location using its step()
 * method. A LocationChaningShape has a velocity property that determines the speed
 * of location changing.
 * Thus, a typical LocationChaningShape consists of the following set of
 * properties: {location, color, shape, size, velocity}
 */
public abstract class LocationChangingShape extends Shape implements Animatable {

	private int velocity_x;
	private int velocity_y;
	// TODO (BOM): Write Abstraction Function

    // TODO (BOM): Write Representation Invariant


    /**
     * @effects Initializes this with a a given location and color. Each
     *          of the horizontal and vertical velocities of the new
     *          object is set to a random integral value i such that
     *          -5 <= i <= 5 and i != 0
     */
    LocationChangingShape(Point location, Color color) {
        
    	super(location,color);
    	Random rn = new Random();
    	velocity_x = rn.nextInt(11)-5;
    	velocity_y = rn.nextInt(11)-5;    	
    }


    /**
     * @return the horizontal velocity of this.
     */
    public int getVelocityX() {
        return velocity_x;
    }


    /**
     * @return the vertical velocity of this.
     */
    public int getVelocityY() {
        return velocity_y;
    }


    /**
     * @modifies this
     * @effects Sets the horizontal velocity of this to velocityX and the
     *          vertical velocity of this to velocityY.
     */
    public void setVelocity(int velocityX, int velocityY) {
        velocity_x = velocityX;
        velocity_y = velocityY;
    }


    /**
     * @modifies this
     * @effects Let p = location
     *              v = (vx, vy) = velocity
     *              r = the bounding rectangle of this
     *          If (part of r is outside bound) or (r is within bound but
     *          adding v to p would bring part of r outside bound) {
     *              If adding v to p would move r horizontally farther away
     *              from the center of bound,
     *                  vx = -vx
     *              If adding v to p would move r vertically farther away
     *              from the center of bound,
     *                  vy = -vy
     *          }
     *          p = p + v
     */
    public void step(Rectangle bound) {
        Point curLocation = this.getLocation();
        /*If (part of r is outside bound) or (r is within bound but
     *          adding v to p would bring part of r outside bound) 
         * */
        if ((bound.contains(curLocation.getX(),curLocation.getY()))
        		||(bound.contains(curLocation.getX() + velocity_x,curLocation.getY() + velocity_y))) {
        	/*If adding v to p would move r horizontally farther away
     *              from the center of bound
        	 * */
        	if (Math.abs(bound.getCenterX()-(curLocation.getX() +velocity_x))
        			>Math.abs(bound.getCenterX()-curLocation.getX())) {
        		velocity_x = - velocity_x; 
        	}
        	/*If adding v to p would move r vertically farther away
     *              from the center of bound
        	 * */
        	if (Math.abs(bound.getCenterY()-(curLocation.getY() +velocity_y))
        			>Math.abs(bound.getCenterY()-curLocation.getY())) {
        		velocity_y = - velocity_y; 
        	}
        }
        Point newLoc = new Point((int) (curLocation.getX()+velocity_x), 
        		(int) (curLocation.getY()+velocity_y));
        this.setLocation(newLoc);
    }
    
}
