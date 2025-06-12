package com.torresprojetc.aula.repositorys;

import com.torresprojetc.aula.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
