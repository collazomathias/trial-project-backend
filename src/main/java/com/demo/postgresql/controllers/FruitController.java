package com.demo.postgresql.controllers;

import com.demo.postgresql.models.FruitModel;
import com.demo.postgresql.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping("/fruit")
    public ResponseEntity<List<FruitModel>> getFruits() {
        try {
            return ResponseEntity.ok(fruitService.getFruits());
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/fruit")
    public ResponseEntity<FruitModel> createFruit(@RequestBody FruitModel fruit) {
        try {
            FruitModel createdFruit = fruitService.createFruit(fruit);
            messagingTemplate.convertAndSend("/topic/fruits", createdFruit);
            return ResponseEntity.ok(createdFruit);
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/fruit/{id}")
    public ResponseEntity<FruitModel> updateFruit(@PathVariable String id, @RequestBody FruitModel fruit) {
        try {
            FruitModel updatedFruit = fruitService.updateFruit(id, fruit);
            messagingTemplate.convertAndSend("/topic/fruits", updatedFruit);
            return ResponseEntity.ok(updatedFruit);
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/fruit/{id}")
    public ResponseEntity<String> deleteFruit(@PathVariable String id) {
        try {
            fruitService.deleteFruit(id);
            messagingTemplate.convertAndSend("/topic/fruits", "delete");
            return ResponseEntity.ok("Fruit deleted successfully");
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
