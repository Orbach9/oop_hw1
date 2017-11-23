package homework1;

import java.awt.Dimension;

public class ImpossibleSizeException extends Exception{
	private Dimension fixedDim;
	
	ImpossibleSizeException(Dimension dim){		
		if(dim.getHeight()>0) {
			fixedDim = new Dimension(0,(int)dim.getHeight());
		} else if(dim.getWidth()>0) {
			fixedDim = new Dimension((int)dim.getWidth(),0);
		} else {
			fixedDim = new Dimension(0,0);
		}
	}
	public Dimension getFixedDim() {
		return fixedDim;
	}
	
}
