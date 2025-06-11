package com.torresprojetc.aula.config;

import com.torresprojetc.aula.entities.User;
import com.torresprojetc.aula.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Joao da silva", "Silva@gmail.com", "219000000", "0001");
        User u2 = new User(null, "jose da silva", "jose@gmail.com", "219000000", "0002");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
