/**
 * 
 */
package objects;

/**
 * An Object that is returned by {@link Movie#getSpokenLanguages}
 * 
 * @author <a href="http://grunzwanzling.me">Maximilian von Gaisberg
 *         (Grunzwanzling)</a>
 *
 */
public class Language {

	String isoLanguageCode;

	/**
	 * The ISO-Language-Code
	 * 
	 * @return The language code
	 */
	public String getIsoLanguageCode() {
		return isoLanguageCode;
	}

	/**
	 * Get the name of the language
	 * 
	 * @return The name of the language
	 */
	public String getLanguageName() {
		return languageName;
	}

	String languageName;

	/**
	 * Create a new language
	 * 
	 * @param iso
	 *            The ISO-Language-Code
	 * @param name
	 *            The name of the language
	 */
	protected Language(String iso, String name) {
		this.isoLanguageCode = iso;
		this.languageName = name;
	}

}
