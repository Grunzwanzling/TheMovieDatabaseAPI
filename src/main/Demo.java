/**
 * 
 */
package main;

import java.io.IOException;
import java.net.MalformedURLException;

import objects.Country;
import objects.Movie;
import objects.ProductionCompany;

/**
 * A demonstration for TheMovieDatabaseAPI
 * 
 * @author <a href="http://grunzwanzling.me">Maximilian von Gaisberg
 *         (Grunzwanzling)</a>
 *
 * @see <a href="http://grunzwanzling.me/TheMovieDatabaseAPI">javadoc</a>
 */
public class Demo {

	/**
	 * @author <a href="http://grunzwanzling.me">Maximilian von Gaisberg
	 *         (Grunzwanzling)</a>
	 */

	/**
	 * @param args
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException,
			IOException {
		APIAccess api = new APIAccess("849e76d398ebbdd616b9801d3af65875"); // Connect
																			// to
																			// the
																			// API

		// Get the details for one specific movie

		Movie m = api.getMovie("550"); // Get the movie with id=550
		System.out.print("Title: ");
		System.out.println(m.getTitle()); // Get the title
		System.out.print("Tagline: ");
		System.out.println(m.getTagline());
		System.out.print("Release Date: ");
		System.out.println(m.getReleaseDate());

		System.out.println("\nProduction Companies:");
		ProductionCompany[] companies = m.getProductionCompanies(); // Get the
																	// production
																	// companies
		for (ProductionCompany company : companies) { // Iterate over the array
			System.out.print(company.getName()); // Get the name of the company
			System.out.println(" (" + company.getId() + ")");
		}

		System.out.println("\nProduction Countries:");
		Country[] countries = m.getProductionCountries();
		for (Country country : countries) {
			System.out.print(country.getCountryName());
			System.out.println("(" + country.getIsoCountryCode() + ")");
		}

		System.out.println("\n\n\n\nTop Rated Movies:");
		Movie[] movies = api.getTopRatedMovies(1);
		for (Movie movie : movies) {
			System.out.println(movie.getTitle());
			System.out.println(movie.getTagline() + "\n");
		}

		System.out.println("\n\n\n\nSearch for Movies with \"Star Wars\":");
		movies = api.searchMovie("Star Wars", "en-EN", 1);
		for (Movie movie : movies) {
			System.out.println(movie.getTitle());
			System.out.println(movie.getTagline() + "\n");
		}
	}

}
