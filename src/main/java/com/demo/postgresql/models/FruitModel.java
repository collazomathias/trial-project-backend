package com.demo.postgresql.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "fruit")
public class FruitModel {
    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private Double calories;
    private Double vitaminC;
    private Double potassium;

    public FruitModel(String name, Double calories, Double vitaminC, Double potassium) {
        this.name = name;
        this.calories = calories;
        this.vitaminC = vitaminC;
        this.potassium = potassium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FruitModel that = (FruitModel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(calories, that.calories) && Objects.equals(vitaminC, that.vitaminC) && Objects.equals(potassium, that.potassium);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, calories, vitaminC, potassium);
    }
}
