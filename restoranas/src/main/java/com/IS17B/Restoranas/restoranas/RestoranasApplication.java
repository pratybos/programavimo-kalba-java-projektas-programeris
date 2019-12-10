package com.IS17B.Restoranas.restoranas;

import com.IS17B.Restoranas.restoranas.Model.Client;
import com.IS17B.Restoranas.restoranas.Repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RestoranasApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(RestoranasApplication.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("namedParameterJdbcClientRepository")
	private ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestoranasApplication.class, args);
	}


	@Override
	public void run(String... args){
		log.info("RestoranasApplication...");
		runJDBC();
	}

	 void runJDBC(){
		log.info("Creating tables for testing...");

		jdbcTemplate.execute("DROP TABLE clients");
		jdbcTemplate.execute("CREATE TABLE clients (id INTEGER(11) , firstName VARCHAR(45) " +
				", lastName VARCHAR (45), email VARCHAR (45), phoneNumber INTEGER (11))");
		List<Client> clients = Arrays.asList(
				new Client(1,"Piotr","Piotrov","pPiort",
						85588662),
				new Client(2,"Vazgen","Vitia","vVitia",
						85588663),
				new Client(3,"Piotrs","Piotrovs","pPiorts",
						85588664),
				new Client(4,"Piotrss","Piotrovss","pPiortss",
						85588665));

		log.info("[SAVE]");
		clients.forEach(client -> {
			log.info("Saving...{}", client.getFirstName());
			clientRepository.save(client);
		});

		//count
		log.info("[COUNT] Total books: {}", clientRepository.count());

		//find all
		 log.info("[FIND_ALL] :2L");
		 Client client = clientRepository.findById((int) 2L).orElseThrow(IllegalArgumentException::new);
		 log.info("{}", client);

		 //get name (string) by id
		 log.info("[GET_NAME_BY_ID] :1L = {}", clientRepository.getFirstNameById((int) 1L));

		 //delete
		 log.info("[UPDATE] :L :99.99");
		 log.info("rows affected: {}", clientRepository.deleteById((int) 3L));

		 //find all
		 log.info("[FIND_ALL] {}", clientRepository.findAll());

	}
}