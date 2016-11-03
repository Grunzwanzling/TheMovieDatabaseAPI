/**
 * 
 */
package main;

import java.io.IOException;
import java.net.MalformedURLException;

import objects.Country;
import objects.Language;
import objects.Movie;
import objects.ProductionCompany;

/**
 * @author Maximilian
 *
 */
public class Demo {

	/**
	 * 
	 */
	public Demo() {
		// TODO Auto-generated constructor stub
	}

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
		System.out.println(m.getTagline());
		System.out.print("Release Date: ");
		System.out.println(m.getReleaseDate());

		System.out.println("\nProduction Companies:");
		ProductionCompany[] companies = m.getProductionCompanies(); // Get the
																	// production
																	// companies
		for (ProductionCompany company : companies) { // Iterate over the array
			System.out.print(company.getName()); // Get the name of the company
			System.out.println("(" + company.getId() + ")");
		}

		System.out.println("\nProduction Countries:");
		Country[] countries = m.getProductionCountries();
		for (Country country : countries) {
			System.out.print(country.getCountryName());
			System.out.println("(" + country.getIsoCountryCode() + ")");
		}
		System.out.println("\nSpoken Languages:");
		Language[] languages = m.getSpokenLanguages();
		for (Language language : languages) {
			System.out.println(language.getLanguageName());
			System.out.print("(" + language.getIsoLanguageCode() + ")");
		}
		System.out.println("\n\n\n\nTop Rated Movies:");
		// Get a list of upcoming movies
		Movie[] movies = api.getTopRatedMovies(1);
		for (Movie movie : movies) {
			System.out.println(movie.getTitle());
		}

	}

}
