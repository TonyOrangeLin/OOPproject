package line;

import java.awt.Graphics;
import java.awt.Graphics2D;

import atom.BaseElement;

public class Associationline extends LineBase{
	
	public Associationline(int start, int end, int startLoc, int endLoc)
	{
		super(start, end, startLoc, endLoc);
	}
	
	public void draw(Graphics input, BaseElement start, BaseElement dest)
	{
		super.draw(input, start, dest);
	}

}
