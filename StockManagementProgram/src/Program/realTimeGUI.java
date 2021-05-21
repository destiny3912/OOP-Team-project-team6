package Program;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class realTimeGUI extends JFrame{
	
	JFrame frame = new JFrame("Stocks");
	private JButton b1 = new JButton("Enter");
	private JTextField textfield = new JTextField(20);
	private ActionListener ac = new ac();
	private String time = "0";
	JTextField name,age;
	
	public void createFrame()
	{
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);//Close frame
		this.setSize(600,300);
		this.setVisible(true);
		
		//Layout
		this.setLayout(new FlowLayout());
		add(new JLabel("Real time timer"));
		
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("Target time"));
		panel1.add(textfield);
		this.add(panel1);
		add(b1);
		
		this.setVisible(true);
	}
	
	public String dataReturner()
	{
		return time;
	}
	
	public void dataReceiver()
	{
		b1.addActionListener(ac);
	}
	
	public void printOnGUI(String targetString)
	{
		frame.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);//Close frame
		frame.setSize(1000, 600);
		
		TextArea text = new TextArea(20,50);
		
		text.append(targetString + "\n");
		frame.add(text);
		frame.setVisible(true);
	}
	class ac implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == b1)
			{
				time = textfield.getText();
			}
		}
	}
	public static void main(String[] args) {

	}

}
