package line;

import java.awt.Graphics;



import enume.LocEnum;
import atom.BaseElement;

public class LineBase {
	protected BaseElement startElement;//0=left, 1=up, 2= right , 3= down
	protected BaseElement endElement;//0=left, 1=up, 2= right , 3= down
	protected LocEnum startLocation;
	protected LocEnum endLocation;
	protected int startX = 0;
	protected int startY = 0;
	protected int destX = 0;
	protected int destY = 0;
	
	public LineBase(BaseElement start, BaseElement end, LocEnum startLoc, LocEnum endLoc)
	{
		startElement = start;
		endElement = end;
		startLocation = startLoc;
		endLocation = endLoc;
		
	}
	
	public void draw(Graphics input)
	{
		startX = 0;
		startY = 0;
		destX = 0;
		destY = 0;
		int startMiddleX = 0;
		int startMiddleY = 0;
		int destMiddleX = 0;
		int destMiddleY = 0;
		if (startLocation == LocEnum.LEFT)
		{
			startX = startElement.getLeftX();
			startY = (startElement.getLeftY() + startElement.getRightY() ) / 2;
			input.drawLine(startX, startY, startX - (Math.abs( startX + destX) / 2), startY);
			startMiddleX = startX - (Math.abs( startX + destX) / 2);
			startMiddleY = startY;
		}
		if (startLocation == LocEnum.UP)
		{
			startX = (startElement.getLeftX() + startElement.getRightX()) / 2 ;
			startY = startElement.getLeftY();
			input.drawLine(startX, startY, startX, startY - 50);
			startMiddleX = startX;
			startMiddleY = startY - 50;
		}
		if (startLocation == LocEnum.RIGHT)
		{
			startX = startElement.getRightX();
			startY = (startElement.getLeftY() + startElement.getRightY() ) / 2;
			input.drawLine(startX, startY, startX +  (Math.abs( startX + destX) / 2), startY);
			startMiddleX = startX + (Math.abs( startX + destX) / 2);
			startMiddleY = startY;
		}
		if (startLocation == LocEnum.DOWN)
		{
			startX = (startElement.getLeftX() + startElement.getRightX()) / 2 ;
			startY = startElement.getRightY();
			input.drawLine(startX, startY, startX, startY + 50);
			startMiddleX = startX;
			startMiddleY = startY + 50;
		}
		
		
		
		
		if (endLocation == LocEnum.LEFT)
		{
			destX = endElement.getLeftX();
			destY = (endElement.getLeftY() + endElement.getRightY() ) / 2;
			input.drawLine(destX, destY, destX - (Math.abs( startX - destX) / 2), destY);
			destMiddleX = destX - (Math.abs( startX - destX) / 2);
			destMiddleY = destY;
		}
		if (endLocation == LocEnum.UP)
		{
			destX = (endElement.getLeftX() + endElement.getRightX()) / 2 ;
			destY = endElement.getLeftY();
			input.drawLine(destX, destY, destX, destY - 50);
			destMiddleX = destX;
			destMiddleY = destY - 50;
		}
		if (endLocation == LocEnum.RIGHT)
		{
			destX = endElement.getRightX() ;
			destY =  (endElement.getLeftY() + endElement.getRightY() ) / 2;
			input.drawLine(destX, destY, destX + (Math.abs( startX - destX) / 2), destY);
			destMiddleX = destX + (Math.abs( startX - destX) / 2);
			destMiddleY = destY;
		}
		if (endLocation == LocEnum.DOWN)
		{
			destX = (endElement.getLeftX() + endElement.getRightX()) / 2 ;
			destY = endElement.getRightY();
			input.drawLine(destX, destY, destX, destY + 50);
			destMiddleX = destX;
			destMiddleY = destY + 50;
		}
		
		if (startLocation == LocEnum.RIGHT && endLocation == LocEnum.LEFT)
		{
			input.drawLine(startMiddleX, startMiddleY, destMiddleX, destMiddleY);
		}
		else if (startLocation == LocEnum.LEFT && endLocation == LocEnum.RIGHT)
		{
			input.drawLine(startMiddleX, startMiddleY, destMiddleX, destMiddleY);
		}
		else if (startLocation == LocEnum.UP && endLocation == LocEnum.DOWN)
		{
			input.drawLine(startMiddleX, startMiddleY, destMiddleX, destMiddleY);
		}
		else if (startLocation == LocEnum.DOWN && endLocation == LocEnum.UP)
		{
			input.drawLine(startMiddleX, startMiddleY, destMiddleX, destMiddleY);
		}
		else
		{
			input.drawLine(startMiddleX, startMiddleY, destMiddleX, destMiddleY);
		}
	}

}
