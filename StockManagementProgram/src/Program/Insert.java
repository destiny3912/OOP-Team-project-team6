package Program;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileNotFoundException;

public class Insert {
	View pv = new View();
	stockReadyMadeService ps = new stockReadyMadeService();
	String name;
	int total;
	String special;
	String sortClass;
	String[][] stu_arr = new String[120][4];
	 public void getTxt() throws IOException{
		  try{
		   BufferedReader br=new BufferedReader(new FileReader(new File("123.txt")));  
		   String str="";
		  
		   str=br.readLine(); 
		  
		   int i=0;
		   while(str != null){  
			 String [] temp =str.split(",");
			name = temp[0];
			total = Integer.parseInt(temp[1]);
			special = temp[2];
			sortClass = temp[3];
			
			stockReadymade p = null;
			switch(temp[3]) {
			case "Sauce"://������ǰ ���
				//������ǰ�� �ν��Ͻ�(���� ���� �����)
				p = new Sauce();
				break;
			case "Snack"://����ǰ ���
				//����ǰ�� �ν��Ͻ�(���� ���� �����)
				p = new Snack();
				break;
			case "Drink"://��ǰ ���
				//��ǰ�� �ν��Ͻ�(���� ���� �����)
				p = new Drink();
				break;
			default:
				//�߸��� �޴� ��ȣ �Է¿� ���� �޽��� ���(�� Ŭ����)
			}
			
			p.setName(name);
			p.setAmount(total);
			p.setCategory(temp[3]);
			
			if(p instanceof Sauce) {
				Sauce ep = (Sauce)p;
				ep.setOrigin(special);
			}
			else if(p instanceof Snack) {
				Snack lp = (Snack)p;
				lp.setOrigin(special);
			}
			else {
				Drink fp = (Drink)p;
				fp.setPeriod(special);
			}
			boolean result = ps.registProd(p);
			if(result) {
				//���� �Ϸ� �޽��� ���(�� Ŭ����)
				System.out.println("Saved");
			}
			else {
				System.out.println("Not Saved");
			}
		   str=br.readLine();
		   i++;
		   }
		   ArrayList<stockReadymade> pList = ps.getStockList();
		   for(stockReadymade p : pList) {
			   System.out.println(p);
			}
		  }
		   catch(FileNotFoundException e){
		   System.out.println("���ϸ��� ã�� �� �����ϴ�.");
		  }catch(NullPointerException e){
		   System.out.println("Err : "+e);
		  } //end try-catch
		  
		  
	 } //end getTxt()
	 
	 private void printProduct() {
		 stockReadyMadeService ps = new stockReadyMadeService();
			ps.startPs();
			ArrayList<stockReadymade> pList = ps.getStockList();
			pv.printProduct(pList,0);
		}
	 
	 private void updateProduct() {
		 ArrayList<stockReadymade> pList = ps.getStockList();
	 }

	public static void main(String[] args) throws Exception {
		Insert obj=new Insert();
		 obj.getTxt(); //data.txt ���κ��� ���� �м�


		String fileName = "123.txt";
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new File(fileName));
				
		} catch (FileNotFoundException e) {
			System.out.println("Error");
			System.exit(0);
		}
		while(inputStream.hasNextLine())
		{
			String line = inputStream.nextLine();
			System.out.println(line);
		}
		inputStream.close();
	    }
}
