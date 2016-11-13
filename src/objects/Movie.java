/**
 * 
 */
package objects;

import java.util.ArrayList;

/**
 * @author <a href="http://grunzwanzling.me">Maximilian von Gaisberg
 *         (Grunzwanzling)</a>
 * 
 * @see <a href="http://grunzwanzling.me/TheMovieDatabaseAPI">javadoc</a>
 *
 */
public class Movie {

	public String movie;

	/**
	 * Create a <code>Movie</code> from the JSON API-return Don't use it, it is
	 * just for internal use!
	 * 
	 * @param content
	 *            The return of the API
	 */
	public Movie(String content) {
		movie = content;
	}

	/**
	 * Get one specific string of the movie
	 * 
	 * @param key
	 *            The key to get the value of
	 * @return The value
	 */
	public String getString(String key) {

		int start = movie.indexOf("\"" + key + "\"") + key.length() + 4;
		int stop = movie.indexOf("\"", start);
		return movie.substring(start, stop);

	}

	/**
	 * Get the poster Path of a movie
	 * 
	 * @return A string representing the relative path
	 */
	public String getPosterPath() {
		return getString("poster_path");
	}

	/**
	 * Get the production companies which worked on a move
	 * 
	 * @return A <code>ProductionCompany[]</code> with all the companies
	 */
	public ProductionCompany[] getProductionCompanies() {
		String content = getArray("production_companies");
		String pieces[] = content.split("}");
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> id = new ArrayList<String>();
		int i = 0;
		for (String string : pieces) {

			int start = string.indexOf("\"name\"") + 8;
			int stop = string.indexOf("\"", start);
			name.add(i, string.substring(start, stop));
			int start2 = string.indexOf("\"id\"") + 5;
			int stop2 = string.length();

			id.add(i, string.substring(start2, stop2));

			i++;
		}
		ProductionCompany[] companies = new ProductionCompany[i];
		for (int e = 0; e < i; e++) {
			companies[e] = new ProductionCompany((String) id.get(e),
					(String) name.get(e));
		}
		return companies;
	}

	/**
	 * Get the production countries which worked on a move
	 * 
	 * @return A <code>ProductionCountry[]</code> with all the countries
	 */
	public Country[] getProductionCountries() {
		String content = getArray("production_countries");
		String pieces[] = content.split("}");
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> id = new ArrayList<String>();
		int i = 0;
		for (String string : pieces) {

			int start = string.indexOf("\"name\"") + 8;
			int stop = string.indexOf("\"", start);
			name.add(i, string.substring(start, stop));
			start = string.indexOf("\"iso_3166_1\"") + 14;
			stop = string.indexOf("\"", start);
			id.add(i, string.substring(start, stop));
			i++;
		}
		Country[] countries = new Country[i];
		for (int e = 0; e < i; e++) {
			countries[e] = new Country((String) id.get(e), (String) name.get(e));
		}
		return countries;
	}

	/**
	 * Get the release date of the movie
	 * 
	 * @return A String representing the release day
	 */
	public String getReleaseDate() {
		return getString("release_date");
	}

	/**
	 * The approximate revenue of a movie
	 * 
	 * @return An Integer representing the revenue
	 */
	public int getRevenue() {
		return getInteger("revenue");
	}

	/**
	 * Get the runtime of the movie
	 * 
	 * @return An Integer
	 */
	public int getRuntime() {
		return getInteger("runtime");
	}

	/**
	 * Get the languages in which a movie is available
	 * 
	 * @return A <code>Language[]</code> with all the languages
	 */
	public Language[] getSpokenLanguages() {
		String content = getArray("spoken_languages");
		String pieces[] = content.split("}");
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> id = new ArrayList<String>();
		int i = 0;
		for (String string : pieces) {

			int start = string.indexOf("\"name\"") + 8;
			int stop = string.indexOf("\"", start);
			name.add(i, string.substring(start, stop));
			start = string.indexOf("\"iso_639_1\"") + 13;
			stop = string.indexOf("\"", start);
			id.add(i, string.substring(start, stop));
			i++;
		}
		Language[] languages = new Language[i];
		for (int e = 0; e < i; e++) {
			languages[e] = new Language((String) id.get(e),
					(String) name.get(e));
		}
		return languages;
	}

	/**
	 * Get the status of the movie
	 * 
	 * @return A String
	 */
	public String getStatus() {
		return getString("status");
	}

	/**
	 * Get the tagline of a movie
	 * 
	 * @return A String with the tagline
	 */
	public String getTagline() {
		return getString("tagline");
	}

	/**
	 * Get the title of a movie
	 * 
	 * @return A String with the title
	 */
	public String getTitle() {
		return getString("title");
	}

	/**
	 * Get the vote average (on moviedb.org) of a movie
	 * 
	 * @return A float with the relative value
	 */
	public float getVoteAverage() {
		return getFloat("vote_average");
	}

	/**
	 * Get one integer of a movie
	 * 
	 * @param key
	 *            The key to get the value for
	 * @return The value
	 */
	public int getInteger(String key) {

		int start = movie.indexOf("\"" + key + "\"") + key.length() + 3;
		int stop = movie.indexOf("\"", start);
		return Integer.parseInt(movie.substring(start, stop));

	}

	/**
	 * Get a whole array of data from a movie
	 * 
	 * @param key
	 *            The key to get the array from
	 * @return The <code>String[]</code> containing the values
	 */
	public String getArray(String key) {
		int start = movie.indexOf("\"" + key + "\"") + key.length() + 4;
		int stop = movie.indexOf("]", start);
		return movie.substring(start, stop);
	}

	/**
	 * Get a float from a movie
	 * 
	 * @param key
	 *            The key to get the Float from
	 * @return The Float
	 */
	public float getFloat(String key) {

		int start = movie.indexOf("\"" + key + "\"") + key.length() + 3;
		int stop = movie.indexOf("\"", start);
		return Float.parseFloat(movie.substring(start, stop));

	}
}
