package mainprogram;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;


public class Setstringwindow extends JFrame implements ActionListener{
	private JTextField textField;
	
	
	public Setstringwindow()
	{
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(148, 48, 96, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(104, 99, 87, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(224, 99, 87, 23);
		getContentPane().add(btnNewButton_1);

		
		
		
		
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
