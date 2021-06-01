/**
 * Receive targetTime from user if targetTime and currentTime is same scan file stockData and print out list of lack of stock
 * @author LeeJiHo
 * @version alpha 0.5.0
 * @date 2021.06.01
 */
package Program;
import java.util.Date;
import java.util.LinkedList;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStream;


public class realTime{
	private String currentTime;// store current time variable
	private String targetTime;// store target time which received from user
	public LinkedList<String> list= new LinkedList<String>();//implement linked-list
	
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
		System.out.println(targetTime);
	}
	
	//Check target time and current time is same if same return 1 else return 0
	public int isSameToTargetTime()
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
		String line;
		
		//Read 1 line text from file if it is out of stock add to linked-list
		try
		{
			File data = new File("Stocks.txt");
			FileReader filereader = new FileReader(data);
			BufferedReader buffer = new BufferedReader(filereader);
			
			while((line = buffer.readLine()) != null)
			{
				if(isOutOfStock(line) == true)
				{
					list.add(line);//add to linked-list
				}				
			}
			
			buffer.close();
		}catch(FileNotFoundException e) {
			System.out.println("Cannot found file : " + e.getMessage());
		}catch(IOException e) {
			System.out.println("Something wrong in file : " + e.getMessage());
		}	
	}
	
	//check stock data it is out of stock
	public boolean isOutOfStock(String line)
	{
		String[ ] data = line.split(",");
		
		if(Integer.parseInt(data[1]) < 50)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public static void main(String args[])
	{
		
	}
}
