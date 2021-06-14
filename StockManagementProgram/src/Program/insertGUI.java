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
	JButton bt1 = new JButton("등록");
	JButton bt2 = new JButton("취소");
	MyFrame frame = new MyFrame();
	JRadioButton female;
	JRadioButton male;
	ButtonGroup bg = new ButtonGroup();
	
	public insertGUI(){
		frame.setTitle("회원등록");
		frame.setSize(500, 330);
		frame.setLocation(500, 300);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	
		JLabel mName = new JLabel("제품 이름 :");
		mName.setBounds(27, 16, 90, 30);
		frame.getContentPane().add(mName);
		
		JLabel mTotal = new JLabel("제품 개수 :");
		mTotal.setBounds(27, 56, 90, 30);
		frame.getContentPane().add(mTotal);
		
		JLabel mSpecial = new JLabel("제품 기한 :");
		mSpecial.setBounds(27, 96, 90, 30);
		frame.getContentPane().add(mSpecial);
		
		JLabel mSortClass = new JLabel("제품 품목 :");
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
			String memName = name.getText();
			int memTotal = Integer.parseInt(total.getText());
			String memSpecial = special.getText();
			String memSortClass = sortClass.getText();
			if(memName.equals("")){
				JOptionPane.showMessageDialog(this, "제품 이름을 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}else if(memTotal == 0){
				JOptionPane.showMessageDialog(this, "제품 개수를 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}else if(memSpecial.equals("")){
				JOptionPane.showMessageDialog(this, "제품 기한을 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}else if(memSortClass.equals("")){
				JOptionPane.showMessageDialog(this, "제품 품목을 입력해 주세요", "메시지", JOptionPane.INFORMATION_MESSAGE);
			}else{
					int check = JOptionPane.showConfirmDialog(this, "입력한 내용이 맞습니까?\n" + 
							memName  + "," + memTotal + "," + memSpecial + "," + memSortClass,
							"메시지", JOptionPane.INFORMATION_MESSAGE );
					if(check == 0){
						
						String temp = memSortClass;
						stockReadymade p = null;
					switch(temp) {
					case "Sauce"://가전제품 등록
						//가전제품용 인스턴스(저장 공간 만들기)
						p = new Sauce();
						break;
					case "Snack"://생필품 등록
						//생필품용 인스턴스(저장 공간 만들기)
						p = new Snack();
						break;
					case "Drink"://식품 등록
						//식품용 인스턴스(저장 공간 만들기)
						p = new Drink();
						break;
					default:
						JOptionPane.showMessageDialog(this, "품목 입력 오류", "메시지", JOptionPane.INFORMATION_MESSAGE);
					}
					
					p.setName(memName);
					p.setAmount(memTotal);
					p.setCategory(memSortClass);
					if(p instanceof Sauce) {
						Sauce ep = (Sauce)p;
						ep.setOrigin(memSpecial);
						JOptionPane.showMessageDialog(this, "물품 등록.", "메시지", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(p instanceof Snack) {
						Snack lp = (Snack)p;
						lp.setOrigin(memSpecial);
						JOptionPane.showMessageDialog(this, "물품 등록.", "메시지", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(p instanceof Drink){
						Drink fp = (Drink)p;
						fp.setPeriod(memSpecial);
						JOptionPane.showMessageDialog(this, "물품 등록.", "메시지", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(this, "품목 입력 오류", "메시지", JOptionPane.INFORMATION_MESSAGE);
					}
						
					}
			}
		}else if(e.getSource() == bt2){
			frame.dispose();
			super.setFrame();
		}
	}
	
	public boolean integerOrNot(String strData){ // 입력값이 숫자인지 문자인지 판별 : 
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

