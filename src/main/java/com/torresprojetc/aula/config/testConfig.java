package com.torresprojetc.aula.config;

import com.torresprojetc.aula.entities.Category;
import com.torresprojetc.aula.entities.Order;
import com.torresprojetc.aula.entities.Product;
import com.torresprojetc.aula.entities.User;
import com.torresprojetc.aula.entities.enuns.OrderStatus;
import com.torresprojetc.aula.repositorys.CategoryRepository;
import com.torresprojetc.aula.repositorys.OrderRepository;
import com.torresprojetc.aula.repositorys.ProductRepository;
import com.torresprojetc.aula.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Joao da silva", "Silva@gmail.com", "219000000", "0001");
        User u2 = new User(null, "jose da silva", "jose@gmail.com", "219000000", "0002");

        Order o1 = new Order(null, Instant.now(), OrderStatus.SHIPPED,u1);
        Order o2 = new Order(null, Instant.now(),OrderStatus.WAITING_PAYMENT,u2);
        Order o3 = new Order(null, Instant.now(),OrderStatus.DELIVERED,u1);
        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getProducts().add(cat2);
        p2.getProducts().add(cat1);
        p2.getProducts().add(cat3);
        p3.getProducts().add(cat3);
        p4.getProducts().add(cat3);
        p5.getProducts().add(cat2);
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

    }
}
