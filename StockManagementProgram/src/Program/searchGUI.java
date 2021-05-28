package Program;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;

public class searchGUI extends JFrame{
	
	JFrame frame = new JFrame("Stocks");
	private JButton b2 = new JButton("Enter");
	private JTextField textfield = new JTextField(30);
	private ActionListener ac = new ac();
	private String stock;
	JTextField name,age;
	
	public void createFrame()
	{
		this.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);//Close frame
		this.setSize(600,300);//set frame size
		this.setVisible(true);//set frame to visible
		
		//Layout
		this.setLayout(new FlowLayout());//set frame layout
		add(new JLabel("Seach stock"));
		
		JPanel panel2 = new JPanel();
		panel2.add(new JLabel("Enter Stock Name"));
		panel2.add(textfield);//add textfield to frame
		this.add(panel2);
		add(b2);//add button b2 to frame
	}
	
	public String dataReturner()
	{
		return stock;
	}
	
	public void dataReceiver()
	{
		b2.addActionListener(ac);
	}
	
	public void printOnGUI(Search data)
	{
		String target;
		
		frame.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);//Close frame
		frame.setSize(1000, 600);//set frame size
		
		TextArea text = new TextArea(20,50);//set text area
		frame.add(text);//add text area to frame
	
		/*for(int index = 0; index < data.line.size(); line++)
		{
			target = data.line.get(index);
			text.append((index + 1) + ": " + target + "\n");//print on text area
		}*/
		
		frame.setVisible(true);//set frame to visible
	}
	
	class ac implements ActionListener{//set action when press button b2
		
		Search data = new Search();
		String stock;
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			while(e.getSource() == b2)
			{	
				stock = textfield.getText();
				try {
					data.searchMethod(stock);
					data.printAllMethod();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		
	}

}
