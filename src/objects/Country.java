/**
 * 
 */
package objects;

/**
 * @author Maximilian
 *
 */
public class Country {

	String isoCountryCode;

	public String getIsoCountryCode() {
		return isoCountryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	String countryName;

	public Country(String iso, String name) {
		this.isoCountryCode = iso;
		this.countryName = name;
	}

}
