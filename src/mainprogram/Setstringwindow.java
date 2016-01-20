package mainprogram;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Setstringwindow extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	UMLMainWindow w;
	
	public Setstringwindow(UMLMainWindow window)
	{
		setType(Type.POPUP);
		setSize(300, 200);
		setResizable(false);
		w = window;
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(48, 24, 207, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton okButton = new JButton("OK");
		okButton.setActionCommand("ok");
		okButton.addActionListener(this);
		okButton.setBounds(48, 67, 87, 23);
		getContentPane().add(okButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("cancel");
		cancelButton.addActionListener(this);
		cancelButton.setBounds(160, 67, 87, 23);
		getContentPane().add(cancelButton);
	}
	
	public void StartChangeText()
	{
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if ("ok".equals(e.getActionCommand()))
		{
			w.SetSelectedObjName(textField.getText().toString());
			this.setVisible(false);
	    }
		else if("cancel".equals(e.getActionCommand()))
		{
			this.setVisible(false);
		}
	}
}
