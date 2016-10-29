/**
 * 
 */
package objects;

/**
 * @author Maximilian
 *
 */
public class ProductionCompany {

	String id;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	String name;

	public ProductionCompany(String id, String name) {
		this.id = id;
		this.name = name;
	}
}
