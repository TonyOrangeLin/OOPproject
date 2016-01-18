package line;

import java.awt.Graphics;
import java.awt.Graphics2D;

import atom.BaseElement;

public class LineBase {
	protected int destElementIndex;
	protected int startElementIndex;
	protected BaseElement startElement;//0=left, 1=up, 2= right , 3= down
	protected BaseElement endElement;//0=left, 1=up, 2= right , 3= down
	
	public LineBase(int start, int end, BaseElement startLoc, BaseElement endLoc)
	{
		destElementIndex = end;
		startElementIndex = start;
		startLocation = startLoc;
		endLocation = endLoc;
		
	}
	
	public void draw(Graphics input)
	{
		int startX = 0;
		int startY = 0;
		int destX = 0;
		int destY = 0;
		if (startLocation == 0)
		{
			startX = start.getLeftX();
			startY = (start.getLeftY() + start.getRightY() ) / 2;
		}
		if (startLocation == 1)
		{
			startX = (start.getLeftX() + start.getRightX()) / 2 ;
			startY = start.getLeftY();
		}
		if (startLocation == 2)
		{
			startX = start.getRightX();
			startY = (start.getLeftY() + start.getRightY() ) / 2;
		}
		if (startLocation == 3)
		{
			startX = (start.getLeftX() + start.getRightX()) / 2 ;
			startY = start.getRightY();
		}
		
		if (endLocation == 0)
		{
			destX = dest.getLeftX();
			destY = (dest.getLeftY() + dest.getRightY() ) / 2;
		}
		if (endLocation == 1)
		{
			destX = (dest.getLeftX() + dest.getRightX()) / 2 ;
			destY = dest.getLeftY();
		}
		if (endLocation == 2)
		{
			destX = (dest.getLeftX() + dest.getRightX()) / 2 ;
			destY = dest.getRightY();
		}
		if (endLocation == 3)
		{
			destX = (dest.getLeftX() + dest.getRightX()) / 2 ;
			destY = dest.getRightY();
		}
		input.drawLine(startX, startY, destX, destY);
	
	}

	public int getDestElementIndex() {
		return destElementIndex;
	}

	public void setDestElementIndex(int destElementIndex) {
		this.destElementIndex = destElementIndex;
	}

	public int getStartElementIndex() {
		return startElementIndex;
	}

	public void setStartElementIndex(int startElementIndex) {
		this.startElementIndex = startElementIndex;
	}

	public int getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(int startLocation) {
		this.startLocation = startLocation;
	}

	public int getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(int endLocation) {
		this.endLocation = endLocation;
	}


}
