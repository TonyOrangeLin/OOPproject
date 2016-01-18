package atom;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class GroupElement extends BaseElement{

	private ArrayList<BaseElement> elementList = new ArrayList<BaseElement>();
	
	public GroupElement(int startX, int startY, int endX, int endY)
	{
	  this.setLeftX(startX);
	  this.setLeftY(startY);
	  this.setHeight(40);
	  this.setWidth(60);
	  rightX = endX;
	  rightY = endY;
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

}
