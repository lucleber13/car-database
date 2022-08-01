package com.cbcode.cardatabase;

import com.cbcode.cardatabase.domain.Car;
import com.cbcode.cardatabase.domain.Sales;
import com.cbcode.cardatabase.domain.User;
import com.cbcode.cardatabase.repository.CarRepository;
import com.cbcode.cardatabase.repository.SalesRepository;
import com.cbcode.cardatabase.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Add sales objects and save these to db.
        Sales sales1 = new Sales("Cleber", "Balbinote");
        Sales sales2 = new Sales("Lorenzo", "Silva");
        salesRepository.findByFirstnameAndLastname("Cleber", "Balbinote");
        salesRepository.saveAll(Arrays.asList(sales1, sales2));


        carRepository.save(new Car("Corolla", "Red", "WD22REW", "087654", sales1));
        carRepository.save(new Car("Yaris", "Green", "WD22GZW", "985647", sales2));
        carRepository.save(new Car("Hilux", "Grey", "WD21NGT", "734737", sales2));

        for (Car car : carRepository.findAll()) {
            logger.info(car.getModel() + " " + car.getColor());
        }
        // Username: user, password: user
        userRepository.save(new User("user", "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue", "USER"));
        //Username: admin, password:admin
        userRepository.save(new User("admin", "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
    }
}
