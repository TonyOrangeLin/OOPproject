package mainprogram;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UMLMainWindow extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2152837231537831802L;
	
	private JPanel paintPanel;
	
	UMLModel uModel;
	UMLController uController;
	
	JButton selectButton;
	JButton associationButton;
	JButton generalizationButton;
	JButton compositionButton;
	JButton classButton;
	JButton useButton;
    
	public UMLMainWindow(UMLModel model, UMLController controller) {
		uModel = model;
		uController = controller;
		
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
		
		
	}

    private void jPanel2MousePressed(MouseEvent evt) 
    {
    	int x1=evt.getX();//取得滑鼠按下時的X座標(繪圖起始點X座標)
  	  	int y1=evt.getY();//取得滑鼠按下時的Y座標(繪圖起始點Y座標)
  	  	uController.MousePressed(x1, y1);
    }

    private void jPanel2MouseReleased(MouseEvent evt) 
    {
    	int x2 = evt.getX();
    	int y2 = evt.getY();
    	uController.MouseRelease(x2, y2);
    	Update();
    }
    
    public void Update()
    {
    	Graphics g=getGraphics();
	    paint(g);
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
            uController.Draw(g);
            
        }
    }
    
	public void UpdateGUI(StateEnum state)
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
		if (state == StateEnum.SELECT)
		{
			selectButton.setBackground(Color.BLACK);
			selectButton.setForeground(Color.WHITE);
		}
		else if (state == StateEnum.ASSOCIATION)
		{
			associationButton.setBackground(Color.BLACK);
			associationButton.setForeground(Color.WHITE);
		}
		else if (state == StateEnum.GENERALIZATION)
		{
			generalizationButton.setBackground(Color.BLACK);
			generalizationButton.setForeground(Color.WHITE);
		}
		else if (state == StateEnum.COMPOSITION)
		{
			compositionButton.setBackground(Color.BLACK);
			compositionButton.setForeground(Color.WHITE);
		}
		else if (state == StateEnum.CLASS)
		{
			classButton.setBackground(Color.BLACK);
			classButton.setForeground(Color.WHITE);
		}
		else if (state == StateEnum.USECLASS)
		{
			useButton.setBackground(Color.BLACK);
			useButton.setForeground(Color.WHITE);
		}
	}
			
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionName = e.getActionCommand();
		uController.KeyPressed(actionName);
		
	}

	
}
