package line;

import java.awt.Graphics;
import java.awt.Graphics2D;

import mainprogram.LocEnum;
import atom.BaseElement;

public class Associationline extends LineBase{
	
	public Associationline(BaseElement start, BaseElement end, LocEnum startLoc, LocEnum endLoc)
	{
		super(start, end, startLoc, endLoc);
	}
	
	public void draw(Graphics input)
	{
		super.draw(input);
	}

}
