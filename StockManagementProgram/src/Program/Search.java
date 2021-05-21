package Program;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.File;

public class Search {
	private String findStock;
	
	public String getFindStock() {//getter
		return findStock;
	}
	public void setFindStock(String findStock) {//setter
		this.findStock = findStock;
	}

	boolean result;
	
	//Default Constructor
	public Search() {
		findStock = null;
	}
	//Constructor
	public Search(String findStock)
	{
		this.findStock = findStock;
	}
	
	public void searchMethod() throws IOException
	{
		Scanner keyboard =new Scanner(System.in);
		File file = new File("test.txt");
		BufferedReader in = null;
		System.out.println("Enter stock to find:");
		 
		in = new BufferedReader( new InputStreamReader(System.in)); 
		findStock = in.readLine(); //input word
		    
		in = new BufferedReader( new FileReader("test.txt"));
		String line;
		
		try {
		while((line = in.readLine()) != null){ //file scan
			result = false;
		    String[] stockName = line.split(":"); //StockName:15
		     
		     if(stockName[0].trim().compareToIgnoreCase(findStock.trim()) == 0){ //if success find
		      System.out.println("Stock Name: " + stockName[0].trim());
		      System.out.println("Stock Number: " + stockName[1]);
		      result= true;
		      break;
		      }
			}
		}
		catch (IOException e) {

		        System.err.println(e); // 에러가 있다면 메시지 출력

		        System.exit(1);

		    }
		
		if(result == false){
		    System.out.println("Fail to find " +findStock);
		    System.out.println("Don't have " +findStock +" in stock");
		    }
		in.close();
	}
	
	public void printAllMethod() throws IOException{ //print all stock
		Scanner keyboard =new Scanner(System.in);
		File file = new File("test.txt");
		BufferedReader in = null;
		
		in = new BufferedReader( new FileReader("test.txt"));
		String line;
		
		try {
		while((line = in.readLine()) != null){ //file scan
			System.out.println("----Current number of Stock----");
		    System.out.println(line);
		    }
			
		}
		catch (IOException e) {

		        System.err.println(e); // 에러가 있다면 메시지 출력

		        System.exit(1);

		    }
		in.close();
	}

public static void main(String[] args) throws IOException {
	Search test = new Search();
	test.searchMethod(); 
	test.printAllMethod();
	}
}