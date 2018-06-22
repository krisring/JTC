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
    public CommandLineRunner demo(CustomerRepository customerRepository, UserRepository userRepository, MessageRepository messageRepository) {
        return (args) -> {
            // save a couple of customers
            customerRepository.save(new CustomerEntity("Jack", "Bauer.Jack@fake.com"));
            customerRepository.save(new CustomerEntity("Chloe", "OBrian.Chloe@fake.com"));
            customerRepository.save(new CustomerEntity("Kim", "Bauer.Kim@fake.com"));
            customerRepository.save(new CustomerEntity("David", "Palmer"));
            customerRepository.save(new CustomerEntity("Michelle", "Dessler"));
            userRepository.save(new UserEntity("Michelle", "Dessler@michelle.com"));
            userRepository.save(new UserEntity("Dave", "Dave@dave.com"));
            messageRepository.save(new MessageEntity("MESSAGE", 6L, 7L));


            // fetch all company customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (CustomerEntity customerEntity : customerRepository.findAll()) {
                log.info(customerEntity.toString());
            }
            log.info("");

            // fetch all users
            log.info("Users found with findAll():");
            log.info("---------------------------");
            for(UserEntity userEntity:userRepository.findAll()) {
                log.info(userEntity.toString());
            }
            log.info("");

            // fetch all messages
            log.info("Messages found with findAll():");
            log.info("---------------------------");
            for(MessageEntity messageEntity:messageRepository.findAll()) {
                log.info(messageEntity.toString());
            }


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
            customerRepository.findByCustomerCompanyName("Bauer").forEach(bauer -> log.info(bauer.toString()));
//             for (CustomerEntity bauer : repository.findByLastName("Bauer")) {
//             	log.info(bauer.toString());
//             }
            log.info("");
        };
    }

}