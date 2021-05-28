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
	private String findStock; //input Name,number,Expiration date,expire
	
	public String getFindStock() {//getter
		return findStock;
	}
	public void setFindStock(String findStock) {//setter
		this.findStock = findStock;
	}

	boolean result; //To determine whether or not present.
	
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
		File file = new File("Stocks.txt"); //file load
		BufferedReader in = null; 
		System.out.println("Enter stock to find:");
		 
		in = new BufferedReader( new InputStreamReader(System.in));  //input sentence
		findStock = in.readLine(); //sentence received store variable
		String[] findStockName = findStock.split(","); //sentence split, exact name
		    
		in = new BufferedReader( new FileReader("Stocks.txt")); //file read
		String line; //txt line
		
		try {
		while((line = in.readLine()) != null){ //file scan until null
			result = false; //Not find
		    String[] stockName = line.split(","); //exact StockName in txt
		     
		     if(stockName[0].trim().compareToIgnoreCase(findStockName[0].trim()) == 0){ //if success find
		      System.out.println("Stock Name: " + stockName[0].trim());
		      System.out.println("Stock Number: " + stockName[1]);
		      result= true; //find
		      break;
		      }
			}
		}
		catch (IOException e) {

		        System.err.println(e); // 에러가 있다면 메시지 출력

		        System.exit(1);

		    }
		
		if(result == false){ //if fail to search stock 
		    System.out.println("Fail to find " +findStock);
		    System.out.println("Don't have " +findStock +" in stock");
		    }
		in.close(); //file close
	}
	
	public void printAllMethod() throws IOException{ //print all stock
		Scanner keyboard =new Scanner(System.in);
		File file = new File("Stocks.txt"); //file load
		BufferedReader in = null;
		
		in = new BufferedReader( new FileReader("Stocks.txt")); //file read
		String line; //txt line
		
		try {
		System.out.println("----Current number of Stock----");
		while((line = in.readLine()) != null){ //file scan
		    System.out.println(line); //file output
		    }
			
		}
		catch (IOException e) {

		        System.err.println(e); // 에러가 있다면 메시지 출력

		        System.exit(1);

		    }
		in.close(); //file close
	}

public static void main(String[] args) throws IOException { //Temporary main 
	Search test = new Search();
	test.searchMethod(); 
	test.printAllMethod();
	}
}
