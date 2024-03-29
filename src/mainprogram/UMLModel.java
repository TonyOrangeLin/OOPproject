package mainprogram;

import interfaces.PaintObserver;
import interfaces.Subject;

import java.util.ArrayList;

import enume.LocEnum;
import enume.StateEnum;
import line.Associationline;
import line.Compositionline;
import line.Generalizationline;
import line.LineBase;
import atom.BaseElement;
import atom.ClassElement;
import atom.GroupElement;
import atom.UseClassElement;

public class UMLModel implements Subject{
	private ArrayList<BaseElement> elementArray = new ArrayList<BaseElement>();
	private ArrayList<LineBase> lineArray = new ArrayList<LineBase>();
	private ArrayList<PaintObserver> paintObservers = new ArrayList<PaintObserver>();
    int x1;
    int y1;
    int x2;
    int y2;
    BaseElement tempElement;
    LocEnum tempStart;
    private StateEnum state = StateEnum.NONE;
    
    public StateEnum getState()
    {
    	return state;
    }
    
    public void SetState(StateEnum input)
    {
    	state = input;
    }
    
    public UMLModel()
    {
    	
    }
    
    public ArrayList<BaseElement> GetElements()
    {
    	return elementArray;
    }
    
    public ArrayList<LineBase> GetLines()
    {
    	return lineArray;
    }
    
    public void MousePressed(int x1, int y1)
    {
    	this.x1 = x1;
    	this.y1 = y1;
    	if (state == StateEnum.SELECT || state == StateEnum.ASSOCIATION || state == StateEnum.COMPOSITION || state == StateEnum.GENERALIZATION)
  	    {
    		
	    	for (int i = elementArray.size() - 1; i >= 0; i--)
	  	  	{
	  	  		if (((BaseElement)elementArray.get(i)).CheckPointInElement(x1, y1))
	  	  		{
	  	  			tempElement = (BaseElement) elementArray.get(i);
	  	  			if (state == StateEnum.ASSOCIATION || state == StateEnum.COMPOSITION || state == StateEnum.GENERALIZATION)
	  	  	  		{
	  	  				tempStart = tempElement.CheckLinePosition(x1 , y1);
	  	  	  		}
	  				break;
	  	  		}
	  	  	}
  	    }
    }
    
    public void MouseReleased(int x2, int y2)
    {
    	this.x2 = x2;
    	this.y2 = y2;
    	if (x1 == x2 && y1 == y2)//not drag
    	{
    	  	if (state == StateEnum.SELECT)
    	  	{
    	  		for (int j = 0; j < elementArray.size(); j++)
        		{
       			  ((BaseElement)elementArray.get(j)).setSelect(false);
      	  	    }
     		  for (int i = elementArray.size() - 1; i >= 0; i--)
    	  	  {
    	  		  if (((BaseElement)elementArray.get(i)).CheckPointInElement(x2, y2))
    	  		  {
    	  			  ((BaseElement)elementArray.get(i)).setSelect(true);
    				  break;
    	  		  }
    	  	  }
   	  	  }
     	  if (state == StateEnum.CLASS)
    	  {
    		  elementArray.add(new ClassElement(x1, y1));  
    	  }
    	  if (state == StateEnum.USECLASS)
     	  {
      		  elementArray.add(new UseClassElement(x1, y1));  
   	  	  }

    	}
    	else//drag
    	{
    		if (state == StateEnum.SELECT)
    		{
    			if (tempElement != null)
    			{
    				tempElement.setObjMove(x2 - x1,  y2 - y1);
    			}
    			else
    			{
    				for (int i = 0; i < elementArray.size(); i++)
    	    		{
    					if (((BaseElement)elementArray.get(i)).CheckPointBetween(x1, y1, x2, y2))
    					{
    						((BaseElement)elementArray.get(i)).setSelect(true);	
    					}
    	    		}
    			}
    		}
    		if (state == StateEnum.ASSOCIATION || state == StateEnum.COMPOSITION || state == StateEnum.GENERALIZATION)
  	  	    {
    			if (tempElement != null)
    			{
	  	  		  	for (int i = elementArray.size() - 1; i >= 0; i--)
	  	  		  	{
	  	  		  		if (((BaseElement)elementArray.get(i)).CheckPointInElement(x2, y2))
	  	  		  		{
	  	  		  			  LocEnum tempEnd = ((BaseElement)elementArray.get(i)).CheckLinePosition(x2 , y2);
	  	  		  			  if (state == StateEnum.ASSOCIATION)
	  	  		  		 	  {
								  lineArray.add(new Associationline(tempElement, ((BaseElement)elementArray.get(i)), tempStart, tempEnd));
							  }
							  if (state == StateEnum.GENERALIZATION)
							  {
								  lineArray.add(new Generalizationline(tempElement, ((BaseElement)elementArray.get(i)), tempStart, tempEnd));
							  }
							  if (state == StateEnum.COMPOSITION)
							  {
								  lineArray.add(new Compositionline(tempElement, ((BaseElement)elementArray.get(i)), tempStart, tempEnd));
							  }
							  break;
	  	  		  		}
	  	  		  	}
    			}
  	    
  	  	    }
    		
    	}
    	tempElement = null;
    }
    
	public void Group()
	{
		GroupElement group = new GroupElement(x1, y1, x2, y2);
		for (int i = 0; i < elementArray.size(); i++)
		{
			if (((BaseElement) elementArray.get(i)).isSelect())
			{
				BaseElement element = (BaseElement)elementArray.get(i);
				elementArray.remove(i);
				element.setSelect(false);
				group.Add(element);
				i--;
			}
		}
		elementArray.add(group);
	}
	
	public void UnGroup()
	{
		for (int i = 0; i < elementArray.size(); i++)
		{
			if (((BaseElement) elementArray.get(i)).isSelect())
			{
				if ( (BaseElement)elementArray.get(i) instanceof GroupElement)
				{
					ArrayList<BaseElement> tempList = ((GroupElement) elementArray.get(i)).getelementList();
					elementArray.remove(i);
					for (int j = 0; j < tempList.size(); j++)
					{
						elementArray.add((BaseElement) tempList.get(j));
					}
				}
				break;
			}
		}
	}
	
	public void SetSelectedObjName(String name)
	{
		int totalCount = 0;
		for (int i = 0; i < elementArray.size(); i++)
		{
			if ( ((BaseElement) elementArray.get(i)).isSelect() )
			{
				totalCount++;
			}
			
		}
		if (totalCount == 1)
		{
			for (int i = 0; i < elementArray.size(); i++)
			{
				if (((BaseElement) elementArray.get(i)).isSelect())
				{
					if (!( (BaseElement)elementArray.get(i) instanceof GroupElement))
					{
						((BaseElement) elementArray.get(i)).setName(name);
					}
				}
			}
		}
	}

	@Override
	public void RegisterObserver(PaintObserver o) {
		// TODO Auto-generated method stub
		paintObservers.add(o);
	}

	@Override
	public void RemoveObserver(PaintObserver o) {
		// TODO Auto-generated method stub
		paintObservers.remove(o);
	}

	@Override
	public void NotifyObservers() {
		// TODO Auto-generated method stub
		for (int i = 0; i < paintObservers.size(); i++)
		{
			paintObservers.get(i).ObserverUpdate();
		}
	}
}
