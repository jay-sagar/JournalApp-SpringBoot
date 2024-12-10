package net.engineeringdigest.journalApp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement // scans all the methods in the file where you have to achieve transaction
// And PlatformTransactionManager do all the working behind it and MongoTransactionManager implement the interface
public class JournalApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JournalApplication.class, args); // using this to get active profile
        ConfigurableEnvironment environment = context.getEnvironment();
        System.out.println(environment.getActiveProfiles()[0]);
    }

    @Bean
    public PlatformTransactionManager add(MongoDatabaseFactory dbFactory) { // MongoDatabaseFactory implements all the properties in Applications.properties and SimpleMongoClientDatabaseFactory implement this interface
        return new MongoTransactionManager(dbFactory);
    }

}