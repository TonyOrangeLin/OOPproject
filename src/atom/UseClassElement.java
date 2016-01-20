package atom;

import java.awt.Graphics;

public class UseClassElement extends BaseElement{

	public UseClassElement(int startX, int startY)
	{
	  this.setLeftX(startX);
	  this.setLeftY(startY);
	  this.setHeight(60);
	  this.setWidth(80);
	  rightX = leftX + width;
	  rightY = leftY + height;

	}
	
	
	public void draw(Graphics input)
	{
		//input.drawRect(super.getLeftX(), super.getLeftY(), super.getWidth(), super.getHeight());
		input.drawOval(getLeftX(), getLeftY(), getWidth(), getHeight());
		if (isSelect)
		{
			super.drawconnectionpoint(input);
		}
		input.drawString(name, leftX + 20, leftY + 20);
	}
	
	
}
