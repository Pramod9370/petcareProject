package com.harshad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshad.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
