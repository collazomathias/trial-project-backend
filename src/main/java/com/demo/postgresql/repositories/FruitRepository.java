package com.demo.postgresql.repositories;

import com.demo.postgresql.models.FruitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FruitRepository extends JpaRepository<FruitModel, String> {}
