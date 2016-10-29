/**
 * 
 */
package objects;

import java.util.ArrayList;

/**
 * @author Maximilian
 *
 */
public class Movie {

	public String movie;

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

	public ProductionCompany[] getProductionCompanies() {
		String content = getArray("production_companies");
		String pieces[] = content.split("}");
		ArrayList name = new ArrayList();
		ArrayList id = new ArrayList();
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

	public Country[] getProductionCountries() {
		String content = getArray("production_countries");
		String pieces[] = content.split("}");
		ArrayList name = new ArrayList();
		ArrayList id = new ArrayList();
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

	public String getReleaseDate() {
		return getString("release_date");
	}

	public int getRevenue() {
		return getInteger("revenue");
	}

	public int getRuntime() {
		return getInteger("runtime");
	}

	public Language[] getSpokenLanguages() {
		String content = getArray("spoken_languages");
		String pieces[] = content.split("}");
		ArrayList name = new ArrayList();
		ArrayList id = new ArrayList();
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

	public String getArray(String key) {
		int start = movie.indexOf("\"" + key + "\"") + key.length() + 4;
		int stop = movie.indexOf("]", start);
		return movie.substring(start, stop);
	}

	public float getFloat(String key) {

		int start = movie.indexOf("\"" + key + "\"") + key.length() + 3;
		int stop = movie.indexOf("\"", start);
		return Float.parseFloat(movie.substring(start, stop));

	}
}
