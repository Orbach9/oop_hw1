package homework1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Color;

public class LocationChangingOval extends LocationChangingShape {
	
	private Rectangle bounds;
	
	public LocationChangingOval(Point location,Color color,Dimension dimension) {
		
		super(location,color);
		bounds = new Rectangle(dimension);
		bounds.setLocation(location);
	}
	
	public void setSize(Dimension dimension) throws ImpossibleSizeException {
		if (dimension.getHeight()<0 || dimension.getWidth()<0) {
			ImpossibleSizeException ex = new ImpossibleSizeException(dimension);
			throw ex;
		}
		bounds.setSize(dimension);
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public void draw(Graphics g) {
		g.setColor(this.getColor());
		g.fillOval((int) this.getLocation().getX(),(int) this.getLocation().getY()
				,(int) bounds.getWidth(),(int) bounds.getHeight());
	}
}
