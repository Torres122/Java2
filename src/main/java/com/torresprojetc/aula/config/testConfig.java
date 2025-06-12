package com.torresprojetc.aula.config;

import com.torresprojetc.aula.entities.Category;
import com.torresprojetc.aula.entities.Order;
import com.torresprojetc.aula.entities.User;
import com.torresprojetc.aula.entities.enuns.OrderStatus;
import com.torresprojetc.aula.repositorys.CategoryRepository;
import com.torresprojetc.aula.repositorys.OrderRepository;
import com.torresprojetc.aula.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Joao da silva", "Silva@gmail.com", "219000000", "0001");
        User u2 = new User(null, "jose da silva", "jose@gmail.com", "219000000", "0002");

        Order o1 = new Order(null, Instant.now(), OrderStatus.SHIPPED,u1);
        Order o2 = new Order(null, Instant.now(),OrderStatus.WAITING_PAYMENT,u2);
        Order o3 = new Order(null, Instant.now(),OrderStatus.DELIVERED,u1);

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}
