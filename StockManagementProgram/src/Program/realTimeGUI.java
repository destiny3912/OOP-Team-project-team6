/**
 * It is a class to create GUI for RealTime class
 * @author LeeJiHo
 * @version alpha 0.5.0
 * @date 2021.06.01
 */
package Program;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;

public class realTimeGUI extends JFrame{
	
	JDialog dialog = new JDialog();//시간을 받는 팝업창 Dialog
	JDialog textDialog = new JDialog();//결과를 출력하는 팝업창 Dialog
	private JButton timeEnter = new JButton("Enter");//시간을 입력하는 트리거 버튼
	private JTextField textfield = new JTextField(20);//결과 출력하는 텍스트필드
	private ActionListener ac = new ac();//버튼 actionListener
	private String time;//시간 저장하는 String
	JTextField name,age;
	
	public void setDialog()//set 시간입력 Dialog
	{
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		dialog.setLayout(new FlowLayout());//set dialog
		dialog.setSize(600,300);//set dialog size
		
		panel1.add(new JLabel("Real time timer"));
		panel2.add(new JLabel("Target time(24 Hour Style HH:mm:ss)"));
		panel2.add(textfield);//add textfield to frame
		dialog.add(panel1);
		dialog.add(panel2);
		dialog.add(timeEnter);//add button b1 to frame
		dialog.setVisible(true);
	}
	
	public String dataReturner()
	{
		return time;
	}
	
	public void dataReceiver()
	{
		timeEnter.addActionListener(ac);
	}
	
	public void printOnGUI(realTime data)
	{
		String target;
		
		textDialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);//Close frame
		textDialog.setSize(1000, 600);//set frame size
		
		TextArea text = new TextArea(20,50);//set text area
		textDialog.add(text);//add text area to frame
	
		for(int index = 0; index < data.list.size(); index++)
		{
			target = data.list.get(index);
			text.append((index + 1) + ": " + target + "\n");//print on text area
		}
		
		textDialog.setVisible(true);//set frame to visible
	}
	
	class ac implements ActionListener{//set action when press button b1
		
		realTime data = new realTime();
		String time;
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			while(e.getSource() == timeEnter)
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
