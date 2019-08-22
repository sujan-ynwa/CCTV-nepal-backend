package com.summerproject.cctvnepal.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.summerproject.cctvnepal.entity.Categories;

@RepositoryRestResource(path= "categories")
public interface CategoryRepository extends JpaRepository<Categories,Integer> {
}
