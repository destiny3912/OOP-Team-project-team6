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
	
	public void printOnGUI(String targetString)
	{
		frame.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);//Close frame
		frame.setSize(1000, 600);//set frame size
		
		TextArea text = new TextArea(20,50);//set text area
		frame.add(text);//add text area to frame
		
		text.append(targetString + "\n");//print on text area
		frame.setVisible(true);//set frame to visible
	}
	
	class ac implements ActionListener{//set action when press button b1
		
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
