package Program;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class updateGUI extends Main  implements ActionListener, ItemListener {
	MyFrame frame2 = new MyFrame();
	JButton edit = new JButton("Update");
	JButton cancel = new JButton("Back");
	JComboBox cb = new JComboBox();
	private JLabel select = new JLabel("Select product");
	private final JTextArea memInfo = new JTextArea();
	
	public updateGUI(){
		// Set the button for update and text field
		frame2.setTitle("Update");
		frame2.setSize(331, 285);
		frame2.setLocation(550, 350);
		frame2.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
	
		cb.setBounds(12, 39, 183, 21);
		// Read product by combo box
		cb.addItem("Select product");
		for(int i=0; i<list.size(); i++){
			cb.addItem(list.get(i).getName() + ". " + list.get(i).getAmount());
		}
		frame2.getContentPane().add(cb);
		
		edit.setBounds(207, 60, 97, 32);
		frame2.getContentPane().add(edit);

		cancel.setBounds(207, 120, 97, 32);
		frame2.getContentPane().add(cancel);

		memInfo.setEditable(false);
		memInfo.setBounds(12, 80, 183, 152);
		frame2.getContentPane().add(memInfo);
		
		edit.addActionListener(this);
		cancel.addActionListener(this);
		cb.addItemListener(this);

		
		frame2.setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent ie){
		if(cb.getSelectedIndex()!=0){
			int select = cb.getSelectedIndex()-1;
			// Selected, show it.
			memInfo.setText("Name : "+list.get(select).getName() + "\nAmount : "+ Integer.toString(list.get(select).getAmount())
					+ "\nSubclass : " + list.get(select).getCategory());
		}else{
			memInfo.setText(null);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == edit){
			// move to Edit function
			int select = cb.getSelectedIndex();
			Edit ed = new Edit(select);
			frame2.dispose();
		}else if(e.getSource() == cancel){
			// move to upper class
			frame2.dispose();
			super.setFrame();
		}
	}
}
