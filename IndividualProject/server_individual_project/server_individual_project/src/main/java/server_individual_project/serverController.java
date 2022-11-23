//
// server code for PUT Spring 2020
//

package server_individual_project;

import static java.lang.System.out;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import server_individual_project.Application;

@RestController
public class serverController {
	
	server sr = Application.s;
	
	// TESTING***********************************************************************
	//this getMethodTesting is mapped to hostname:port/getMethodTesting
	//@RequestMapping(value="/getMethodTesting", method=RequestMethod.GET) 
	@GetMapping(value="/getMethodTesting")
	public String getMethodTesting() {
		out.println("serverController.getMethodTesting> start ");
		sr.getMethodTesting();
		return "OK";
	}
	
	// TESTING***********************************************************************
		//this postMethodTesting is mapped to hostname:port/postMethodTesting
		//@RequestMapping(value="/postMethodTesting", method=RequestMethod.POST) 
		@PostMapping(value="/postMethodTesting")
		public String postMethodTesting() {
			out.println("serverController.postMethodTesting> start ");
			sr.postMethodTesting();
			return "OK";
		}
	
}
