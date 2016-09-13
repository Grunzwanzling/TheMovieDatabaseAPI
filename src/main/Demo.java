/**
 * 
 */
package main;

import java.io.IOException;
import java.net.MalformedURLException;

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
		APIAccess api = new APIAccess("849e76d398ebbdd616b9801d3af65875"); //Connect to the API
		
		Movie m = api.getMovie("550"); //Get the Movie with id=550
		
		System.out.println(m.getString("title")); //Get the title of the movie

	}

}
