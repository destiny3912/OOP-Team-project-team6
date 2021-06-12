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
		frame.setLayout(new GridLayout(2,1));//frame Layout 세로 2칸 가로 1칸의 GridLayout
		
		JPanel textPanel = new JPanel();// 상단 프로그램 설명 텍스트 Panel
		JPanel buttonPanel = new JPanel();//하단 기능 버튼 집합 Panel
		
		JLabel headText1 = new JLabel("Please select functions to run");//상단 프로그램 설명 텍스트 : 추후 적절한 텍스트 대체 예정
		headText1.setHorizontalAlignment(JLabel.CENTER);
		JLabel headText2 = new JLabel("If button disabled press refresh button");
		headText2.setHorizontalAlignment(JLabel.CENTER);
		
		frame.add(textPanel);//frame에 textPanel 추가
		frame.add(buttonPanel);//frame에 buttonPanel 추가
		
		buttonPanel.setLayout(new FlowLayout());//buttonPanel의 Layout == FlowLayout
		textPanel.setLayout(new GridLayout(2,1));
		
		//add buttons to buttonPanel
	
		buttonPanel.add(insertButton);
		buttonPanel.add(searchButton);
		buttonPanel.add(realTimeButton);
		buttonPanel.add(refreshButton);
		
		//add headText to textPanel
		textPanel.add(headText1);
		textPanel.add(headText2);
		
		insertButton.addActionListener(new ActionListener() { //insert
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//disable after button pressed
				insertButton.setEnabled(false);
				searchButton.setEnabled(false);
				realTimeButton.setEnabled(false);
				
				/*
				 * insert버튼에 연결할 두가지 기능을 연결할 팝업창 입니다.
				 * function1, function2 버튼의 이름을 각 기능의 이름으로 수정해주시고
				 * ExpainText에 기능설명같은 택스트를 넣어주시면 됩니다.
				 * 또한 각 기능은 하단의 addActionListener에 넣어주시면 됩니다.
				 * JLabel로 택스트 삽입할때 줄바꿈이 필요하시면 JLabel을 하나 더 생생해서
				 * textPanel에 추가하신뒤 textPanel의 Layout을 GridLayout(2,1)로 바꿔주시면 됩니다.
				 * 이외에 이해가지 않는 부분이 있으면 질문해주세요
				 * 작성자 이지호
				 * */
				//set insert
				JDialog selectInsert = new JDialog();
				selectInsert.setVisible(true);
				selectInsert.setLayout(new GridLayout(2,1));
				selectInsert.setSize(600,300);
				selectInsert.setDefaultCloseOperation(HIDE_ON_CLOSE);
				
				JPanel textPanel = new JPanel();
				JPanel buttonPanel = new JPanel();
				buttonPanel.setLayout(new FlowLayout());
				
				selectInsert.add(textPanel);
				selectInsert.add(buttonPanel);
				
				JLabel ExpainText = new JLabel("원하는 택스트 추가해주세요");
				JButton function1 = new JButton("Function1");
				JButton function2 = new JButton("Function2");
				
				textPanel.add(ExpainText);
				ExpainText.setHorizontalAlignment(JLabel.CENTER);
				buttonPanel.add(function1);
				buttonPanel.add(function2);
				
				function1.addActionListener(new ActionListener() { //insert
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						
					}
				});
				
				function2.addActionListener(new ActionListener() { //insert
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						
					}
				});
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
