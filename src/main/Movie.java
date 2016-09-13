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

	public String getString(String key) {

		int start = movie.indexOf("\"" + key + "\"") + key.length() + 4;
		int stop = movie.indexOf("\"", start);
		return movie.substring(start, stop);

	}

	public int getInteger(String key) {

		int start = movie.indexOf("\"" + key + "\"") + key.length() + 3;
		int stop = movie.indexOf("\"", start);
		return Integer.parseInt(movie.substring(start, stop));

	}

}
