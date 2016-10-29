/**
 * 
 */
package objects;

/**
 * @author Maximilian
 *
 */
public class Language {

	String isoLanguageCode;

	public String getIsoLanguageCode() {
		return isoLanguageCode;
	}

	public String getLanguageName() {
		return languageName;
	}

	String languageName;

	public Language(String iso, String name) {
		this.isoLanguageCode = iso;
		this.languageName = name;
	}

}
