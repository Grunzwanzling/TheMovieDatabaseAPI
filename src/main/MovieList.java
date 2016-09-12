/**
 * 
 */
package main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import essentials.Essentials;

/**
 * @author Maximilian
 *
 */
public class MovieList {

	HashMap<Integer, String> map;
	int counter = 0;
	Movie[] movie;

	public MovieList(String key, int type) throws MalformedURLException,
			IOException {

		map = new HashMap<Integer, String>();

		for (int i = 1; i <= 1000; i++) {
			try {
				String result = Essentials.sendHTTPRequest(new URL(
						"http://api.themoviedb.org/3/movie/now_playing?api_key="
								+ key + "&page=" + i));

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
			} catch (IOException e) {
				break;
			}

		}

		movie = new Movie[counter];
		for (int i = 0; i < counter; i++) {
			movie[i] = new Movie(map.get(i));
		}

	}

	public Movie[] getMovies() {
		return movie;
	}
}
