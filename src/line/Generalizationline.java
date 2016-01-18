package line;

import java.awt.Graphics;
import java.awt.Graphics2D;

import atom.BaseElement;

public class Generalizationline extends LineBase{
	
	public Generalizationline(int start, int end, int startLoc, int endLoc)
	{
		super(start, end, startLoc, endLoc);		
	}
	
	public void draw(Graphics input, BaseElement start, BaseElement dest)
	{
		super.draw(input, start, dest);
		
		if (start.getLeftX() > dest.getLeftX())
		{
			int[] arrayX = {destX, destX + 10, destX + 10, destX};  
			int[] arrayY = {destY, destY + 10, destY - 10, destY};  
			input.drawPolyline(arrayX, arrayY, 4);
		}
		if (start.getLeftX() < dest.getLeftX())
		{
			int[] arrayX = {destX, destX - 10, destX - 10, destX};  
			int[] arrayY = {destY, destY + 10, destY - 10, destY};  
			input.drawPolyline(arrayX, arrayY, 4);
		}
		
	
	}
}
