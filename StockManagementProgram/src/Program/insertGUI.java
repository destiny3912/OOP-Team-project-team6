package Program;


import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class insertGUI extends Main implements ActionListener {
	private JTextField name;
	private JTextField total;
	private JTextField special;
	private JTextField sortClass;
	JButton bt1 = new JButton("Confirm");
	JButton bt2 = new JButton("Cancel");
	MyFrame frame = new MyFrame();
	JRadioButton female;
	JRadioButton male;
	ButtonGroup bg = new ButtonGroup();
	
	public insertGUI(){
		// Set 4 category button and text field.
		frame.setTitle("Insert");
		frame.setSize(500, 330);
		frame.setLocation(500, 300);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		// Set the button for update and text field
		JLabel mName = new JLabel("Name :");
		mName.setBounds(27, 16, 90, 30);
		frame.getContentPane().add(mName);
		
		JLabel mTotal = new JLabel("Amount :");
		mTotal.setBounds(27, 56, 90, 30);
		frame.getContentPane().add(mTotal);
		
		JLabel mSpecial = new JLabel("Special :");
		mSpecial.setBounds(27, 96, 90, 30);
		frame.getContentPane().add(mSpecial);
		
		JLabel mSortClass = new JLabel("Category :");
		mSortClass.setBounds(27, 141, 90, 30);
		frame.getContentPane().add(mSortClass);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(97, 21, 62, 21);
		frame.getContentPane().add(name);
	
		total = new JTextField();
		total.setColumns(10);
		total.setBounds(97, 61, 62, 21);
		frame.getContentPane().add(total);
		
		special = new JTextField();
		special.setColumns(10);
		special.setBounds(97, 101, 144, 21);
		frame.getContentPane().add(special);
		
		sortClass = new JTextField();
		sortClass.setColumns(10);
		sortClass.setBounds(97, 141, 62, 21);
		frame.getContentPane().add(sortClass);

		bt1.setBounds(97, 232, 97, 40);
		frame.getContentPane().add(bt1);
		
		bt2.setBounds(280, 232, 97, 40);
		frame.getContentPane().add(bt2);
		
		frame.setVisible(true);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String memSex = null;
		boolean  StringCheck = true;
		if(e.getSource() == bt1){
			// Setup string and integer by text
			String memName = name.getText();
			int memTotal = Integer.parseInt(total.getText());
			String memSpecial = special.getText();
			String memSortClass = sortClass.getText();
			
			// If text field gets null,
			if(memName.equals("")){
				JOptionPane.showMessageDialog(this, "Enter name", "Message", JOptionPane.INFORMATION_MESSAGE);
			}else if(memTotal == 0){
				JOptionPane.showMessageDialog(this, "Enter amount", "Message", JOptionPane.INFORMATION_MESSAGE);
			}else if(memSpecial.equals("")){
				JOptionPane.showMessageDialog(this, "Enter special", "Message", JOptionPane.INFORMATION_MESSAGE);
			}else if(memSortClass.equals("")){
				JOptionPane.showMessageDialog(this, "Enter category", "Message", JOptionPane.INFORMATION_MESSAGE);
			}else{
				//If all text field is not null,
				
					int check = JOptionPane.showConfirmDialog(this, "Is the right data?\n" + 
							memName  + "," + memTotal + "," + memSpecial + "," + memSortClass,
							"Message", JOptionPane.INFORMATION_MESSAGE );
					if(check == 0){
					// In the same method as fileload inserting.
					String temp = memSortClass;
					// Same method as file load
					stockReadymade p = null;
					switch(temp) {
					case "Sauce":
						p = new Sauce();
						break;
					case "Snack":
						p = new Snack();
						break;
					case "Drink":
						p = new Drink();
						break;
					default:
						JOptionPane.showMessageDialog(this, "Wrong", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
					
					p.setName(memName);
					p.setAmount(memTotal);
					p.setCategory(memSortClass);
					
					// Insert by three cases, and setup new message GUI
					if(p instanceof Sauce) {
						Sauce ep = (Sauce)p;
						ep.setOrigin(memSpecial);
						JOptionPane.showMessageDialog(this, "Inserted.", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(p instanceof Snack) {
						Snack lp = (Snack)p;
						lp.setOrigin(memSpecial);
						JOptionPane.showMessageDialog(this, "Inserted.", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(p instanceof Drink){
						Drink fp = (Drink)p;
						fp.setPeriod(memSpecial);
						JOptionPane.showMessageDialog(this, "Inserted.", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(this, "Error", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
					list.add(p);
					}
			}
		}else if(e.getSource() == bt2){
			// move to upperclass
			frame.dispose();
			super.setFrame();
		}
	}
	
	public boolean integerOrNot(String strData){ 
		// Function it is integer or not
		char[] charData = strData.toCharArray();
		boolean check=true;
		while(check){
			for(int i=0; i<charData.length; i++){		
				if(!Character.isDigit(charData[i])){
						check = !check;
						break;
				}
			}
			break;	
		}return check;
	}
}

