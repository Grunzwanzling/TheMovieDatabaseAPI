/**
 * 
 */
package main;

/**
 * @author Maximilian
 *
 */
public class Movie {

	String movie;

	public Movie(String content) {
		movie = content;
	}

	private String getString(String movie, String key) {

		int start = movie.indexOf("\"" + key + "\"") + key.length() + 4;
		int stop = movie.indexOf("\"", start);
		return movie.substring(start, stop);

	}

	private int getInteger(String movie, String key) {

		int start = movie.indexOf("\"" + key + "\"") + key.length() + 3;
		int stop = movie.indexOf("\"", start);
		return Integer.parseInt(movie.substring(start, stop));

	}

}
