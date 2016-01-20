package atom;

import java.awt.Graphics;

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
