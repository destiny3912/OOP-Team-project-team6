package Program;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;

public class realTimeGUI extends JFrame{
	
	JFrame frame = new JFrame("Stocks");
	private JButton b1 = new JButton("Enter");
	private JTextField textfield = new JTextField(20);
	private ActionListener ac = new ac();
	private String time;
	JTextField name,age;
	
	public void createFrame()
	{
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);//Close frame
		this.setSize(600,300);//set frame size
		this.setVisible(true);//set frame to visible
		
		//Layout
		this.setLayout(new FlowLayout());//set frame layout
		add(new JLabel("Real time timer"));
		
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("Target time"));
		panel1.add(textfield);//add textfield to frame
		this.add(panel1);
		add(b1);//add button b1 to frame
	}
	
	public String dataReturner()
	{
		return time;
	}
	
	public void dataReceiver()
	{
		b1.addActionListener(ac);
	}
	
	public void printOnGUI(realTime data)
	{
		String target;
		
		frame.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);//Close frame
		frame.setSize(1000, 600);//set frame size
		
		TextArea text = new TextArea(20,50);//set text area
		frame.add(text);//add text area to frame
	
		for(int index = 0; index < data.list.size(); index++)
		{
			target = data.list.get(index);
			text.append((index + 1) + ": " + target + "\n");//print on text area
		}
		
		frame.setVisible(true);//set frame to visible
	}
	
	class ac implements ActionListener{//set action when press button b1
		
		realTime data = new realTime();
		String time;
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			while(e.getSource() == b1)
			{	
				time = textfield.getText();
				
				data.setTargetTime(time);
				
				while(data.isSameToTargetTime() == 0)
				{
					if(data.isSameToTargetTime() == 1)
					{
						break;
					}
				}
				
				data.findLackStock();
				
				printOnGUI(data);
				
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}
