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

	public String getPosterPath() {
		return getString("poster_path");
	}

	public String getProductionCompanies() {
		return getString("production_companies");
	}

	public String getProductionCountries() {
		return getString("production_countries");
	}

	public String getReleaseDate() {
		return getString("release_date");
	}

	public int getRevenue() {
		return getInteger("revenue");
	}

	public int getRuntime() {
		return getInteger("runtime");
	}

	public String getSpokenLanguages() {
		return getString("spoken_languages");
	}

	public String getStatus() {
		return getString("status");
	}

	public String getTagline() {
		return getString("tagline");
	}

	public String getTitle() {
		return getString("title");
	}

	public float getVoteAverage() {
		return getFloat("vote_average");
	}

	public int getInteger(String key) {

		int start = movie.indexOf("\"" + key + "\"") + key.length() + 3;
		int stop = movie.indexOf("\"", start);
		return Integer.parseInt(movie.substring(start, stop));

	}

	public float getFloat(String key) {

		int start = movie.indexOf("\"" + key + "\"") + key.length() + 3;
		int stop = movie.indexOf("\"", start);
		return Float.parseFloat(movie.substring(start, stop));

	}
}
