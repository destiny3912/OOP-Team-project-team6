package Program;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;

public class Search {
	private String findStock; //input Name,number,Expiration date,expire
	public LinkedList<String> list= new LinkedList<String>();//implement linked-list
	
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
	
	public void searchMethod(String data) throws IOException
	{
		String line; //txt line
		Scanner keyboard =new Scanner(System.in);
		File file = new File("Stocks.txt"); //file load
		BufferedReader in = null; 
		in = new BufferedReader( new FileReader("Stocks.txt")); //file read
		
		findStock = data; //sentence received store variable
		String[] findStockName = findStock.split(","); //sentence split, exact name
		    		
		try {
		while((line = in.readLine()) != null){ //file scan until null
			result = false; //Not find
		    String[] stockName = line.split(","); //exact StockName in txt
		     
		     if(stockName[0].trim().compareToIgnoreCase(findStockName[0].trim()) == 0){ //if success find
		      list.add(line);//add to linked-list
		      result= true; //find
		      break;
		      }
			}
		}
		catch (IOException e) {

		        System.err.println(e); // 에러가 있다면 메시지 출력

		        System.exit(1);

		    }
		
		catch(FileNotFoundException e) { //if fail to search stock 
		    System.out.println("Fail to find " +e.getMessage());
		}
		in.close(); //file close
	}
	
	public void printAllMethod() throws IOException{ //print all stock
		String line; //txt line
		Scanner keyboard =new Scanner(System.in);
		File file = new File("Stocks.txt"); //file load
		BufferedReader in = null;
		in = new BufferedReader( new FileReader("Stocks.txt")); //file read
		
		try {
		System.out.println("----Current number of Stock----");
		while((line = in.readLine()) != null){ //file scan
			list.add(line);//add to linked-list
		    }
			
		}
		catch (IOException e) {

		        System.err.println(e); // 에러가 있다면 메시지 출력

		        System.exit(1);

		    }
		in.close(); //file close
	}
}
