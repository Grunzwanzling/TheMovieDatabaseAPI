/**
 * 
 */
package objects;

/**
 * An Object that is returned by {@link Movie#getProductionCompanies()}
 * 
 * @author <a href="http://grunzwanzling.me">Maximilian von Gaisberg
 *         (Grunzwanzling)</a>
 *
 */
public class ProductionCompany {

	String id;

	/**
	 * Get the (internal) id for the procduction company
	 * 
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Get the name of the production company
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	String name;

	protected ProductionCompany(String id, String name) {
		this.id = id;
		this.name = name;
	}
}
