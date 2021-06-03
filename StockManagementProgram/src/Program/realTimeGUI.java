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
	
	JDialog dialog = new JDialog();//�ð��� �޴� �˾�â Dialog
	JDialog textDialog = new JDialog();//����� ����ϴ� �˾�â Dialog
	private JButton timeEnter = new JButton("Enter");//�ð��� �Է��ϴ� Ʈ���� ��ư
	private JTextField textfield = new JTextField(20);//��� ����ϴ� �ؽ�Ʈ�ʵ�
	private ActionListener ac = new ac();//��ư actionListener
	private String time;//�ð� �����ϴ� String
	JTextField name,age;
	
	public void setDialog()//set �ð��Է� Dialog
	{
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		dialog.setLayout(new FlowLayout());//set dialog
		dialog.setSize(640,200);//set dialog size
		
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
			
			while(e.getSource() == timeEnter)//��ư�� ��������
			{	
				time = textfield.getText();//�Էµ�
				
				data.setTargetTime(time);//realTime class�� targetTime set
				
				while(data.isSameToTargetTime() == 0)//���ð��� targetTime�� ������ ��Ʈ Ż��
				{
					if(data.isSameToTargetTime() == 1)
					{
						break;
					}
				}
				
				data.findLackStock();//������ ���� ������ Stock�� ã�Ƽ�
				
				printOnGUI(data);//����Ʈ
				
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}
