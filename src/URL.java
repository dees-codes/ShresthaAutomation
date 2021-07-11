import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.math.RoundingMode;

/**
 * @author ds6546
 * Class for storing and processing URL information
 */
public class URL {
	String url;
	String command;
	ProcessBuilder processBuilder;
	Process process;
	double estimated_RTT;
	double DevRtt;
	double to;
	boolean isfirstTime = true;
	int time_keeper;
	FileWriter writer;
	String filename;

	/**
	 * URL constructor that creates a URL object
	 * @param url the link to be pinged
	 * @param filename the name of file in which response is recorded
	 */
	public URL(String url, String filename)
	{
		// Passing bash command and creating file
		command = "ping -c 1 -w 5000 " + url ;
		String[] str = {"bash", "-c", command};
		processBuilder = new ProcessBuilder(str);	
		createFile(filename);
	}

	/**
	 * Creates file with 'filename'
	 * @param filename the name of the created file
	 */
	private void createFile(String filename){
		File myObj = new File(filename);
		try{
            myObj.createNewFile();
            writer = new FileWriter(myObj);
		} catch (IOException e) {
			System.out.println("Problem with file processing");
		}
	}
	
	/**
	 * Method to be called from main to start processing the ping command
	 */
	public void startProcessBuilder()
	{
		try{
			process = processBuilder.start();
		} catch (IOException e) {
			System.out.println("Problem with processing");
		}
	}
	
	/**
	 * Reads, calculates and writes into files
	 */
	public void readAndWrite(){
		// Regex expression to extract time from ping response
        Pattern pattern = Pattern.compile("time=\\d+\\.*\\d+");
        Matcher m = null;
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(process.getInputStream()));
        
        String to_write_line;
        String line;
        
        try
        {
        	while ((line = reader.readLine()) != null) {
        		System.out.println(line);
        		m = pattern.matcher(line);
        		// If response received and time is extracted, do calculations and record in files
        		if (m.find()) {
        			double sampleRTT = Double.valueOf(m.group(0).substring(5));
        			if (isfirstTime)
        			{
        				estimated_RTT = sampleRTT;
        				isfirstTime = false;
        			}
        			estimated_RTT = (1 - 0.125) * estimated_RTT + 0.125 * sampleRTT;
        			DevRtt = (1 - 0.25) * DevRtt + 0.25 * Math.abs(sampleRTT - estimated_RTT);
        			to = estimated_RTT + 4*DevRtt;
        			to_write_line = time_keeper + " " + round(sampleRTT, 2) + " " +
        					round(estimated_RTT,2) + " " + round(to,2) + " " + "\n";
                	writer.write(to_write_line);
        		}
        	}                 
        } catch (IOException e) {
			System.out.println("Problem with processing");
		}
        System.out.println("-------------------------------------");
        time_keeper += 5;
	}
	
	/**
	 * Method to be called from main to close file
	 */
	public void closeFile()
	{
		try {
			writer.close();
		} catch (IOException e) {
			System.out.println("Problem with processing");
		}
	}
	
	/**
	 * Method for rounding off doubles
	 * @param value the number to be rounded
	 * @param places the number of decimal places to be rounded to
	 * @return the rounded number
	 */
	public double round(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();
		BigDecimal bd = new BigDecimal(Double.toString(value));
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}
