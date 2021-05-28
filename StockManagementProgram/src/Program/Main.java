package Program;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.io.*;
public class Main extends JFrame{
	private JButton b1 = new JButton("Insert stock data");
	private JButton b2 = new JButton("Search stock data");
	private JButton b3 = new JButton("Real time count");
	private JFrame frame = new JFrame();
	
	public void setFrame()
	{
		frame.setVisible(true);
		frame.setSize(640,480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		frame.add(p1);
		frame.add(p2);
		frame.add(p3);
		
		p1.add(b1);
		p2.add(b2);
		p3.add(b3);
		
		b1.addActionListener(new ActionListener() { //insert
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//set insert
			}
		});
		
		b2.addActionListener(new ActionListener() { //search
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				searchGUI gui = new searchGUI();
				Search data = new Search();
				String stock;

				gui.createFrame();
				
				gui.dataReceiver();
			}
		});
		
		b3.addActionListener(new ActionListener() { //realTIme
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				realTimeGUI gui = new realTimeGUI();
				realTime data = new realTime();
				String time;

				gui.createFrame();
				
				gui.dataReceiver();
			}
		});
	}
	
	public static void pause() {
	    try {
	      System.in.read();
	    } catch (IOException e) { }
	  }
	
	public static void main(String args[]) {
		Main runner = new Main();
		
		runner.setFrame();
	}
}
