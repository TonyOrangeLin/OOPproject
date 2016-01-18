package atom;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class ClassElement extends BaseElement{

	
	public ClassElement(int startX, int startY)
	{
	
	  this.setLeftX(startX);
	  this.setLeftY(startY);
	  this.setHeight(60);
	  this.setWidth(40);
	  rightX = leftX + width;
	  rightY = leftY + height;
	}
	
	public void draw(Graphics input)
	{
		input.drawRect(super.getLeftX(), super.getLeftY(), super.getWidth(), super.getHeight());
		input.drawLine(getLeftX(), (rightY - leftY ) / 3 * 2 + leftY, getLeftX() + getWidth(), (rightY - leftY ) / 3 * 2 + leftY);
		input.drawLine(getLeftX(),(rightY - leftY ) / 3  + leftY , getLeftX() + getWidth(), (rightY - leftY ) / 3  + leftY);
		if (isSelect)
		{
			super.drawconnectionpoint(input);
		}
		input.drawString(name, leftX, leftY + 20);
	}
	
	
}
