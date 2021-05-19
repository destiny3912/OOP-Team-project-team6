/**
 * Receive targetTime from user if targetTime and currentTime is same scan file stockData and print out list of lack of stock
 * @author LeeJiHo
 * @version alpha 0.2.0
 * @date 2021.05.19
 */
package Program;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class realTime {
	private String currentTime;// store current time variable
	private String targetTime;// store target time which received from user
	
	//set current time only Hour/minute/seconds
	private void setCurrentTime()
	{
		String pattern = "HH:mm:ss";//Time string format
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		
		currentTime  = format.format(new Date());
	}
	
	public void setTargetTime(String newTargetTime)//set Target time
	{
		targetTime = newTargetTime;
	}
	
	//Check target time and current time is same if same return 1 else return 0
	private int isSameToTagetTime()
	{
		this.setCurrentTime();//set current time
		
		if(currentTime.equalsIgnoreCase(targetTime))
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	//Scan data file and find stock which is lack of left number
	public void findLackStock()
	{
		LinkedList<String> list= new LinkedList<String>();
		String line;
		
		try
		{
			File data = new File("Stocks.txt");
			FileReader filereader = new FileReader(data);
			BufferedReader buffer = new BufferedReader(filereader);
			
			while((line = buffer.readLine()) != null)
			{
				if(isOutOfStock(line))
				{
					list.add(line);
				}				
			}
		}catch(FileNotFoundException e) {
			
		}catch(IOException e) {
			System.out.println(e);
		}
		
		
	}
	
	//check stock data it is out of stock
	public boolean isOutOfStock(String line)
	{
		String[ ] data = line.split("|");
		
		if(Integer.getInteger(data[1]) < 5)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void waitForUserExit()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Time checker is running if you stop please enter any integer number");
		while(keyboard.hasNextInt() || this.isSameToTagetTime() == 1)
		{
			if(this.isSameToTagetTime() == 1)
			{
				System.out.println("Times up");
				break;
			}
			else
			{
				System.out.println("End time counting");
				break;
			}
		}
	}
	
	public static void main(String args[])
	{
		realTime test = new realTime();
		
		test.setTargetTime("09:04:30");
		test.waitForUserExit();
	}
	
}
