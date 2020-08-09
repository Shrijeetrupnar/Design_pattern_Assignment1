package wordPlay.metrics;

import java.text.DecimalFormat;

/**
 *  WordPlay Metrics class  *
 * This class has all the Metrics calculation methods like getMetricsCalculator and getMetricsCalculator1.
 * @author Shrijeet Rupnar
 * @version 1.0.
 * @since   06-08-2020
 */

public class MetricsCalculator {

	/**
	 * This is the method which will calculate AVG_NUM_WORDS_PER_SENTENCE.
	 * @param Integer numberOfWords and Integer numberOfLines
	 * @return String with count
	 * @author  Shrijeet Rupnar
	 * @version 1.0
	 * @since   06-08-2020
	 */


	public String getMetricsCalculator(int numberOfWords,int numberOfLines){

		double Averagenumberofwordsperline = numberOfWords/(float)numberOfLines;
		DecimalFormat f = new DecimalFormat("##.0");
		String s="AVG_NUM_WORDS_PER_SENTENCE - "+ f.format(Averagenumberofwordsperline);

		return s;

	}


	/**
	 * This is the method which will calculate AVG_WORD_LENGTH.
	 * @param Integer numberOfWords and Integer numberOfLines, Integer Total
	 * @return String with count
	 * @author  Shrijeet Rupnar
	 * @version 1.0
	 * @since   06-08-2020
	 */

	public String getMetricsCalculator1(int numberOfWords,int numberOfLines,int Total){

		double AVG_WORD_LENGTH=(Total-numberOfLines)/(float)numberOfWords;
		DecimalFormat f = new DecimalFormat("##.00");
		String s="AVG_WORD_LENGTH -"+ f.format(AVG_WORD_LENGTH);

		return s;

	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "";
	}



}
