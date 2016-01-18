package atom;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class UseClassElement extends BaseElement{

	public UseClassElement(int startX, int startY, int depth)
	{
	  this.setLeftX(startX);
	  this.setLeftY(startY);
	  this.setHeight(40);
	  this.setWidth(60);
	  rightX = leftX + width;
	  rightY = leftY + height;
	  setDepth(depth);
	}
	
	public void draw(Graphics input)
	{
		//input.drawRect(super.getLeftX(), super.getLeftY(), super.getWidth(), super.getHeight());
		input.drawOval(getLeftX(), getLeftY(), getWidth(), getHeight());
		if (isSelect)
		{
			super.drawconnectionpoint(input);
		}
		input.drawString(name, leftX, leftY + 20);
	}
	
	
}
