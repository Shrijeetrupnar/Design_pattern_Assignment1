package wordPlay.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

import wordPlay.handler.WordRotator;
import wordPlay.metrics.MetricsCalculator;
import wordPlay.util.FileProcessor;
import wordPlay.util.Results;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * WordPlay Driver class *
 * The word play program implements rotation of each and every word from input file based on their index.
 * Write the results to output file and also to calculate certain metrics.
 *
 * @author Shrijeet Rupnar
 * @version 1.0
 * @since   06-08-2020
 *
 */
public class Driver {

	/**
	 * This is main method
	 * As the build.xml specifies the arguments as input,output or metrics, in case the
	 * argument value is not given java takes the default value specified in
	 * build.xml. To avoid that, below condition is used
	 * Firstly, code compare count of words from input file with processed word count
	 * 
	 * @param args will have inputfilepath, outputfilepath, metricsfilepath as arguments.
	 * @return Nothing
	 * @exception IOException,IllegalArgumentException,FileNotFoundException On input error,.
	 */

	public static void main(String[] args) {



		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("---------------------------Design Patterns------------------------------------------------");
		System.out.println("---------------------Assignment-1 - Summer -2020------------------------------------------");
		System.out.println("-----------------Welcome to Words Rotation Assignment------------------------------------ ");
		System.out.println("------------------------------------------------------------------------------------------\n");

		if ((args.length != 3) || (args[0].equals("${input}")) || (args[1].equals("${output}")) || (args[2].equals("${metrics}"))) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
			System.exit(0);
		}

		//Reading Input file for Validation check purpose(only 1 read)
		File newFile = new File(args[0]);
		int countofwords=0;
		File file = new File(args[0]);
		try(Scanner sc = new Scanner(new FileInputStream(file)))
		{

			while(sc.hasNext()){
				sc.next();
				countofwords++;
			}

			//System.out.println("Number of words: " + count);
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			System.out.println("\nInput File Not present...");
			System.exit(0);
		} 


		//Enter inside only when input file is not NULL
		if(args[0]!=null && !"".equals(args[0]) && newFile.length()!=0)
		{

			Results s= new Results(args);
			s.getWord();


			if(s.getNumberOfWords() < countofwords)
			{
				System.err.println("\nInvalid Input file format....");
				System.out.println("\nTry Again ....");
				System.out.println("\nExiting....");
				System.exit(0);
			}


			s.writeToFile(s.getList(), args[1]);
			MetricsCalculator mc= new MetricsCalculator();
			String str1=mc.getMetricsCalculator(s.getNumberOfWords(), s.getNumberOfLines());
			String str2=  mc.getMetricsCalculator1(s.getNumberOfWords(), s.getNumberOfLines(), s.getTotal());
			s.writeToFile(str1,args[2]);		
			s.writeToFile(("\n"+str2), args[2]);
			s.writeToStdout();
			s.writeToStdOut(str1,str2);	



		}
		else
		{
			throw new IllegalArgumentException("Invalid Input File or Input file is Empty or Input file is not mentioned...!!!");
		}


		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("Thank you ....");
		System.out.println("Exiting....");
		System.out.println("------------------------------------------------------------------------------------------");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "";
	}
}
