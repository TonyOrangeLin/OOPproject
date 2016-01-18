package mainprogram;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Setstringwindow extends Frame implements ActionListener{
	
	
	public Setstringwindow()
	{
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent e)//把裡面改一改就出來囉,還要加入paint(g)讓圖形可以出來
	{
		 String cmd =  e.getActionCommand();
	     if (cmd == "b1")
		  {

	      }
		  else if(cmd == "b2")
		  {
	        
		  }
		
	}
}
