package sprtingboot.springRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringRestApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);

		StaticRestTemplate staticRestTemplate = new StaticRestTemplate();
		staticRestTemplate.connectionResult();
		System.out.println(staticRestTemplate.allUsers());
		User user = new User(3L, "James", "Brown", (byte) 25);
		System.out.println(staticRestTemplate.addUser(user));
		User updateUser = new User(3L, "Thomas", "Shelby", (byte) 19);
		System.out.println(staticRestTemplate.updateUser(updateUser));
		staticRestTemplate.deleteUser(3L);
		System.out.println(staticRestTemplate.allUsers());







	}



}
