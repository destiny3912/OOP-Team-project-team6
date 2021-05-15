/**
 * Receive targetTime from user if targetTime and currentTime is same scan file stockData and print out list of lack of stock
 * @author LeeJiHo
 * @version alpha 0.1.0
 * @date 2021.05.15
 */
package Program;
import java.util.Date;
import java.util.LinkedList;
import java.text.SimpleDateFormat;
import java.io.File;
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
	}
	
	public static void main(String args[])
	{
	
	}
	
}
