package com.example.application.services;

import com.example.application.entities.Meal;
import com.example.application.repositories.MealRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MealService implements Serializable {
    private final MealRepo mealRepo;

    public Meal save(Meal meal) {
        return mealRepo.save(meal);
    }

    public List<Meal> findAll() {
        return mealRepo.findAll();
    }

    public Optional<Meal> findById(Long id) {
        return mealRepo.findById(id);
    }

    public void delete(Meal meal) {
        mealRepo.delete(meal);
    }
}
