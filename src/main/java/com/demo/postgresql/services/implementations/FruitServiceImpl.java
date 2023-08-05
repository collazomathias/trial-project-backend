package com.demo.postgresql.services.implementations;

import com.demo.postgresql.models.FruitModel;
import com.demo.postgresql.repositories.FruitRepository;
import com.demo.postgresql.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceImpl implements FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    @Override
    public FruitModel createFruit(FruitModel fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public List<FruitModel> getFruits() {
        return fruitRepository.findAll();
    }

    @Override
    public FruitModel updateFruit(String id, FruitModel fruit) {
        FruitModel fruitToUpdate = fruitRepository.findById(id).get();
        fruitToUpdate.setName(fruit.getName());
        fruitToUpdate.setCalories(fruit.getCalories());
        fruitToUpdate.setVitaminC(fruit.getVitaminC());
        fruitToUpdate.setPotassium(fruit.getPotassium());
        return fruitRepository.save(fruitToUpdate);
    }

    @Override
    public void deleteFruit(String id) {
        fruitRepository.deleteById(id);
    }
}
