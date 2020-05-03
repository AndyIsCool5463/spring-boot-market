package edu.cps3500.app;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.cps3500.app.domain.Role;
import edu.cps3500.app.domain.User;
import edu.cps3500.app.repository.UserRepo;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Order(2)
	CommandLineRunner setDefaultUser(UserRepo userRepo) {
		ArrayList<Role> roles = new ArrayList<Role>();
		return args -> {
			// TODO: FIX THIS ASAP
			// ok fuck off vscode with no intelisense bullshit
			/**
			 * Oh the struggles of coding. I spent 5 hours trying to sign in with "admin"
			 * and "test123" just to find out that those are the firstnames and last names.
			 * Just cause my shitty fucking brain had to name them the worst things. Though
			 * everyone knows that you shouldnt blame yourself and blame the computer
			 * obviously. So i blame the intelisense and how garbage vscode is with
			 * everything else besides JS/TS god i hate coding sometimes.
			 */
			User user = new User("admin", "test123", "test@hotmail.com", passwordEncoder().encode("admin123"), roles);
			userRepo.save(user);
		};

	}
}
