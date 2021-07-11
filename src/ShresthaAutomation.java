// Deepson Shrestha - Automation Pinger (version 1.0.0)

import java.io.IOException;
import java.util.ArrayList;

public class ShresthaAutomation {
	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// ArrayList for storing URL objects
		ArrayList<URL> urlObjects = new ArrayList<URL>();
		
		// Creating URL objects and the name of the respective text files
		// to store data
		URL url1 = new URL("google.com", "google.txt");
		URL url2 = new URL("youku.com", "youku.txt");
		URL url3 = new URL("facebook.com", "facebook.txt");
		URL url4 = new URL("sxc.edu.np", "sxc.txt");
		URL url5 = new URL("bonjourdefrance.co.uk", "bonjourdefrance.txt");
		
		// Adding URL objects to the arraylist
		urlObjects.add(url1);
		urlObjects.add(url2);
		urlObjects.add(url3);
		urlObjects.add(url4);
		urlObjects.add(url5);
		
		// Loop for sending ping request 100 times per set of the array
		// list objects
		for(int i = 0; i < 100; i++)
		{
			// For each URL object in the array list, start the ping process
			// and read and write into respective files
			for(int k=0; k<urlObjects.size(); k++)
			{	
				urlObjects.get(k).startProcessBuilder();
				urlObjects.get(k).readAndWrite();
			}
			try {
				Thread.sleep(5*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		
		// Close all the files after writing
		for(int j=0; j<urlObjects.size(); j++)
		{
			urlObjects.get(j).closeFile();
		}
		
		// Execute the shell script to plot using gnuplot
		try{
			ProcessBuilder processBuilder = new ProcessBuilder();
			processBuilder.command("bash", "-c", "chmod +x plotter.sh");
			processBuilder.start();
			try {
				Thread.sleep(3*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			processBuilder.command("bash", "-c", "./plotter.sh");
			processBuilder.start();
			System.out.println("Graphs were successfully plotted.");
		} catch(IOException l)
		{
			System.out.println("Couldn't plot graphs");
			l.printStackTrace();
		}
		
	}

}
