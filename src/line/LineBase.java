package line;

import java.awt.Graphics;
import java.awt.Graphics2D;

import mainprogram.LocEnum;
import atom.BaseElement;

public class LineBase {
	protected BaseElement startElement;//0=left, 1=up, 2= right , 3= down
	protected BaseElement endElement;//0=left, 1=up, 2= right , 3= down
	protected LocEnum startLocation;
	protected LocEnum endLocation;
	
	public LineBase(BaseElement start, BaseElement end, LocEnum startLoc, LocEnum endLoc)
	{
		startElement = start;
		endElement = end;
		startLocation = startLoc;
		endLocation = endLoc;
		
	}
	
	public void draw(Graphics input)
	{
		int startX = 0;
		int startY = 0;
		int destX = 0;
		int destY = 0;
		if (startLocation == LocEnum.LEFT)
		{
			startX = startElement.getLeftX();
			startY = (startElement.getLeftY() + startElement.getRightY() ) / 2;
		}
		if (startLocation == LocEnum.UP)
		{
			startX = (startElement.getLeftX() + startElement.getRightX()) / 2 ;
			startY = startElement.getLeftY();
		}
		if (startLocation == LocEnum.RIGHT)
		{
			startX = startElement.getRightX();
			startY = (startElement.getLeftY() + startElement.getRightY() ) / 2;
		}
		if (startLocation == LocEnum.DOWN)
		{
			startX = (startElement.getLeftX() + startElement.getRightX()) / 2 ;
			startY = startElement.getRightY();
		}
		
		if (endLocation == LocEnum.LEFT)
		{
			destX = endElement.getLeftX();
			destY = (endElement.getLeftY() + endElement.getRightY() ) / 2;
		}
		if (endLocation == LocEnum.UP)
		{
			destX = (endElement.getLeftX() + endElement.getRightX()) / 2 ;
			destY = endElement.getLeftY();
		}
		if (endLocation == LocEnum.RIGHT)
		{
			destX = (endElement.getLeftX() + endElement.getRightX()) / 2 ;
			destY = endElement.getRightY();
		}
		if (endLocation == LocEnum.DOWN)
		{
			destX = (endElement.getLeftX() + endElement.getRightX()) / 2 ;
			destY = endElement.getRightY();
		}
		input.drawLine(startX, startY, destX, destY);
	
	}

}
