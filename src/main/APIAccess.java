package main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import objects.Movie;
import essentials.Essentials;

/**
 * 
 * This represents the connection to the <a href="http://moviedb.org">The Movie
 * Database</a> API
 * 
 * @author <a href="http://grunzwanzling.me">Maximilian von Gaisberg
 *         (Grunzwanzling)</a>
 * 
 * @see <a href="http://grunzwanzling.me/TheMovieDatabaseAPI">javadoc</a>
 *
 */
public class APIAccess {

	private String apiKey;

	/**
	 * Connect to the API
	 * 
	 * @param apiKey
	 *            The API-key issued by <a href="http://moviedb.org">The Movie
	 *            Database</a>
	 */
	public APIAccess(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * 
	 * @param pages
	 *            The amount of pages that should be read
	 * @return The <code>Movie[]</code> with all the founf movies
	 * @throws MalformedURLException
	 *             When a parameter is not in the right format
	 * @throws IOException
	 *             When the connection could not be established
	 */
	public Movie[] getNowPlayingMovies(int pages) throws MalformedURLException,
			IOException {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		int counter = 0;
		for (int i = 1; i <= pages; i++) {
			String result = Essentials.sendHTTPRequest(new URL(
					"http://api.themoviedb.org/3/movie/now_playing?api_key="
							+ apiKey + "&page=" + i));

			String content = "a";
			int start = 0;
			int stop = 0;
			while (content != "") {
				try {
					start = result.indexOf("\"poster_path\"", stop);
					stop = 20 + result.indexOf("\"vote_average\"", start);
					content = result.substring(start, stop);
					map.put(counter, content);
					counter++;
				} catch (StringIndexOutOfBoundsException e) {
					break;
				}
			}

		}

		Movie[] movie = new Movie[counter];
		for (int i = 0; i < counter; i++) {
			String id = map.get(i).substring(map.get(i).indexOf("\"id\":") + 5,
					map.get(i).indexOf(",", map.get(i).indexOf("\"id\":") + 5));
			movie[i] = this.getMovie(id);
		}
		return movie;
	}

	/**
	 * 
	 * @param pages
	 *            The amount of pages that should be read
	 * @return The <code>Movie[]</code> with all the founf movies
	 * @throws MalformedURLException
	 *             When a parameter is not in the right format
	 * @throws IOException
	 *             When the connection could not be established
	 */
	public Movie[] getLatestMovies(int pages) throws MalformedURLException,
			IOException {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		int counter = 0;
		for (int i = 1; i <= pages; i++) {
			String result = Essentials.sendHTTPRequest(new URL(
					"http://api.themoviedb.org/3/movie/latest?api_key="
							+ apiKey + "&page=" + i));

			String content = "a";
			int start = 0;
			int stop = 0;
			while (content != "") {
				try {
					start = result.indexOf("\"poster_path\"", stop);
					stop = 20 + result.indexOf("\"vote_average\"", start);
					content = result.substring(start, stop);
					map.put(counter, content);
					counter++;
				} catch (StringIndexOutOfBoundsException e) {
					break;
				}
			}

		}

		Movie[] movie = new Movie[counter];
		for (int i = 0; i < counter; i++) {
			String id = map.get(i).substring(map.get(i).indexOf("\"id\":") + 5,
					map.get(i).indexOf(",", map.get(i).indexOf("\"id\":") + 5));
			movie[i] = this.getMovie(id);
		}
		return movie;
	}

	/**
	 * 
	 * @param pages
	 *            The amount of pages that should be read
	 * @return The <code>Movie[]</code> with all the founf movies
	 * @throws MalformedURLException
	 *             When a parameter is not in the right format
	 * @throws IOException
	 *             When the connection could not be established
	 */
	public Movie[] getPopularMovies(int pages) throws MalformedURLException,
			IOException {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		int counter = 0;
		for (int i = 1; i <= pages; i++) {
			String result = Essentials.sendHTTPRequest(new URL(
					"http://api.themoviedb.org/3/movie/popular?api_key="
							+ apiKey + "&page=" + i));

			String content = "a";
			int start = 0;
			int stop = 0;
			while (content != "") {
				try {
					start = result.indexOf("\"poster_path\"", stop);
					stop = 20 + result.indexOf("\"vote_average\"", start);
					content = result.substring(start, stop);
					map.put(counter, content);
					counter++;
				} catch (StringIndexOutOfBoundsException e) {
					break;
				}
			}

		}

		Movie[] movie = new Movie[counter];
		for (int i = 0; i < counter; i++) {
			String id = map.get(i).substring(map.get(i).indexOf("\"id\":") + 5,
					map.get(i).indexOf(",", map.get(i).indexOf("\"id\":") + 5));
			movie[i] = this.getMovie(id);
		}
		return movie;
	}

	/**
	 * 
	 * @param pages
	 *            The amount of pages that should be read
	 * @return The <code>Movie[]</code> with all the founf movies
	 * @throws MalformedURLException
	 *             When a parameter is not in the right format
	 * @throws IOException
	 *             When the connection could not be established
	 */
	public Movie[] getTopRatedMovies(int pages) throws MalformedURLException,
			IOException {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		int counter = 0;
		for (int i = 1; i <= pages; i++) {

			String result = Essentials.sendHTTPRequest(new URL(
					"http://api.themoviedb.org/3/movie/top_rated?api_key="
							+ apiKey + "&page=" + i));

			String content = "a";
			int start = 0;
			int stop = 0;
			while (content != "") {
				try {
					start = result.indexOf("\"poster_path\"", stop);
					stop = 20 + result.indexOf("\"vote_average\"", start);
					content = result.substring(start, stop);
					map.put(counter, content);
					counter++;
				} catch (StringIndexOutOfBoundsException e) {
					break;
				}
			}

		}

		Movie[] movie = new Movie[counter];
		for (int i = 0; i < counter; i++) {
			String id = map.get(i).substring(map.get(i).indexOf("\"id\":") + 5,
					map.get(i).indexOf(",", map.get(i).indexOf("\"id\":") + 5));
			movie[i] = this.getMovie(id);
		}
		return movie;
	}

	/**
	 * 
	 * @param pages
	 *            The amount of pages that should be read
	 * @return The <code>Movie[]</code> with all the found movies
	 * @throws MalformedURLException
	 *             When a parameter is not in the right format
	 * @throws IOException
	 *             When the connection could not be established
	 */
	public Movie[] getUpcomingMovies(int pages) throws MalformedURLException,
			IOException {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		int counter = 0;
		for (int i = 1; i <= pages; i++) {
			String result = Essentials.sendHTTPRequest(new URL(
					"http://api.themoviedb.org/3/movie/upcoming?api_key="
							+ apiKey + "&page=" + i));

			String content = "a";
			int start = 0;
			int stop = 0;
			while (content != "") {
				try {
					start = result.indexOf("\"poster_path\"", stop);
					stop = 20 + result.indexOf("\"vote_average\"", start);
					content = result.substring(start, stop);
					map.put(counter, content);
					counter++;
				} catch (StringIndexOutOfBoundsException e) {
					break;
				}
			}

		}

		Movie[] movie = new Movie[counter];
		for (int i = 0; i < counter; i++) {
			String id = map.get(i).substring(map.get(i).indexOf("\"id\":") + 5,
					map.get(i).indexOf(",", map.get(i).indexOf("\"id\":") + 5));
			movie[i] = this.getMovie(id);
		}
		return movie;
	}

	/**
	 * 
	 * @param query
	 *            The Query to search for
	 * @param language
	 *            The language of the results
	 * @param pages
	 *            The amount of pages to read
	 * @return The <code>Movie[]</code> with all the found movies
	 * @throws MalformedURLException
	 *             When a parameter is not in the right format
	 * @throws IOException
	 *             When the connection could not be established
	 */
	@SuppressWarnings("deprecation")
	public Movie[] searchMovie(String query, String language, int pages)
			throws MalformedURLException, IOException {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		int counter = 0;
		query = URLEncoder.encode(query);
		for (int i = 1; i <= pages; i++) {
			String result = Essentials.sendHTTPRequest(new URL(
					"https://api.themoviedb.org/3/search/movie?language="
							+ language + "&query=" + query + "&api_key="
							+ apiKey + "&page=" + i));

			String content = "a";
			int start = 0;
			int stop = 0;
			while (content != "") {
				try {
					start = result.indexOf("\"poster_path\"", stop);
					stop = 20 + result.indexOf("\"vote_average\"", start);
					content = result.substring(start, stop);
					map.put(counter, content);
					counter++;
				} catch (StringIndexOutOfBoundsException e) {
					break;
				}
			}

		}

		Movie[] movie = new Movie[counter];
		for (int i = 0; i < counter; i++) {
			String id = map.get(i).substring(map.get(i).indexOf("\"id\":") + 5,
					map.get(i).indexOf(",", map.get(i).indexOf("\"id\":") + 5));
			movie[i] = this.getMovie(id);
		}
		return movie;
	}

	/**
	 * Get one specific movie by the ID
	 * 
	 * @param id
	 *            The id of the movie to load
	 * @return The found movie
	 * @throws MalformedURLException
	 *             When a parameter is not in the right format
	 * @throws IOException
	 *             When the connection could not be established
	 */
	public Movie getMovie(String id) throws MalformedURLException, IOException {
		String result = Essentials.sendHTTPRequest(new URL(
				"http://api.themoviedb.org/3/movie/" + id + "?api_key="
						+ apiKey));

		// String content = "a";
		// int start = 0;
		// int stop = 0;
		// try {
		// start = result.indexOf("\"poster_path\"", stop);
		// stop = 20 + result.indexOf("\"vote_average\"", start);
		// content = result.substring(start, stop);
		// } catch (StringIndexOutOfBoundsException e) {
		// return null;
		// }
		// return new Movie(content);

		return new Movie(result);

	}

}
