package Program;
import java.util.ArrayList;
import java.util.Scanner;


public class stockReadymade {
	private String name;//��ǰ��
	private String readyMadeCategory; //ī�װ�
	private int amount;//����
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return readyMadeCategory;
	}
	public void setCategory(String readyMadeCategory) {
		this.readyMadeCategory = readyMadeCategory;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		String str = "======================\n"
				+ "Name: " + name + "\n"
				+ "Amount: " + amount + "\n"
				+ "Category: " + readyMadeCategory + "\n";
		
		return str;
	}
}
