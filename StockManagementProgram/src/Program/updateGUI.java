package term_project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class updateGUI extends JFrame implements ActionListener{
		JButton updateButton, insertButton;
		JPanel p;
		
		public Button()
		{
			setSize(300, 200);
			setTitle("Insertion");
			
			p = new JPanel();
			updateButton = new JButton("UPDATE"); //update button
			insertButton = new JButton("INSERT"); //insert button
			
			updateButton.addActionListener(this); //call event method
			insertButton.addActionListener(this);
			
			p.add(insertButton);
			p.add(updateButton);
			add(p);
			setVisible(true);
		
		}
		
		@Override
		public void buttonAction(ActionEvent e) {
			if(e.getSource() == updateButton) {
				//update
			}
			else if(e.getSource() == insertButton) {
				//insert
			}
		}
		public static void main(String[] args) {
			new updateGUI();
	}

}
