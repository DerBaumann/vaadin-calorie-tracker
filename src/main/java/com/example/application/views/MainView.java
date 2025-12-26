package com.example.application.views;

import com.example.application.components.grid.GridLayout;
import com.example.application.components.grid.GridTrack;
import com.example.application.entities.Meal;
import com.example.application.services.MealService;
import com.example.application.singletons.User;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {
    public MainView(MealService mealService, User user) {
        final var meals = mealService.findAll();

        getStyle().set("padding", "1em 4em");

        final var totalCalories = meals.stream().mapToInt(Meal::getCalories).sum();
        add(calorieBar(totalCalories, user.getDailyCalories()));

        final var carbs = meals.stream().mapToInt(Meal::getCarbs).sum();
        final var carbsText = new Paragraph(String.format("%dg/%dg Kohlenhydrate", carbs, user.getDailyCarbs()));

        final var protein = meals.stream().mapToInt(Meal::getProtein).sum();
        final var proteinText = new Paragraph(String.format("%d/%d Proteine", protein, user.getDailyProtein()));

        final var fats = meals.stream().mapToInt(Meal::getFats).sum();
        final var fatsText = new  Paragraph(String.format("%d/%d Fett", fats, user.getDailyFats()));

        final var fiber = meals.stream().mapToInt(Meal::getFats).sum();
        final var fiberText = new Paragraph(String.format("%d/%d Ballaststoffe", fiber, user.getDailyFibers()));

        final var nutritionDashboard = new GridLayout(new GridTrack.Count(2), carbsText, proteinText, fatsText, fiberText);
        add(nutritionDashboard);

        add(new Button("Add", event -> {
            getUI().ifPresent(ui -> ui.navigate(AddView.class));
        }));

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

    public Component calorieBar(int totalCalories, int maxCalories) {
        final var container = new VerticalLayout();
        container.getStyle().set("padding", "0");

        final var calorieBar = new ProgressBar();
        calorieBar.setValue((double) totalCalories / maxCalories);
        calorieBar.setHeight(4, Unit.EM);

        final var calorieStatusText = String.format("%d / %d kcal", totalCalories, maxCalories);
        final var calorieStatus = new Paragraph(calorieStatusText);

        container.add(calorieBar, calorieStatus);
        return container;
    }
}
