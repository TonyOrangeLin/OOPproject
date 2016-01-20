package atom;

import java.awt.Graphics;

import mainprogram.LocEnum;

public class BaseElement {
	protected int leftX;
	protected int leftY;
	protected int rightX;
	protected int rightY;
	protected int height;
	protected int width;
	private int depth;
	protected String name = "no name";
	protected boolean isSelect;
	public BaseElement()
	{
		setName("");
	}
	
	public void draw(Graphics input)
	{
		input.drawRect(50, 50, 300, 300);	
	}
	
	public void drawconnectionpoint(Graphics input)
	{
		input.drawRect( (leftX +  rightX)/2, leftY, 3, 3);//up
		input.drawRect(  rightX, (leftY + rightY) / 2, 3, 3);//right
		input.drawRect( (leftX +  rightX)/2, rightY, 3, 3);//down
		input.drawRect( leftX, (leftY + rightY) / 2, 3, 3);//left
	}
	
	public void setObjMove(int newX, int newY)
	{
		leftX += newX;
		leftY += newY;
		rightX += newX;
		rightY += newY;
	}
	
	public LocEnum CheckLinePosition(int X, int Y)
    {
    	double ans1 = (X - leftX) * (rightY - leftY) - ( Y - leftY) * (rightX - leftX);
    	double ans2 = (X - leftX) * (leftY - rightY) - ( Y - rightY) * (rightX - leftX);
    	if ( ans1 >= 0 && ans2 >= 0)
    	{
    		return LocEnum.UP;
    	}
    	if ( ans1 < 0 && ans2 < 0)
    	{
    		return LocEnum.DOWN;
    	}
    	if ( ans1 >= 0 && ans2 < 0)
    	{
    		return LocEnum.RIGHT;
    	}
    	if ( ans1 < 0 && ans2 >= 0)
    	{
    		return LocEnum.LEFT;
    	}
    	return LocEnum.DOWN;
    }

	public boolean CheckPointInElement(int X, int Y)
	{
		if (X >= getLeftX() && X <= getRightX() )
		{
	  		if (Y >= getLeftY() && Y <= getRightY() )
	  		{
	  			return true;
	  		}  
	  	}
		return false;
	}
	
	public boolean CheckPointBetween(int X1, int Y1, int X2, int Y2)
	{
		if (X1 <= getLeftX() && X1 <= getRightX() )
		{
			if (X2 >= getLeftX() && X2 >= getRightX() )
			{
				if (Y1 <= getLeftY() && Y1 <= getRightY() )
				{
					if (Y2 >= getLeftY() && Y2 >= getRightY() )
					{
						return true;
					}	 
				}  
			}
		}
		return false;
	}
	public int getLeftX() {
		return leftX;
	}

	public void setLeftX(int leftX) {
		this.leftX = leftX;
	}

	public int getLeftY() {
		return leftY;
	}

	public void setLeftY(int leftY) {
		this.leftY = leftY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getRightY() {
		return rightY;
	}

	public void setRightY(int rightY) {
		this.rightY = rightY;
	}

	public int getRightX() {
		return rightX;
	}

	public void setRightX(int rightX) {
		this.rightX = rightX;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean isSelect() {
		return isSelect;
	}

	public void setSelect(boolean isSelect) {
		this.isSelect = isSelect;
	}
}
