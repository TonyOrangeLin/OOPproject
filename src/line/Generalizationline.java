package line;

import java.awt.Graphics;




import enume.LocEnum;
import atom.BaseElement;

public class Generalizationline extends LineBase{
	
	public Generalizationline(BaseElement start, BaseElement end, LocEnum startLoc, LocEnum endLoc)
	{
		super(start, end, startLoc, endLoc);		
	}
	
	public void draw(Graphics input)
	{
		super.draw(input);
		
//		if (startElement.getLeftX() > endElement.getLeftX())
//		{
//			int[] arrayX = {destX, destX + 10, destX + 10, destX};  
//			int[] arrayY = {destY, destY + 10, destY - 10, destY};  
//			input.drawPolyline(arrayX, arrayY, 4);
//		}
//		if (startElement.getLeftX() < endElement.getLeftX())
//		{
//			int[] arrayX = {destX, destX - 10, destX - 10, destX};  
//			int[] arrayY = {destY, destY + 10, destY - 10, destY};  
//			input.drawPolyline(arrayX, arrayY, 4);
//		}
		
		if (endLocation == LocEnum.LEFT)
		{
			int[] arrayX = {destX, destX - 10, destX - 10, destX};  
			int[] arrayY = {destY, destY + 10, destY - 10, destY};  
			input.drawPolyline(arrayX, arrayY, 4);
		}
		if (endLocation == LocEnum.UP)
		{
			int[] arrayX = {destX, destX - 10, destX + 10, destX};  
			int[] arrayY = {destY, destY - 10, destY - 10, destY};  
			input.drawPolyline(arrayX, arrayY, 4);
		}
		if (endLocation == LocEnum.RIGHT)
		{
			int[] arrayX = {destX, destX + 10, destX + 10, destX};  
			int[] arrayY = {destY, destY + 10, destY - 10, destY};  
			input.drawPolyline(arrayX, arrayY, 4);
		}
		if (endLocation == LocEnum.DOWN)
		{
			int[] arrayX = {destX, destX - 10, destX + 10, destX};  
			int[] arrayY = {destY, destY + 10, destY + 10, destY};  
			input.drawPolyline(arrayX, arrayY, 4);
		}
	
	}
}
