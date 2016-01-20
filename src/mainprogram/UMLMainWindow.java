package mainprogram;

import javax.swing.*;

import atom.BaseElement;
import atom.ClassElement;
import atom.GroupElement;
import atom.UseClassElement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import line.Associationline;
import line.Compositionline;
import line.Generalizationline;
import line.LineBase;


public class UMLMainWindow extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2152837231537831802L;
	private JPanel paintPanel;
	boolean isPressed = false;
	boolean drawLinePressed = false;
	boolean objectmovePressed = false;
	private int state = 0;
	JButton selectButton;
	JButton associationButton;
	JButton generalizationButton;
	JButton compositionButton;
	JButton classButton;
	JButton useButton;
	private ArrayList<BaseElement> elementArray = new ArrayList<BaseElement>();
	private ArrayList<LineBase> lineArray = new ArrayList<LineBase>();
    int x1;
    int y1;
    int x2;
    int y2;
    BaseElement tempElement;
    LocEnum tempStart;
    Setstringwindow setStringWindow;
    
	public UMLMainWindow() {

		setResizable(false);
		this.setSize(700, 700);
		getContentPane().setLayout(null);
		
		paintPanel = new PanelCustom();
		paintPanel.setBackground(Color.WHITE);
		paintPanel.setSize(1500, 1500);
		paintPanel.setBounds(150, 36, 500, 469);
		paintPanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
            public void mouseReleased(MouseEvent evt) {
                jPanel2MouseReleased(evt);
            }
        });

		getContentPane().add(paintPanel);
		
		
		selectButton = new JButton("select");
		selectButton.setActionCommand("select");
		selectButton.addActionListener(this);
		selectButton.setBounds(10, 36, 121, 23);
		getContentPane().add(selectButton);
		
		associationButton = new JButton("association line");
		associationButton.setBounds(10, 71, 121, 23);
		associationButton.setActionCommand("association");
		associationButton.addActionListener(this);
		getContentPane().add(associationButton);
		
		generalizationButton = new JButton("generalization line");
		generalizationButton.setBounds(10, 104, 121, 23);
		generalizationButton.setActionCommand("generalization");
		generalizationButton.addActionListener(this);
		getContentPane().add(generalizationButton);
		
		compositionButton = new JButton("composition line");
		compositionButton.setActionCommand("composition");
		compositionButton.addActionListener(this);
		compositionButton.setBounds(10, 137, 121, 23);
		getContentPane().add(compositionButton);
		
		classButton = new JButton("class");
		classButton.setActionCommand("class");
		classButton.addActionListener(this);
		classButton.setBounds(10, 170, 121, 23);
		getContentPane().add(classButton);
		
		useButton = new JButton("use class");
		useButton.setActionCommand("use");
		useButton.addActionListener(this);
		useButton.setBounds(10, 203, 121, 23);
		getContentPane().add(useButton);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("(None)");
		mntmNewMenuItem_3.setSelected(true);
		fileMenu.add(mntmNewMenuItem_3);
		
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(editMenu);
		
		JMenuItem groupMenuItem = new JMenuItem("Group");
		groupMenuItem.addActionListener(this);
		groupMenuItem.setActionCommand("group");
		editMenu.add(groupMenuItem);
		
		JMenuItem ungroupMenuItem = new JMenuItem("UnGroup");
		ungroupMenuItem.setActionCommand("ungroup");
		ungroupMenuItem.addActionListener(this);
		editMenu.add(ungroupMenuItem);
		
		JMenuItem changenameMenuItem = new JMenuItem("Change Object Name");
		changenameMenuItem.setActionCommand("changename");
		changenameMenuItem.addActionListener(this);
		editMenu.add(changenameMenuItem);
		this.setVisible(true);
		
		UpdateGUI();
		setStringWindow = new Setstringwindow(this);
	}

    private void jPanel2MousePressed(MouseEvent evt) 
    {
    	x1=evt.getX();//取得滑鼠按下時的X座標(繪圖起始點X座標)
  	  	y1=evt.getY();//取得滑鼠按下時的Y座標(繪圖起始點Y座標)
  	  	tempElement = null;
  	  	if (state == 1 || state == 2 || state == 3 || state == 4)
  	    {
	  	  	for (int i = elementArray.size() - 1; i >= 0; i--)
	  	  	{
	  	  		if (((BaseElement)elementArray.get(i)).CheckPointInElement(x1, y1))
	  	  		{
	  	  			tempElement = (BaseElement) elementArray.get(i);
	  	  			if (state == 1)
	  	  	  		{
	  	  				tempStart = tempElement.CheckLinePosition(x1 , y1);
	  	  	  		}
	  				break;
	  	  		}
	  	  	}
  	    }
    }

    private void jPanel2MouseReleased(MouseEvent evt) 
    {
    	x2 = evt.getX();
    	y2 = evt.getY();
    	if (x1 == x2 && y1 == y2)//not drag
    	{
    	  	if (state == 1)
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
     	  if (state == 5)
    	  {
    		  elementArray.add(new ClassElement(x1, y1));  
    	  }
    	  if (state == 6)
     	  {
      		  elementArray.add(new UseClassElement(x1, y1));  
   	  	  }
    	  Graphics g=getGraphics();
		  paint(g);
    	}
    	else//drag
    	{
    		if (state == 1)
    		{
    			if (tempElement != null)
    			{
    				tempElement.setObjMove(x2 - x1,  y2 - y1);
    			}
    			else
    			{
    	    			for (int i = 0; i < elementArray.size(); i++)
    	    			{
    	    				  if (x1 <= ((BaseElement)elementArray.get(i)).getLeftX() && x1 <= ((BaseElement)elementArray.get(i)).getRightX() )
    	    				  {
    	    					  if (x2 >= ((BaseElement)elementArray.get(i)).getLeftX() && x2 >= ((BaseElement)elementArray.get(i)).getRightX() )
    	    					  {
    	    						  if (y1 <= ((BaseElement)elementArray.get(i)).getLeftY() && y1 <= ((BaseElement)elementArray.get(i)).getRightY() )
    	    						  {
    	    							  if (y2 >= ((BaseElement)elementArray.get(i)).getLeftY() && y2 >= ((BaseElement)elementArray.get(i)).getRightY() )
    	    							  {
    	    								  ((BaseElement)elementArray.get(i)).setSelect(true);	
    	    							  }	 
    	    						  }  
    	    					  }
    	    				  }
    	    			}
    	    		
    			}
    		}
    		if (state == 2 || state == 3 || state == 4)
  	  	    {
    			if (tempElement != null)
    			{
	  	  		  	for (int i = elementArray.size() - 1; i >= 0; i--)
	  	  		  	{
	  	  		  		if (((BaseElement)elementArray.get(i)).CheckPointInElement(x2, y2))
	  	  		  		{
	  	  		  					LocEnum tempEnd = ((BaseElement)elementArray.get(i)).CheckLinePosition(x2 , y2);
	  	  		  				  //LocEnum tempEnd = DecidePosition(((BaseElement)elementArray.get(i)), x2 , y2);
	  	  		  				  if (state == 2)
	  	  		  			 	  {
									  lineArray.add(new Associationline(tempElement, ((BaseElement)elementArray.get(i)), tempStart, tempEnd));
								  }
								  if (state == 3)
								  {
									  lineArray.add(new Generalizationline(tempElement, ((BaseElement)elementArray.get(i)), tempStart, tempEnd));
								  }
								  if (state == 4)
								  {
									  lineArray.add(new Compositionline(tempElement, ((BaseElement)elementArray.get(i)), tempStart, tempEnd));
								  }
								  tempElement = null;
	  	  		  					break;
	  	  		  		}
	  	  		  	}
    			}
  	    
  	  	    }
    		tempElement = null;
    	}
    	Graphics g=getGraphics();
	    paint(g);
    }
    
    
    
	public LocEnum DecidePosition(BaseElement element,int inputX, int inputY)
	{
		if (inputX > element.getLeftX()+ element.getWidth()/3)
		{
			if (inputX < element.getRightX()- element.getWidth()/3)
			{
				if (inputY > element.getLeftY())
				{
					if (inputY < element.getLeftY() + element.getHeight()/2)
					{
						return LocEnum.UP;
					}	
				}
			}
		}
		if (inputX < element.getLeftX()+ element.getWidth()/3)
		{
			if (inputX > element.getLeftX())
			{
				if (inputY > element.getLeftY())
				{
					if (inputY < element.getRightY())
					{
						return LocEnum.LEFT;
					}	
				}
			}
		}
		if (inputX > element.getRightX() - element.getWidth()/3)
		{
			if (inputX < element.getRightX())
			{
				if (inputY > element.getLeftY())
				{
					if (inputY < element.getRightY())
					{
						return LocEnum.RIGHT;
					}	
				}				
			}
		}
		if (inputX > element.getLeftX()+ element.getWidth()/3)
		{
			if (inputX < element.getRightX()- element.getWidth()/3)
			{
				if (inputY > element.getLeftY() + element.getHeight()/2)
				{
					if (inputY < element.getRightY())
					{
						return LocEnum.DOWN;
					}	
				}	
			}
		}
		return LocEnum.DOWN;
	}
    
    class PanelCustom extends JPanel {

    	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		PanelCustom() {
            // set a preferred size for the custom panel.
            setPreferredSize(new Dimension(1000, 1000));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = elementArray.size() - 1; i >= 0; i--)
            {
            	((BaseElement) elementArray.get(i)).draw(g);
            }
            for (int j = lineArray.size() - 1; j >= 0; j--)
            {
            	((LineBase) lineArray.get(j)).draw(g);
            }
            
        }
    }
    
	public void UpdateGUI()
	{
		selectButton.setBackground(Color.WHITE);
		selectButton.setForeground(Color.BLACK);
		associationButton.setBackground(Color.WHITE);
		associationButton.setForeground(Color.BLACK);
	    generalizationButton.setBackground(Color.WHITE);
	    generalizationButton.setForeground(Color.BLACK);
	    compositionButton.setBackground(Color.WHITE);
		compositionButton.setForeground(Color.BLACK);
	    classButton.setBackground(Color.WHITE);
	    classButton.setForeground(Color.BLACK);
		useButton.setBackground(Color.WHITE);
		useButton.setForeground(Color.BLACK);
		if (state == 0)
		{
			
		}
		if (state == 1)
		{
			selectButton.setBackground(Color.BLACK);
			selectButton.setForeground(Color.WHITE);
		}
		if (state == 2)
		{
			associationButton.setBackground(Color.BLACK);
			associationButton.setForeground(Color.WHITE);
		}
		if (state == 3)
		{
			generalizationButton.setBackground(Color.BLACK);
			generalizationButton.setForeground(Color.WHITE);
		}
		if (state == 4)
		{
			compositionButton.setBackground(Color.BLACK);
			compositionButton.setForeground(Color.WHITE);
		}
		if (state == 5)
		{
			classButton.setBackground(Color.BLACK);
			classButton.setForeground(Color.WHITE);
		}
		if (state == 6)
		{
			useButton.setBackground(Color.BLACK);
			useButton.setForeground(Color.WHITE);
		}
		
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
		Graphics g=getGraphics();
		paint(g);
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
	
	public void ChangeName()
	{
		setStringWindow.StartChangeText();
	}
	
	public void SetSelectedObjName(String name)
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
		Graphics g=getGraphics();
		paint(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("select".equals(e.getActionCommand()))
		{
			state = 1;
		}
		if ("association".equals(e.getActionCommand()))
		{
			state = 2;
		}
		if ("generalization".equals(e.getActionCommand()))
		{
			state = 3;
		}
		if ("composition".equals(e.getActionCommand()))
		{
			state = 4;
		}
		if ("class".equals(e.getActionCommand()))
		{
			state = 5;
		}
		if ("use".equals(e.getActionCommand()))
		{
			state = 6;
		}
		if ("group".equals(e.getActionCommand()))
		{
			Group();
		}
		if ("ungroup".equals(e.getActionCommand()))
		{
			UnGroup();
		}
		if ("changename".equals(e.getActionCommand()))
		{
			ChangeName();
		}
		UpdateGUI();
	}

	
}
