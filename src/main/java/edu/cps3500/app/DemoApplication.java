package edu.cps3500.app;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.cps3500.app.domain.Role;
import edu.cps3500.app.domain.StockPE;
import edu.cps3500.app.domain.User;
import edu.cps3500.app.repository.StockPERepo;
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
			User user = new User("admin", "test123", "test@hotmail.com", passwordEncoder().encode("admin123"), roles);
			userRepo.save(user);
		};
	}

	@Bean
	@Order(1)
	CommandLineRunner command(StockPERepo stockRepo) {
		return args -> {
			StockPE stockPE1 = new StockPE("Alphabet", "Google".toLowerCase(), 1315, 53.94, 62.47, 15.81, 1.33);
			StockPE stockPE2 = new StockPE("Microsoft", "MSFT".toLowerCase(), 158, 5.68, 6.3, 10.92, 2.3);
			StockPE stockPE3 = new StockPE("Facebook", "FB".toLowerCase(), 190, 9.11, 10.91, 1976, 0.88);
			StockPE stockPE4 = new StockPE("Alibaba Group", "BABA".toLowerCase(), 205, 50.52, 61.09, 20.92, 0.16);
			StockPE stockPE5 = new StockPE("Paypal", "PYPL".toLowerCase(), 108, 3.45, 4.17, 20.87, 1.24);
			StockPE stockPE6 = new StockPE("Apple", "AAPL".toLowerCase(), 274, 13.62, 15.68, 15.21, 1.15);

			stockRepo.save(stockPE1);
			stockRepo.save(stockPE2);
			stockRepo.save(stockPE3);
			stockRepo.save(stockPE4);
			stockRepo.save(stockPE5);
			stockRepo.save(stockPE6);

		};
	}
}
