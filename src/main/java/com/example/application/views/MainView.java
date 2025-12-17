package com.example.application.views;

import com.example.application.entities.Meal;
import com.example.application.services.GreetService;
import com.example.application.services.MealService;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route
public class MainView extends VerticalLayout {
    public MainView(MealService mealService) {
        final var meals = mealService.findAll();
        final var totalCalories = meals.stream().mapToInt(Meal::getCalories).sum();
        final var maxCalories = 2000;

        final var calorieBar = new ProgressBar();
        calorieBar.setValue((double) totalCalories /  maxCalories);
        calorieBar.setHeight(4, Unit.EM);

        final var calorieStatusText = String.format("%d / %d", totalCalories, maxCalories);
        final var calorieStatus = new Paragraph(calorieStatusText);
        add(calorieBar, calorieStatus);

        if (meals.isEmpty()) {
            add(new Paragraph("No meals found"));
        } else {
            var mealList = new UnorderedList();
            for (Meal meal : mealService.findAll()) {
                var listItem = new ListItem(meal.getName());
                mealList.add(listItem);
            }
            add(mealList);
        }
    }
}
