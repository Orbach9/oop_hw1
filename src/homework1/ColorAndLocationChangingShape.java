package homework1;

import java.awt.*;
import java.util.Random;


/**
 * A ColorAndLocationChaningShape is a Shape that can change its location and color using its step()
 * method.
 * Thus, a typical LocationChaningShape consists of the following set of
 * properties: {location, color, shape, size, velocity}
 */
public abstract class LocationAndColorChangingShape extends LocationChangingShape{

    // TODO (BOM): Write Abstraction Function

    // TODO (BOM): Write Representation Invariant


    /**
     * @effects Initializes this with a a given location and color. Each
     *          of the horizontal and vertical velocities of the new
     *          object is set to a random integral value i such that
     *          -5 <= i <= 5 and i != 0
     */
    LocationAndColorChangingShape(Point location, Color color) {
        super(location,color);
    }

    /**
     * @modifies this
     * @effects Changes the location of this as described in the specification
     *          of LocationChangingShape.step(Rectangle bound) &&
	 *			if the velocity of this needs to be changed (as described in LocationChangingShape.step(Rectangle bound)),
	 *			changes the color of this to a new random color;
	 *			else, does not change the color of this.
     */
    public void step(Rectangle bound) {
    	int velocityXBefore = this.getVelocityX();
    	int velocityYBefore = this.getVelocityY();
    	super.step(bound);
        int velocityXAfter = this.getVelocityX();
        int velocityYAfter = this.getVelocityX();
        if ( (velocityXAfter!=velocityXBefore) || (velocityYBefore!=velocityYAfter ) ) {
        	Random rn =  new Random();
        	float r = rn.nextFloat();
        	float g = rn.nextFloat();
        	float b = rn.nextFloat();
        	Color newColor = new Color(r, g, b);
        	this.setColor(newColor);
        }
    }
}
