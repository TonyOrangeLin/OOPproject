package mainprogram;

import java.awt.*;//類別庫
import java.awt.event.*;//awt類別庫
import java.util.ArrayList;
import line.Associationline;
import line.Compositionline;
import line.Generalizationline;
import line.LineBase;
import atom.BaseElement;
import atom.ClassElement;
import atom.UseClassElement;

public class UMLpainter 
{
   static UMLpainter frm=new UMLpainter();//建立物件frm
   
   static Label lab=new Label();
   static MenuBar mb=new MenuBar();//建立MenuBar的物件mb
   static Menu menu1=new Menu("File");//字體的粗細度
   static Menu menu2=new Menu("Edit");//顏色
   static MenuItem mi1=new MenuItem("(無)");// 
   static MenuItem mi9=new MenuItem("Group ");
   static MenuItem mi10=new MenuItem("UnGroup ");
   static MenuItem mi11=new MenuItem("Change object name");
   static Button b1 = new Button("select");
   static Button b2 = new Button("association line");   
   static Button b3 = new Button("generalization line");  
   static Button b4 = new Button("composition line");   
   static Button b5 = new Button("class");
   static Button b6 = new Button("use class");
   int x1,x2,y1,y2,posX=70,posY=60,dx,dy;
   int a,b=0;
   //儲存多邊形的點
   int polygonTrajectoryX[] = new int[100];
   int polygonTrajectoryY[] = new int[100];
   int polygonIndex = 0;
   private int state = 0;
   private int flag=1;
   static ArrayList elementArray;
   static ArrayList compositeArray;
   static ArrayList lineArray;
   static ArrayList groupArray;
   int startposition = -1;
   int startIndex = -1;
   int destposition = -1;

   static int penweight=1;
   static Setstringwindow stringwindow;
   static Stroke stroke = new BasicStroke( penweight,  BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 10) ;

    String passingname;
	int changenameIndex = -1;
	private int selectCount = 0;
	boolean isPressed = false;
	boolean drawLinePressed = false;
	boolean objectmovePressed = false;
	//private static GroupTree groupTree;
	public static void main(String args[])//主程式開始
	{
		UMLMainWindow mainWindow = new UMLMainWindow();
	}
}
		
//
//	
//	public void actionPerformed(ActionEvent e)//把裡面改一改就出來囉,還要加入paint(g)讓圖形可以出來
//	{
//		 String cmd =  e.getActionCommand();
//	     if (cmd == "b1")
//		  {
//	    	 if( state == 1)
//	    	 {
//	    		 state = 0;
//	    	 }
//	    	 else
//	    	 {
//	    		 state = 1;
//	    	 }
//	      }
//		  else if(cmd == "b2")
//		  {
//			  if( state == 2)
//		    	 {
//		    		 state = 0;
//		    	 }
//		    	 else
//		    	 {
//		    		 state = 2;
//		    	 }
//	        
//		  }
//		  else if(cmd == "b3")
//		  {
//	
//			  if( state == 3)
//		    	 {
//		    		 state = 0;
//		    	 }
//		    	 else
//		    	 {
//		    		 state = 3;
//		    	 }
//	          
//		  }
//		  else if(cmd == "b4")
//		  {
//	
//			  if( state == 4)
//		    	 {
//		    		 state = 0;
//		    	 }
//		    	 else
//		    	 {
//		    		 state = 4;
//		    	 }
//	         
//		  }
//		  else if(cmd == "b5")
//		  {
//			  //class
//			  
//			  if( state == 5)
//		    	 {
//		    		 state = 0;
//		    	 }
//		    	 else
//		    	 {
//		    		 state = 5;
//		    	 }
//	          
//		  }
//		  else if(cmd == "b6")
//		  {
//			
//			  if( state == 6)
//		    	 {
//		    		 state = 0;
//		    	 }
//		    	 else
//		    	 {
//		    		 state = 6;
//		    	 }
//	         
//		  }
//	      UpdateGUI();
//	      MenuItem mi=(MenuItem) e.getSource();//取得MenuItem的來源
//	      //Graphics g=getGraphics();//取得視窗繪圖區
//	     
//	      
//	      if(mi==mi9)
//	      {
//	    	  //choosecolor=1;
//	    	  Group();
//	      }
//	      else if(mi==mi10)
//	      {
//	    	  //choosecolor=2;
//	    	  Ungroup();
//	      }
//	      else if(mi==mi11)
//	      {
//	    	  //choosecolor=3; 
//	    	  ChangeObjectName();
//	    	  
//	      }
//	      
//	}
//	
//	public void Group()
//	{	
//		int count = 0;
//		GroupTree grouptemp = new GroupTree();
//		for (int i = 0; i < elementArray.size(); i++)
//		{
//			if (((BaseElement)elementArray.get(i)).isSelect())
//			{
//				
//				grouptemp.contentArray.add(new Integer(i));	
//				count++;
//			}
//		}
//		if(count > 0)
//		{
//			groupArray.add(grouptemp);
//		}
//	}
//	
//	public void Ungroup()
//	{
//		
//	}
//	
//	public void ChangeObjectName()
//	{
//		
//		if(selectCount == 1)
//		{
//			for (int i = 0; i< elementArray.size(); i++)
//			{
//				if (((BaseElement)elementArray.get(i)).isSelect())
//				{
//					changenameIndex = i;
//					passingname = "456";
//					stringwindow = new Setstringwindow();
//					
//					stringwindow.addWindowListener(new WindowAdapter()
//					{
//			            public void windowClosing(WindowEvent e)
//			            {
//			            	passingname = stringwindow.inputText.getText();
//			            	((BaseElement)elementArray.get(changenameIndex)).setName(passingname);
//			            	stringwindow.setVisible(false);
//			            }
//			        });//結束exit
//					
//					
//				}
//			}
//		}
//	}
//	
//	public void update(Graphics g)
//	{
//		g.setColor(Color.black);
//		g.fillRect(0,0,400,450);
//		g.setColor(Color.black);
//		frm.setBackground(getBackground());
//		paint(g);
//	}
//	
//	public void paint(Graphics g)
//	{
//		g.clearRect(0, 0, 400, 450);
//		//if(flag==0){
//		// 設定顏色
//		 g.setColor(Color.black);
//		 //粗細與線條
//		 Graphics2D g2 = (Graphics2D) g.create();
//		 //if(line==0)
//		 stroke = new BasicStroke( penweight,  BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 10) ;
//		 //else
//		  //stroke = new BasicStroke( penweight,BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 10, new float[]{3, 10}, 10);
//		 g2.setStroke(stroke);
//
//		 for (int i = 0; i< elementArray.size(); i++)
//		 {
//			 ((BaseElement) elementArray.get(i)).draw(g2);
//		 }
//		 for (int j = 0; j < lineArray.size(); j++)
//		 {
//			 int startindex =  ((LineBase) lineArray.get(j)).getStartElementIndex();
//			 int endindex = ((LineBase) lineArray.get(j)).getDestElementIndex();
//			 ((LineBase) lineArray.get(j)).draw(g2, (BaseElement)elementArray.get(startindex), (BaseElement)elementArray.get(endindex));
//		 }
//
//	}
//	
//	public int DecidePosition(BaseElement element,int inputX, int inputY)
//	{
//		if (inputX > element.getLeftX()+ element.getWidth()/3)
//		{
//			if (inputX < element.getRightX()- element.getWidth()/3)
//			{
//				if (inputY > element.getLeftY())
//				{
//					if (inputY < element.getLeftY() + element.getHeight()/2)
//					{
//						return 1;
//					}	
//				}
//		
//				
//			}
//		}
//		if (inputX < element.getLeftX()+ element.getWidth()/3)
//		{
//			if (inputX > element.getLeftX())
//			{
//				if (inputY > element.getLeftY())
//				{
//					if (inputY < element.getRightY())
//					{
//						return 0;
//					}	
//				}
//		
//				
//			}
//		}
//		if (inputX > element.getRightX() - element.getWidth()/3)
//		{
//			if (inputX < element.getRightX())
//			{
//				if (inputY > element.getLeftY())
//				{
//					if (inputY < element.getRightY())
//					{
//						return 2;
//					}	
//				}				
//			}
//		}
//		if (inputX > element.getLeftX()+ element.getWidth()/3)
//		{
//			if (inputX < element.getRightX()- element.getWidth()/3)
//			{
//				if (inputY > element.getLeftY() + element.getHeight()/2)
//				{
//					if (inputY < element.getRightY())
//					{
//						return 3;
//					}	
//				}	
//			}
//		}
//		return -1;
//	}
//	
//	public void mousePressed(MouseEvent e)//當滑鼠按壓時
//	{
//	  
//	  x1=e.getX();//取得滑鼠按下時的X座標(繪圖起始點X座標)
//	  y1=e.getY();//取得滑鼠按下時的Y座標(繪圖起始點Y座標)
//	  if (state == 1)
//	  {
//		  selectCount = 0;
//		  for (int j = 0; j < elementArray.size(); j++)
//		  {
//			  ((BaseElement)elementArray.get(j)).setSelect(false);
//		  }
//		  for (int i = elementArray.size() - 1; i >= 0; i--)
//		  {
//			  if (x1 >= ((BaseElement)elementArray.get(i)).getLeftX() && x1 <= ((BaseElement)elementArray.get(i)).getRightX() )
//			  {
//				  
//				  if (y1 >= ((BaseElement)elementArray.get(i)).getLeftY() && y1 <= ((BaseElement)elementArray.get(i)).getRightY() )
//				  {
//					  ((BaseElement)elementArray.get(i)).setSelect(true);
//					  selectCount++;
//					  startIndex = i;
//					  objectmovePressed = true;
//					  Graphics g=getGraphics();
//					  paint(g);
//					  break;
//				  }  
//			  }
//		  }
//		  if ( selectCount == 0)
//		  {
//			  isPressed = true;
//		  }
//	  }
//	  if (state == 2 || state == 3 || state == 4)
//	  {
//		  for (int i = elementArray.size() - 1; i >= 0; i--)
//		  {
//			  if (x1 >= ((BaseElement)elementArray.get(i)).getLeftX() && x1 <= ((BaseElement)elementArray.get(i)).getRightX() )
//			  {
//				  
//				  if (y1 >= ((BaseElement)elementArray.get(i)).getLeftY() && y1 <= ((BaseElement)elementArray.get(i)).getRightY() )
//				  {
//					  //((BaseElement)elementArray.get(i)).setSelect(true);
//					  //selectCount++;
//					  //Graphics g=getGraphics();
//					  //paint(g);
//					  //startposition = 0;
//					  startposition = DecidePosition(((BaseElement)elementArray.get(i)), x1 , y1);
//					  drawLinePressed = true;
//					  startIndex = i;
//					  break;
//				  }  
//			  }
//		  }
//  
//	  }
//	  if (state == 5)
//	  {
//		  elementArray.add(new ClassElement(x1, y1, elementArray.size()+1));  
//		  Graphics g=getGraphics();
//		  paint(g);
//	  }
//	  if (state == 6)
//	  {
//		  elementArray.add(new UseClassElement(x1, y1, elementArray.size()+1));  
//		  Graphics g=getGraphics();
//		  paint(g);
//	  }
//	}
//	
//	public void mouseDragged(MouseEvent e)//當滑鼠被拖曳的時候
//	{
//		if (isPressed)
//		{
//			  x2=e.getX();//取得滑鼠按下時的X座標(繪圖起始點X座標)
//			  y2=e.getY();//取得滑鼠按下時的Y座標(繪圖起始點Y座標)
//		}
//	}
//	
//	public void mouseMoved(MouseEvent e){}
//	
//	public void mouseReleased(MouseEvent e){
//		x2=e.getX();//取得滑鼠按下時的X座標(繪圖起始點X座標)
//		y2=e.getY();//取得滑鼠按下時的Y座標(繪圖起始點Y座標)
//		if (objectmovePressed)
//		{
//			if ( x1 != x2 && y1 != y2)
//			{
//				int leftX = ((BaseElement)elementArray.get(startIndex)).getLeftX() + x2 - x1;
//				int leftY = ((BaseElement)elementArray.get(startIndex)).getLeftY() + y2 - y1;
//				int rightX = ((BaseElement)elementArray.get(startIndex)).getLeftX() + ((BaseElement)elementArray.get(startIndex)).getWidth() +  x2 - x1;
//				int rightY = ((BaseElement)elementArray.get(startIndex)).getLeftY() + ((BaseElement)elementArray.get(startIndex)).getHeight() + y2 - y1;
//				
//				((BaseElement)elementArray.get(startIndex)).setLeftX(leftX);
//				((BaseElement)elementArray.get(startIndex)).setLeftY(leftY);
//				((BaseElement)elementArray.get(startIndex)).setRightX(rightX);
//				((BaseElement)elementArray.get(startIndex)).setRightY(rightY);
//				objectmovePressed = false;
//			}
//		}
//		if (isPressed)
//		{
//			isPressed = false;
//			for (int j = 0; j < elementArray.size(); j++)
//			{
//				((BaseElement)elementArray.get(j)).setSelect(false);
//			}
//			selectCount = 0;
//			for (int i = elementArray.size() - 1; i >= 0; i--)
//			{
//				  if (x1 <= ((BaseElement)elementArray.get(i)).getLeftX() && x1 <= ((BaseElement)elementArray.get(i)).getRightX() )
//				  {
//					  if (x2 >= ((BaseElement)elementArray.get(i)).getLeftX() && x2 >= ((BaseElement)elementArray.get(i)).getRightX() )
//					  {
//						  if (y1 <= ((BaseElement)elementArray.get(i)).getLeftY() && y1 <= ((BaseElement)elementArray.get(i)).getRightY() )
//						  {
//							  if (y2 >= ((BaseElement)elementArray.get(i)).getLeftY() && y2 >= ((BaseElement)elementArray.get(i)).getRightY() )
//							  {
//								  ((BaseElement)elementArray.get(i)).setSelect(true);	
//								  selectCount++;
//							  }	 
//						  }  
//					  }
//				  }
//			}
//		}
//		if (drawLinePressed)
//		{
//			for (int i = elementArray.size() - 1; i >= 0; i--)
//			  {
//				  if (x2 >= ((BaseElement)elementArray.get(i)).getLeftX() && x2 <= ((BaseElement)elementArray.get(i)).getRightX() )
//				  {
//					  
//					  if (y2 >= ((BaseElement)elementArray.get(i)).getLeftY() && y2 <= ((BaseElement)elementArray.get(i)).getRightY() )
//					  {
//						  if( i != startIndex)
//						  {
//							  destposition = 0;
//							  destposition = DecidePosition(((BaseElement)elementArray.get(i)), x2 , y2);
//							  if (state == 2)
//							  {
//								  lineArray.add(new Associationline(startIndex, i, startposition, destposition));
//							  }
//							  if (state == 3)
//							  {
//								  lineArray.add(new Generalizationline(startIndex, i, startposition, destposition));
//							  }
//							  if (state == 4)
//							  {
//								  lineArray.add(new Compositionline(startIndex, i, startposition, destposition));
//							  }
//							  drawLinePressed = false;
//							  startIndex = -1;
//							  break;
//						  }
//					  }  
//				  }
//			  }
//			
//			destposition = 0;
//		}
//		Graphics g=getGraphics();
//		paint(g);
//	
//	}
//	
//	public void mouseEntered(MouseEvent e){}
//	
//	public void mouseExited(MouseEvent e){}
//	
//	public void mouseClicked(MouseEvent e){
////		if(penmode==5){
////			Graphics g=getGraphics();//取得視窗繪圖區
////	        polygonTrajectoryX[polygonIndex] = e.getX();
////	        polygonTrajectoryY[polygonIndex] = e.getY();
////	        polygonIndex++;
////	        flag=0;
////	        paint(g);
////		}
//	}
//}