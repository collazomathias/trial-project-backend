package com.demo.postgresql.services;

import com.demo.postgresql.models.FruitModel;

import java.util.List;

public interface FruitService {
    public FruitModel createFruit(FruitModel fruit);
    public List<FruitModel> getFruits();
    public FruitModel updateFruit(String id, FruitModel fruit);
    public void deleteFruit(String id);
}
