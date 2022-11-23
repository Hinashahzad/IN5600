//
// server code for PUT Spring 2020
//

package server_individual_project;

import static java.lang.System.out;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	public static final server s = new server();
	
	public static void main(String[] args) {
		out.println("main start");
		SpringApplication.run(Application.class, args);	
		s.start();
	}
}
