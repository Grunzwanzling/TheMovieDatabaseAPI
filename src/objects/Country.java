/**
 * 
 */
package objects;

/**
 * An Object that is returned by {@link Movie#getProductionCountries()}
 * 
 * @author <a href="http://grunzwanzling.me">Maximilian von Gaisberg
 *         (Grunzwanzling)</a>
 *
 */
public class Country {

	String isoCountryCode;
	String countryName;

	/**
	 * Get the ISO-Country-Code
	 * 
	 * @return The country code
	 */
	public String getIsoCountryCode() {
		return isoCountryCode;
	}

	/**
	 * Get the name of the country
	 * 
	 * @return The name
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * Create a new country
	 * 
	 * @param iso
	 *            The ISO-Country-Code
	 * @param name
	 *            The name of the country
	 */
	protected Country(String iso, String name) {
		this.isoCountryCode = iso;
		this.countryName = name;
	}

}
