package com.torresprojetc.aula.repositorys;

import com.torresprojetc.aula.entities.Order;
import com.torresprojetc.aula.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
