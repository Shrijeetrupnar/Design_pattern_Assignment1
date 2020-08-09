package wordPlay.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import wordPlay.driver.Driver;
import wordPlay.handler.WordRotator;
import wordPlay.metrics.MetricsCalculator;


/**
 *  WordPlay Result class  *
 * This class has  methods to store and get result.
 * @author Shrijeet Rupnar
 * @version 1.0.
 * @since   06-08-2020
 */


public class Results implements FileDisplayInterface, StdoutDisplayInterface

{

	private String inputFileName;
	private String outputFilePath;
	private String metricsFilePath;
	private int numberOfLines=0;
	private int numberOfWords=0;
	private int eachWordLength=0;
	private int Total=0;

	//list is data Structure is used to hold the result.
	private List<String> list = new ArrayList<String>();


	public int getNumberOfLines() {
		return numberOfLines;
	}


	public int getNumberOfWords() {
		return numberOfWords;
	}


	public int getEachWordLength() {
		return eachWordLength;
	}


	public int getTotal() {
		return Total;
	}




	public List<String> getList() {
		return list;
	}


	public Results(String[] s) {

		this.inputFileName=s[0];
		this.outputFilePath=s[1];
		this.metricsFilePath=s[2];


	}




	/**
	 * This is the method is used to fetch word from input file, word by word.
	 * and send for processing to WordRotator class.
	 * @param no parameter
	 * @return no return type
	 * @author  Shrijeet Rupnar
	 * @version 1.0
	 * @since   06-08-2020
	 */
	public void getWord() {

		try {
			// System.out.println("\nIn Result class");

			FileProcessor fp= new FileProcessor(this.inputFileName);

			String poll;
			String result;
			int counter=0;
			boolean fullstop = false;
			while((poll=fp.poll())!=null&&!(poll.isEmpty()))
			{
				eachWordLength=poll.length();
				Total+=eachWordLength;
				counter++;
				if(poll.matches(".*\\."))
				{
					numberOfLines++;
					fullstop = true;
				}
				else
				{
					if(!poll.matches("^[a-zA-Z0-9]*$"))
					{
						System.err.println("Input File is in Invalid format....");
						System.exit(0);
					}
				}


				if(!fullstop){

					WordRotator w= new WordRotator();
					result=w.rotation(poll, counter);
					store(result);

				}//if
				else{

					WordRotator w= new WordRotator();
					result=w.fullStoprotation(poll, counter);
					fullstop=false;
					numberOfWords=numberOfWords+counter;
					counter=0;
					store(result);

				}//else

			}//while


		} catch (InvalidPathException e) {
			// TODO Auto-generated catch block
			System.out.println("\nException in File Path...");
		}
		catch(SecurityException e)
		{
			System.out.println("\nException in Security...");
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			System.out.println("\nPlease check Input File...");
		} 
		catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
			System.out.println("\n Not valid Input file...");
			System.exit(0);
		}
		catch(IOException e)
		{
			System.out.println("\n Input Output Exception...");
		}



	}//getword()




	/**
	 * This is the method is used to perform write operation
	 * @param list of String and outputfilepath as String
	 * @return no return value
	 * @author  Shrijeet Rupnar
	 * @version 1.0
	 * @since   06-08-2020
	 */

	@Override
	public void writeToFile(List<String> s, String outputFilePath) {
		// TODO Auto-generated method stub

		File myObj = new File(outputFilePath);
		try {
			myObj.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.err.println("Could not create new file");
		}

		try {

			for(int i=0;i<list.size();i++)
			{

				String str=list.get(i);
				Files.write(Paths.get(outputFilePath), (str+" ").getBytes(),StandardOpenOption.APPEND);
				if(str.matches(".*\\.")){
					Files.write(Paths.get(outputFilePath), ("\n").getBytes(),StandardOpenOption.APPEND);
				}
			}//for
		}//try
		catch(IOException e) {
			System.err.println("Exception: writing to output.txt");
			System.err.println("Exiting...");
			System.exit(0);
		}
	}


	/**
	 * This is the method is used to perform write operation to metrics file
	 * @param  String and matricsfilepath as String
	 * @return no return value
	 * @author  Shrijeet Rupnar
	 * @version 1.0
	 * @since   06-08-2020
	 */

	public void writeToFile(String s, String metricsFilePath) {

		File myObj = new File(metricsFilePath);
		try {
			myObj.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.err.println("Could not create new file");
		}

		try {

			Files.write(Paths.get(this.metricsFilePath), (s+" ").getBytes(),StandardOpenOption.APPEND);
			if(s.matches(".*\\."))
			{
				Files.write(Paths.get(this.metricsFilePath), ("\n").getBytes(),StandardOpenOption.APPEND);
			}
		}
		catch(IOException e) {
			System.err.println("Exception: writing to metrics.txt");
			System.err.println("Exiting...");
			System.exit(0);
		}
	}


	/**
	 * This is the method is used to store ouput in List data structure
	 * @param String
	 * @return no return value
	 * @author  Shrijeet Rupnar
	 * @version 1.0
	 * @since   06-08-2020
	 */


	public void store(String s){

		list.add(s);

	}//store




	/**
	 * This is the method is used to perform write operation on console
	 * @param no parameter
	 * @return no return value
	 * @author  Shrijeet Rupnar
	 * @version 1.0
	 * @since   06-08-2020
	 */

	@Override
	public void writeToStdout() {
		// TODO Auto-generated method stub

		System.out.println("\n OUTPUT FILE : \n");

		for(int i=0;i<list.size();i++)
		{
			String str=list.get(i);
			if(str.matches(".*\\.")){
				System.out.print(str+"\n");
			}
			else{
				System.out.print(str+" ");
			}

		}//for
	}//writeToStdout



	/**
	 * This is the method is used to perform write operation on console
	 * @param String
	 * @return no return value
	 * @author  Shrijeet Rupnar
	 * @version 1.0
	 * @since   06-08-2020
	 */

	public void writeToStdOut(String str1,String str2){

		System.out.println("\n METRICS FILE :\n");
		System.out.println(str1);
		System.out.println(str2);

	}//writeToStdOut
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "";
	}

}
