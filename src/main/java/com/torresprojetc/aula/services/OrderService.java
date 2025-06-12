package com.torresprojetc.aula.services;

import com.torresprojetc.aula.entities.Order;
import com.torresprojetc.aula.repositorys.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository userRepository;

    public List<Order> findAll(){
        return userRepository.findAll();
    }

    public Optional<Order> findById(Long id){
        return userRepository.findById(id);
    }

}
