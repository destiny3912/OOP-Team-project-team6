package Program;
import java.util.ArrayList;
import java.util.Scanner;


public class stockReadymade {
	private String name;//Name
	private String readyMadeCategory; //Category
	private int amount;//Amount
	
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
		String str = "Name: " + name + "\n"
				+ "Amount: " + amount + "\n"
				+ "Category: " + readyMadeCategory + "\n";
		return str;
	}
}
