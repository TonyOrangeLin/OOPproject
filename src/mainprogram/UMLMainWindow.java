package mainprogram;

import javax.swing.*;

import atom.BaseElement;
import atom.ClassElement;
import atom.UseClassElement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import line.LineBase;

public class UMLMainWindow extends JFrame implements ActionListener
{
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
	private ArrayList elementArray = new ArrayList<BaseElement>();
	private ArrayList lineArray = new ArrayList<LineBase>();
	public UMLMainWindow() {

		setResizable(false);
		this.setSize(700, 700);
		getContentPane().setLayout(null);
		
		paintPanel = new PanelCustom();
		paintPanel.setBackground(Color.WHITE);
		paintPanel.setBounds(200, 36, 395, 369);
		paintPanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
            public void mouseReleased(MouseEvent evt) {
                jPanel2MouseReleased(evt);
            }
        });
		paintPanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                jPanel2MouseDragged(evt);
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
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("(None)");
		mntmNewMenuItem_3.setSelected(true);
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Group");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("UnGroup");
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Change Object Name");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		this.setVisible(true);
		
		UpdateGUI();
	}

    private void jPanel2MouseDragged(MouseEvent evt) {

    }
    
    int x1;
    int y1;
    
    private void jPanel2MousePressed(MouseEvent evt) {
  	  x1=evt.getX();//取得滑鼠按下時的X座標(繪圖起始點X座標)
  	  y1=evt.getY();//取得滑鼠按下時的Y座標(繪圖起始點Y座標)
  	  if (state == 1)
  	  {
//  		  selectCount = 0;
//  		  for (int j = 0; j < elementArray.size(); j++)
//  		  {
//  			  ((BaseElement)elementArray.get(j)).setSelect(false);
//  		  }
//  		  for (int i = elementArray.size() - 1; i >= 0; i--)
//  		  {
//  			  if (x1 >= ((BaseElement)elementArray.get(i)).getLeftX() && x1 <= ((BaseElement)elementArray.get(i)).getRightX() )
//  			  {
//  				  
//  				  if (y1 >= ((BaseElement)elementArray.get(i)).getLeftY() && y1 <= ((BaseElement)elementArray.get(i)).getRightY() )
//  				  {
//  					  ((BaseElement)elementArray.get(i)).setSelect(true);
//  					  selectCount++;
//  					  startIndex = i;
//  					  objectmovePressed = true;
//  					  Graphics g=getGraphics();
//  					  paint(g);
//  					  break;
//  				  }  
//  			  }
//  		  }
//  		  if ( selectCount == 0)
//  		  {
//  			  isPressed = true;
//  		  }
  	  }
  	  if (state == 2 || state == 3 || state == 4)
  	  {
//  		  for (int i = elementArray.size() - 1; i >= 0; i--)
//  		  {
//  			  if (x1 >= ((BaseElement)elementArray.get(i)).getLeftX() && x1 <= ((BaseElement)elementArray.get(i)).getRightX() )
//  			  {
//  				  
//  				  if (y1 >= ((BaseElement)elementArray.get(i)).getLeftY() && y1 <= ((BaseElement)elementArray.get(i)).getRightY() )
//  				  {
//  					  //((BaseElement)elementArray.get(i)).setSelect(true);
//  					  //selectCount++;
//  					  //Graphics g=getGraphics();
//  					  //paint(g);
//  					  //startposition = 0;
//  					  startposition = DecidePosition(((BaseElement)elementArray.get(i)), x1 , y1);
//  					  drawLinePressed = true;
//  					  startIndex = i;
//  					  break;
//  				  }  
//  			  }
//  		  }
    
  	  }
  	  if (state == 5)
  	  {
  		  elementArray.add(new ClassElement(x1, y1, elementArray.size()+1));  
  		  Graphics g=getGraphics();
  		  paint(g);
  	  }
  	  if (state == 6)
  	  {
  		  elementArray.add(new UseClassElement(x1, y1, elementArray.size()+1));  
  		  Graphics g=getGraphics();
  		  paint(g);
  	  }
    }


    //mouse released//
    private void jPanel2MouseReleased(MouseEvent evt) {
//        if (tool == 2) {
//            currentX = evt.getX();
//            currentY = evt.getY();
//            System.out.println("line!!!! from" + oldX + "to" + currentX);
//        }
    }
    
    class PanelCustom extends JPanel {

    	PanelCustom() {
            // set a preferred size for the custom panel.
            setPreferredSize(new Dimension(700, 700));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i < elementArray.size(); i++)
            {
            	((BaseElement) elementArray.get(i)).draw(g);
            }
            for (int j = 0; j < lineArray.size(); j++)
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
		UpdateGUI();
	}

	
}
