package com.torresprojetc.aula.services;

import com.torresprojetc.aula.entities.Product;
import com.torresprojetc.aula.entities.User;
import com.torresprojetc.aula.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id){return productRepository.findById(id);
    }

}
