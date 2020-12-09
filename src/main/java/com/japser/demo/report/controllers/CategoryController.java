package com.japser.demo.report.controllers;


import com.japser.demo.report.entities.Category;
import com.japser.demo.report.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public Iterable<Category> index() {
        return categoryRepository.findAll();
    }

}
