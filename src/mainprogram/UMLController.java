package mainprogram;

import java.awt.Graphics;
import line.LineBase;
import atom.BaseElement;


public class UMLController {
	UMLMainWindow uView;
	Setstringwindow sView;
	UMLModel uModel;
	
	public UMLController(UMLModel model)
	{
		uModel = model;
		uView = new UMLMainWindow(this);
		sView = new Setstringwindow(this);
	}
	
	public void MousePressed(int x1, int y1)
	{
		uModel.MousePressed(x1, y1);
		uView.Update();
	}
	
	public void MouseRelease(int x2, int y2)
	{
    	uModel.MouseReleased(x2, y2);
    	uView.Update();
	}
	
	public void Draw(Graphics g)
	{
	
		for (int i = uModel.GetElements().size() - 1; i >= 0; i--)
        {
        	((BaseElement) uModel.GetElements().get(i)).draw(g);
        }
        for (int j = uModel.GetLines().size() - 1; j >= 0; j--)
        {
        	((LineBase) uModel.GetLines().get(j)).draw(g);
        }
	}

	public void SetSelectedObjName(String name)
	{
		uModel.SetSelectedObjName(name);
		uView.Update();
	}

	public void ChangeName()
	{
		sView.StartChangeText();
	}
		
	public void KeyPressed(String ActionName)
	{
		StateEnum state = uModel.getState();
		if ("select".equals(ActionName))
		{
			state = StateEnum.SELECT;
		}
		if ("association".equals(ActionName))
		{
			state = StateEnum.ASSOCIATION;
		}
		if ("generalization".equals(ActionName))
		{
			state = StateEnum.GENERALIZATION;
		}
		if ("composition".equals(ActionName))
		{
			state = StateEnum.COMPOSITION;
		}
		if ("class".equals(ActionName))
		{
			state = StateEnum.CLASS;
		}
		if ("use".equals(ActionName))
		{
			state = StateEnum.USECLASS;
		}
		if ("group".equals(ActionName))
		{
			uModel.Group();
		}
		if ("ungroup".equals(ActionName))
		{
			uModel.UnGroup();
		}
		if ("changename".equals(ActionName))
		{
			ChangeName();
		}
		uModel.SetState(state);
		uView.UpdateGUI(state);
	}
}
