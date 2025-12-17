package com.example.application.views;

import com.example.application.entities.Meal;
import com.example.application.services.GreetService;
import com.example.application.services.MealService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route
public class MainView extends VerticalLayout {

    public MainView(MealService mealService) {
        var h1 = new H1("Hello World");
        var p = new Paragraph("This is my Vaadin App");

        add(h1, p);

        var meals = mealService.findAll();
        if (meals.isEmpty()) {
            add(new Paragraph("No meals found"));
        } else {
            var mealList = new UnorderedList();
            for  (Meal meal : mealService.findAll()) {
                var listItem = new ListItem(meal.getName());
                mealList.add(listItem);
            }
            add(mealList);
        }
    }
}
