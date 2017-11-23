package homework1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class LocationChangingOval extends LocationChangingShape {
	
	private Rectangle bounds;
	
	public LocationChangingOval(Point location,Color color,Dimension dimension) {
		
		super(location,color);
		bounds = new Rectangle(dimension);
		bounds.setLocation(location);
	}
	
	public void setSize(Dimension dimension) {
		
	}
	
	public Rectangle getBounds() {
		
	}
	
	public void draw(Graphics g) {
		
	}

}
