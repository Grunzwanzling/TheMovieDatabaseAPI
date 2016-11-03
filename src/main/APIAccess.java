/**
 * 
 */
package main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import objects.Movie;
import essentials.Essentials;

/**
 * @author Maximilian
 *
 */
public class APIAccess {

	String apiKey;

	public APIAccess(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * 
	 * @param pages
	 *            The amo
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
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
			movie[i] = new Movie(map.get(i));
		}
		return movie;
	}

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
			movie[i] = new Movie(map.get(i));
		}
		return movie;
	}

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
			movie[i] = new Movie(map.get(i));
		}
		return movie;
	}

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
			movie[i] = new Movie(map.get(i));
		}
		return movie;
	}

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
			movie[i] = new Movie(map.get(i));
		}
		return movie;
	}

	public Movie getMovie(String id) throws MalformedURLException, IOException {
		String result = Essentials.sendHTTPRequest(new URL(
				"http://api.themoviedb.org/3/movie/" + id + "?api_key="
						+ apiKey));

		String content = "a";
		int start = 0;
		int stop = 0;
		try {
			start = result.indexOf("\"poster_path\"", stop);
			stop = 20 + result.indexOf("\"vote_average\"", start);
			content = result.substring(start, stop);
		} catch (StringIndexOutOfBoundsException e) {
			return null;
		}
		return new Movie(content);

	}

}
