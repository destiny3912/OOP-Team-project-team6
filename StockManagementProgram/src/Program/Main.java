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

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
import java.awt.*;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class Main extends JFrame{
	private JButton insertButton = new JButton("Insert stock data");
	private JButton searchButton = new JButton("Search stock data");
	private JButton realTimeButton = new JButton("Real time count");
	private JButton refreshButton = new JButton("Refresh");
	private JFrame frame = new JFrame();
	stockReadyMadeService ps = new stockReadyMadeService();
	static ArrayList<stockReadymade> list = new ArrayList<stockReadymade>();
	MyFrame frame1 = new MyFrame();
	
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
		
		JLabel headText1 = new JLabel("Please select functions to run");//��� ���α׷� ���� �ؽ�Ʈ : ���� ������ �ؽ�Ʈ ��ü ����
		headText1.setHorizontalAlignment(JLabel.CENTER);
		JLabel headText2 = new JLabel("If button disabled press refresh button");
		headText2.setHorizontalAlignment(JLabel.CENTER);
		
		frame.add(textPanel);//frame�� textPanel �߰�
		frame.add(buttonPanel);//frame�� buttonPanel �߰�
		
		buttonPanel.setLayout(new FlowLayout());//buttonPanel�� Layout == FlowLayout
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
				 * insert��ư�� ������ �ΰ��� ����� ������ �˾�â �Դϴ�.
				 * function1, function2 ��ư�� �̸��� �� ����� �̸����� �������ֽð�
				 * ExpainText�� ��ɼ����� �ý�Ʈ�� �־��ֽø� �˴ϴ�.
				 * ���� �� ����� �ϴ��� addActionListener�� �־��ֽø� �˴ϴ�.
				 * JLabel�� �ý�Ʈ �����Ҷ� �ٹٲ��� �ʿ��Ͻø� JLabel�� �ϳ� �� �����ؼ�
				 * textPanel�� �߰��Ͻŵ� textPanel�� Layout�� GridLayout(2,1)�� �ٲ��ֽø� �˴ϴ�.
				 * �̿ܿ� ���ذ��� �ʴ� �κ��� ������ �������ּ���
				 * �ۼ��� ����ȣ
				 * */
				//set insert
				JDialog selectInsert = new JDialog();
				selectInsert.setVisible(true);
				selectInsert.setLayout(new GridLayout(3,1));
				selectInsert.setSize(600,300);
				selectInsert.setDefaultCloseOperation(HIDE_ON_CLOSE);
				
				JPanel textPanel = new JPanel();
				JPanel buttonPanel = new JPanel();
				buttonPanel.setLayout(new FlowLayout());
				
				selectInsert.add(textPanel);
				selectInsert.add(buttonPanel);
				
				JLabel ExpainText = new JLabel("Insert or Update");
				JButton function1 = new JButton("Insert");
				JButton function2 = new JButton("Update");
				JButton function3 = new JButton("Insert file");
				
				textPanel.add(ExpainText);
				ExpainText.setHorizontalAlignment(JLabel.CENTER);
				buttonPanel.add(function1);
				buttonPanel.add(function2);
				buttonPanel.add(function3);
				
				function1.addActionListener(new ActionListener() { //insert
					private JTextArea theText;
					@Override
					public void actionPerformed(ActionEvent e)
					{
						frame.dispose();
						insertGUI ig = new insertGUI();
					}
				});
				
				function2.addActionListener(new ActionListener() { //update
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						frame.dispose();
						updateGUI ug = new updateGUI();
					}
				});

				function3.addActionListener(new ActionListener() { //file load
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						fileLoad("Stocks.txt");
						JOptionPane.showMessageDialog(null, "File updated", "�޽���", JOptionPane.INFORMATION_MESSAGE);
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
	
	public void fileLoad(String path){
		String name;
		int total;
		String special;
		String sortClass;
		
		try{
			   BufferedReader br=new BufferedReader(new FileReader(new File(path)));  
			   String str="";
			  
			   str=br.readLine(); 
			  
			   int i=0;
			   while(str != null){  
				   
				//Split file data and inserted to temperate data.
				String [] temp =str.split(",");
				name = temp[0];
				total = Integer.parseInt(temp[1]);
				special = temp[2];
				sortClass = temp[3];
				stockReadymade p = null;
				
				//Separate by 3 cases.
				switch(temp[3]) {
				case "Sauce":
					//Case by Sauce
					p = new Sauce();
					break;
				case "Snack":
					//Case by Snack
					p = new Snack();
					break;
				case "Drink":
					//Case by Drink
					p = new Drink();
					break;
				default:
					//Wrong Cases
				}
				// Setting data three cases
				p.setName(name);
				p.setAmount(total);
				p.setCategory(temp[3]);
				
				// Separate data and make new class, add arraylist
				if(p instanceof Sauce) {
					Sauce ep = (Sauce)p;
					ep.setOrigin(special);
					list.add(ep);
				}
				else if(p instanceof Snack) {
					Snack lp = (Snack)p;
					lp.setOrigin(special);
					list.add(lp);
				}
				else {
					Drink fp = (Drink)p;
					fp.setPeriod(special);
					list.add(fp);
				}
				boolean result = ps.registProd(p);
				if(result) {
					//If save is correct
					System.out.println("Saved");
				}
				else {
					//If save is wrong
					System.out.println("Not Saved");
				}
				//Read next new line
			   str=br.readLine();
			   i++;
			   }
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String args[]) {
		Main runner = new Main();
		
		runner.setFrame();
	}
}
