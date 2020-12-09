package com.japser.demo.report.repositories;

import com.japser.demo.report.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}