package com.jzajas.Aspects;

import com.jzajas.Aspects.Entities.User;
import com.jzajas.Aspects.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import java.util.List;
import java.util.UUID;


@SpringBootApplication
public class AspectsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectsApplication.class, args);
	}


	@Autowired
	private UserService userService;

	@EventListener(ApplicationReadyEvent.class)
	public void showAspects(ApplicationReadyEvent event) {

		userService.createUser("Jacob", "password123");
		userService.createUser("Jacob", "password456");
		userService.createUser("Jacob", "password678");

		User user = new User("John", "123");
		userService.addUser(user);

		int firstUserCount = userService.getUserCount();
		System.out.println("User count: " + firstUserCount);

		UUID id = userService.getIDForName("Jacob");
		userService.deleteUserById(id);

		int secondUserCount = userService.getUserCount();
		System.out.println("User count: " + secondUserCount);

		List<User> allUsersWithName = userService.getAllUsersWithName("Jacob");
		System.out.println("Users with name Jacob: ");
		allUsersWithName.forEach(System.out::println);
	}
}
