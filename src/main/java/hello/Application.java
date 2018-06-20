package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository customerRepository, UserRepository userRepository) {
        return (args) -> {
            // save a couple of customers
            customerRepository.save(new CustomerEntity("Jack", "Bauer"));
            customerRepository.save(new CustomerEntity("Chloe", "O'Brian"));
            customerRepository.save(new CustomerEntity("Kim", "Bauer"));
            customerRepository.save(new CustomerEntity("David", "Palmer"));
            customerRepository.save(new CustomerEntity("Michelle", "Dessler"));
            userRepository.save(new UserEntity("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (CustomerEntity customerEntity : customerRepository.findAll()) {
                log.info(customerEntity.toString());
            }
            log.info("");

            // fetch an individual customer by ID
/*            customerRepository.findById(1L)
                    .ifPresent(customerEntity -> {
                        log.info("CustomerEntity found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(customerEntity.toString());
                        log.info("");
                    });*/

            // fetch customers by last name
            log.info("CustomerEntity found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            customerRepository.findByCustomerCompanyName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
//             for (CustomerEntity bauer : repository.findByLastName("Bauer")) {
//             	log.info(bauer.toString());
//             }
            log.info("");
        };
    }

}