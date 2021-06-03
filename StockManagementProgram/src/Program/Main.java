/**
 * It is a main class in our program connect all function together and make user select execute function 
 * @author LeeJiHo
 * @version alpha 0.5.0
 * @date 2021.06.01
 */
package Program;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.io.*;
public class Main extends JFrame{
	private JButton insertButton = new JButton("Insert stock data");
	private JButton searchButton = new JButton("Search stock data");
	private JButton realTimeButton = new JButton("Real time count");
	private JFrame frame = new JFrame();
	
	/*
	 * This methods gather all function of this program
	 * 1. make three button for function insert, search, realTime
	 * 2. Press button new window pop up running each function
	 * 3. If Press Exit button on window program will stop
	 * */
	public void setFrame()
	{
		frame.setVisible(true);
		frame.setSize(640,480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		JPanel insertPanel = new JPanel();
		JPanel searchPanel = new JPanel();
		JPanel realTimePanel = new JPanel();
		
		frame.add(insertPanel);//button for insert
		frame.add(searchPanel);//button for search
		frame.add(realTimePanel);//button realTime
		
		insertPanel.add(insertButton);
		searchPanel.add(searchButton);
		realTimePanel.add(realTimeButton);
		
		insertButton.addActionListener(new ActionListener() { //insert
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//set insert
			}
		});
		
		searchButton.addActionListener(new ActionListener() { //search
			
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
		
		realTimeButton.addActionListener(new ActionListener() { //realTIme
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				realTimeGUI gui = new realTimeGUI();
				realTime data = new realTime();
				String time;

				gui.setDialog();
				
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
