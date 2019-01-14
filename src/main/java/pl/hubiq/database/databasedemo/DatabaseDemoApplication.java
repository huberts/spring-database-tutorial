package pl.hubiq.database.databasedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.hubiq.database.databasedemo.jdbc.PersonJdbcDAO;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private final PersonJdbcDAO dao;

	@Autowired
	public DatabaseDemoApplication(PersonJdbcDAO dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", dao.findAll());
		logger.info("User with id 10001 -> {}", dao.findById(10001));
		logger.info("Users with name Hubert -> {}", dao.findByName("Hubert"));
		logger.info("Users with location Waszyngton -> {}", dao.findByLocation("Waszyngton"));
	}
}
