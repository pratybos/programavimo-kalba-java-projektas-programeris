package com.IS17B.Restoranas.restoranas;

import com.IS17B.Restoranas.restoranas.Model.Client;
import com.IS17B.Restoranas.restoranas.Model.Employee;
import com.IS17B.Restoranas.restoranas.Model.Table;
import com.IS17B.Restoranas.restoranas.Repository.ClientRepository;
import com.IS17B.Restoranas.restoranas.Repository.EmployeeRepository;
import com.IS17B.Restoranas.restoranas.Repository.TableRepository;
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

	@Autowired
	@Qualifier("namedParameterJdbcEmployeeRepository")
	private EmployeeRepository employeeRepository;

	@Autowired
	@Qualifier("namedParameterJdbcTableRepository")
	private TableRepository tableRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestoranasApplication.class, args);
	}


	@Override
	public void run(String... args){
		log.info("RestoranasApplication...");
		//runJDBC();
	}

	 void runJDBC(){
		log.info("Creating tables for testing...");

		 jdbcTemplate.execute("ALTER TABLE tables DROP FOREIGN KEY tables_ibfk_1");
		 jdbcTemplate.execute("ALTER TABLE tables DROP FOREIGN KEY tables_ibfk_2");
		 jdbcTemplate.execute("DROP TABLE clients");
		jdbcTemplate.execute("CREATE TABLE clients (id INTEGER(11) , firstName VARCHAR(45) " +
				", lastName VARCHAR (45), email VARCHAR (45), phoneNumber INTEGER (11), PRIMARY KEY (id))");
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

		 jdbcTemplate.execute("DROP TABLE employee");
		 jdbcTemplate.execute("CREATE TABLE employee (id INTEGER(11) , firstName VARCHAR(45) " +
				 ", lastName VARCHAR (45), email VARCHAR (45), phoneNumber INTEGER (11), " +
				 "salary DOUBLE, PRIMARY KEY (id))");
		 List<Employee> employees = Arrays.asList(
				 new Employee(1,"Linas","Kastolius","lKastol",
						 86588662, 550.50),
				 new Employee(2,"Natalij","Natalijov","nNatlij",
						 86388663, 650.0),
				 new Employee(3,"Martyna","Matynaite","mMarte",
						 86378663, 1050.0),
				 new Employee(4,"Vikter","Uzspakihev","vUzpk",
						 86587665, 875.15));

		 log.info("[SAVE]");
		 employees.forEach(employee -> {
			 log.info("Saving...{}", employee.getFirstName());
			 employeeRepository.save(employee);
		 });
		 //count
		 log.info("[COUNT] Total books: {}", employeeRepository.count());

		 //find all
		 log.info("[FIND_ALL] :2L");
		 Employee employee = employeeRepository.findById((int) 2L).orElseThrow(IllegalArgumentException::new);
		 log.info("{}", client);

		 //get name (string) by id
		 log.info("[GET_NAME_BY_ID] :1L = {}", employeeRepository.getFirstNameById((int) 1L));

		 //delete
		 log.info("[UPDATE] :L :99.99");
		 log.info("rows affected: {}", employeeRepository.deleteById((int) 3L));

		 //find all
		 log.info("[FIND_ALL] {}", employeeRepository.findAll());

		 jdbcTemplate.execute("DROP TABLE tables");
		 jdbcTemplate.execute("CREATE TABLE tables (id INTEGER (11), idEmployee INTEGER (11)," +
				 "idClient INTEGER (11), " +
				 "PRIMARY KEY (id), " +
				 "FOREIGN KEY (idEmployee) REFERENCES employee(id)," +
				 "FOREIGN KEY (idClient) REFERENCES clients(id))");
		 List<Table> tables = Arrays.asList(
				 new Table(1, 1, 1),
				 new Table(2,2,2),
				 new Table(3,1,1),
				 new Table(4,2,4));

		 log.info("[SAVE]");
		 tables.forEach(table -> {
			 log.info("Saving...{}", table.getId());
			 tableRepository.save(table);
		 });
		 //count
		 log.info("[COUNT] Total books: {}", tableRepository.count());

		 //find all
		 log.info("[FIND_ALL] :2L");
		 Table table = tableRepository.findById((int) 2L).orElseThrow(IllegalArgumentException::new);
		 log.info("{}", table);

		 //get name (string) by id
		 log.info("[GET_NAME_BY_ID] :1L = {}", tableRepository.getFirstNameById((int) 1L));

		 //delete
		 log.info("[UPDATE] :L :99.99");
		 log.info("rows affected: {}", tableRepository.deleteById((int) 3L));

		 //find all
		 log.info("[FIND_ALL] {}", tableRepository.findAll());
	}
}