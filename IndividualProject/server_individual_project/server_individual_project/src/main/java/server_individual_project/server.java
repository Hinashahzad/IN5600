//
// server code for PUT Spring 2020
//

package server_individual_project;

import static java.lang.System.out;

public class server {

	public void server() {
		out.println("server constructor");
	}
	
	public void start() {	
		out.println("server start");
	}
	
	
	// TESTING***********************************************************************
	// invoked from the method getMethodTesting
	public void getMethodTesting() { 
		out.println("server.getMethodTesting> OK");
	} 
	
	// TESTING***********************************************************************
	// invoked from the method postMethodTesting
	public void postMethodTesting() { 
		out.println("server.postMethodTesting> OK");
	} 
}
