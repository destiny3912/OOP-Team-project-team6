package Program;
import java.awt.Frame;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class Edit extends updateGUI implements ActionListener{
	MyFrame frame3 = new MyFrame();
	JButton eName = new JButton("Name");
	JButton eAmount = new JButton("Amount");
	JButton eCategory = new JButton("Category");
	JButton eConfirm = new JButton("Confirm");
	JButton eCancel = new JButton("Cancel");
	
	private JTextField tName;
	private JTextField tAmount;
	private JTextField tCategory;
	int index ;
	String name=null, amount=null, category=null;
	public Edit(int index) {
		frame3.getContentPane().setEnabled(false);
		frame3.setTitle("Update");
		frame3.setSize(409, 295);
		frame3.setLocation(550, 350);
		frame3.setDefaultCloseOperation(frame3.EXIT_ON_CLOSE);
		
		this.index = index - 1;
		
		// Set the button for update and text field
		JLabel lblNewLabel = new JLabel("Update");
		lblNewLabel.setBounds(12, 10, 47, 23);
		frame3.getContentPane().add(lblNewLabel);
		
		eName.setBounds(275, 33, 105, 25);
		frame3.getContentPane().add(eName);
		
		eAmount.setBounds(275, 63, 105, 25);
		frame3.getContentPane().add(eAmount);
		
		eCategory.setBounds(275, 93, 105, 25);
		frame3.getContentPane().add(eCategory);
		
		eCancel.setBounds(218, 222, 105, 25);
		frame3.getContentPane().add(eCancel);

		eConfirm.setBounds(61, 222, 105, 25);
		frame3.getContentPane().add(eConfirm);
		
		JLabel name = new JLabel("Name : ");
		name.setBounds(12, 40, 57, 15);
		frame3.getContentPane().add(name);
		
		JLabel amount = new JLabel("Amount : ");
		amount.setBounds(12, 70, 57, 15);
		frame3.getContentPane().add(amount);
		
		JLabel category = new JLabel("Category : ");
		category.setBounds(12, 100, 57, 15);
		frame3.getContentPane().add(category);
		
		tName = new JTextField();
		tName.setEditable(false);
		tName.setBounds(80, 40, 175, 21);
		//tName.s
		frame3.getContentPane().add(tName);
		tName.setColumns(10);
		
		tAmount = new JTextField();
		tAmount.setEditable(false);
		tAmount.setColumns(10);
		tAmount.setBounds(80, 70, 175, 21);
		frame3.getContentPane().add(tAmount);
		
		tCategory = new JTextField();
		tCategory.setEditable(false);
		tCategory.setColumns(10);
		tCategory.setBounds(80, 100, 175, 21);
		frame3.getContentPane().add(tCategory);
		
		tName.setText(list.get(this.index).getName());
		tAmount.setText(Integer.toString(list.get(this.index).getAmount()));
		tCategory.setText(list.get(this.index).getCategory());
	
		frame3.setVisible(true);
		eName.addActionListener(this);
		eAmount.addActionListener(this);
		eCategory.addActionListener(this);
		eCancel.addActionListener(this);
		eConfirm.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		int check;
		// Check if button is clicked to update
		if(e.getSource() == eName){
			check = JOptionPane.showConfirmDialog(this, "Update?\n" + 
					"Name : " + tName.getText() ,"Message", JOptionPane.INFORMATION_MESSAGE );
			if(check ==0){
				name = JOptionPane.showInputDialog("Update your name", list.get(this.index).getName());
				tName.setText(name);
				if(name == null){
					tName.setText(list.get(this.index).getName());
				}
			}
		}else if(e.getSource() == eAmount){
			check = JOptionPane.showConfirmDialog(this, "Update?\n" + 
					"Amount : " + tAmount.getText() ,"Message", JOptionPane.INFORMATION_MESSAGE );
			if(check ==0){
				amount = JOptionPane.showInputDialog("Update your amount", list.get(this.index).getAmount());
				tAmount.setText(amount);
				if(amount == null){
					tAmount.setText(Integer.toString(list.get(this.index).getAmount()));
				}
			}
		}else if(e.getSource() == eCategory){
			check = JOptionPane.showConfirmDialog(this, "Update?\n" + 
					"Amount : " + tCategory.getText() ,"Message", JOptionPane.INFORMATION_MESSAGE );
			if(check ==0){
				category = JOptionPane.showInputDialog("Update your category", list.get(this.index).getCategory());
				tCategory.setText(category);
				if(category == null){
					tCategory.setText(list.get(this.index).getCategory());
				}
			}
		}
		// If update will be progress by confirm button, change the value.
		if(e.getSource() == eConfirm){
			if( name != null){
				list.get(this.index).setName(this.name);
			}
			if(amount != null){
				list.get(this.index).setAmount(Integer.parseInt(this.amount));
			}
			if(category != null){
				list.get(this.index).setCategory(this.category);
			}
			frame3.dispose();
			updateGUI m = new updateGUI();
		}else if(e.getSource() == eCancel){
			// Move to upper class
			frame3.dispose();
			updateGUI m = new updateGUI();
		}
		//list.get(this.index).setName(name);
	}
}
