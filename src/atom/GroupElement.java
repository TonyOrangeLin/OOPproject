package atom;

import java.awt.Graphics;
import java.util.ArrayList;

public class GroupElement extends BaseElement{

	private ArrayList<BaseElement> elementList = new ArrayList<BaseElement>();
	
	public GroupElement(int startX, int startY, int endX, int endY)
	{
		  this.setLeftX(startX);
		  this.setLeftY(startY);
		  this.setHeight(Math.abs(endY - startY));
		  this.setWidth(Math.abs(endX - startX));
		  rightX = endX;
		  rightY = endY;
	}
	
	public void setObjMove(int newX, int newY)
	{
		super.setObjMove(newX, newY);
		for (int i = 0; i < elementList.size(); i++)
		{
			elementList.get(i).setObjMove(newX, newY);
		}
	}
	
	public void Add(BaseElement element)
	{
		elementList.add(element);
	}
	
	public void Remove(BaseElement element)
	{
		elementList.remove(element);
	}
	
	public ArrayList<BaseElement> GetComponents()
	{
		return elementList;
	}
	
	public void draw(Graphics input)
	{
		for (int i = 0; i < elementList.size(); i++)
		{
			elementList.get(i).draw(input);
		}
	}
	
	public void setSelect(boolean isSelect)
	{
		this.isSelect = isSelect;
		for (int i = 0; i < elementList.size(); i++)
		{
			elementList.get(i).setSelect(isSelect);
		}
	}
	
	public ArrayList<BaseElement> getelementList()
	{
		return elementList;
	}

}
