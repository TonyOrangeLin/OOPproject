package line;

import java.awt.Graphics;
import java.awt.Graphics2D;

import mainprogram.LocEnum;
import atom.BaseElement;

public class Generalizationline extends LineBase{
	
	public Generalizationline(BaseElement start, BaseElement end, LocEnum startLoc, LocEnum endLoc)
	{
		super(start, end, startLoc, endLoc);		
	}
	
	public void draw(Graphics input)
	{
		super.draw(input);
		
		if (startElement.getLeftX() > endElement.getLeftX())
		{
			int[] arrayX = {destX, destX + 10, destX + 10, destX};  
			int[] arrayY = {destY, destY + 10, destY - 10, destY};  
			input.drawPolyline(arrayX, arrayY, 4);
		}
		if (startElement.getLeftX() < endElement.getLeftX())
		{
			int[] arrayX = {destX, destX - 10, destX - 10, destX};  
			int[] arrayY = {destY, destY + 10, destY - 10, destY};  
			input.drawPolyline(arrayX, arrayY, 4);
		}
		
	
	}
}
