/**
 * It is a main class in our program connect all function together and make user select execute function 
 * @author LeeJiHo
 * @version alpha 0.5.0
 * @date 2021.06.01
 */
package Program;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.io.*;

public class Main extends JFrame{
	private JButton insertButton = new JButton("Insert stock data");
	private JButton searchButton = new JButton("Search stock data");
	private JButton realTimeButton = new JButton("Real time count");
	private JButton refreshButton = new JButton("Refresh");
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
		frame.setSize(640,200);
		frame.setTitle("Stock management program");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(2,1));//frame Layout ���� 2ĭ ���� 1ĭ�� GridLayout
		
		JPanel textPanel = new JPanel();// ��� ���α׷� ���� �ؽ�Ʈ Panel
		JPanel buttonPanel = new JPanel();//�ϴ� ��� ��ư ���� Panel
		
		JLabel headText = new JLabel("It is a test version");//��� ���α׷� ���� �ؽ�Ʈ : ���� ������ �ؽ�Ʈ ��ü ����
		
		frame.add(textPanel);//frame�� textPanel �߰�
		frame.add(buttonPanel);//frame�� buttonPanel �߰�
		
		buttonPanel.setLayout(new FlowLayout());//buttonPanel�� Layout == FlowLayout
		
		//add buttons to buttonPanel
		buttonPanel.add(insertButton);
		buttonPanel.add(searchButton);
		buttonPanel.add(realTimeButton);
		buttonPanel.add(refreshButton);
		
		//add headText to textPanel
		textPanel.add(headText);
		
		insertButton.addActionListener(new ActionListener() { //insert
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//disable after button pressed
				insertButton.setEnabled(false);
				searchButton.setEnabled(false);
				realTimeButton.setEnabled(false);
				
				//set insert
			}
		});
		
		searchButton.addActionListener(new ActionListener() { //search
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//disable after button pressed
				insertButton.setEnabled(false);
				searchButton.setEnabled(false);
				realTimeButton.setEnabled(false);
				
				searchGUI gui = new searchGUI();

				gui.createFrame();
				
				gui.dataReceiver();
			}
		});
		
		realTimeButton.addActionListener(new ActionListener() { //realTIme
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//disable after button pressed
				insertButton.setEnabled(false);
				searchButton.setEnabled(false);
				realTimeButton.setEnabled(false);
				
				realTimeGUI gui = new realTimeGUI();

				gui.setDialog();
				
				gui.dataReceiver();
			}
		});
		
		refreshButton.addActionListener(new ActionListener() { //search
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				insertButton.setEnabled(true);
				searchButton.setEnabled(true);
				realTimeButton.setEnabled(true);
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
