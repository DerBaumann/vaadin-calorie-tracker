package com.example.application.views;

import com.example.application.entities.Meal;
import com.example.application.services.MealService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("/add")
public class AddView extends VerticalLayout {

    private final MealService mealService;

    private TextField name = new TextField("Name");

    private IntegerField calories = new IntegerField("Calories");
    private IntegerField carbs = new IntegerField("Carbs");
    private IntegerField protein = new IntegerField("Protein");
    private IntegerField fats = new IntegerField("Fats");
    private IntegerField fibers = new IntegerField("Fibers");

    private Button saveButton = new Button("Save");
    private Button backButton = new Button("Back");

    private Binder<Meal> binder = new Binder<>(Meal.class);

    @Autowired
    public AddView(MealService mealService) {
        this.mealService = mealService;

        var formLayout = new FormLayout();
        formLayout.add(name,  calories, carbs, protein, fats, fibers,  saveButton,  backButton);

        binder.bindInstanceFields(this);
        saveButton.addClickListener(e -> saveMeal());
        backButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate(MainView.class)));

        add(formLayout);
    }

    public void saveMeal() {
        var meal = new Meal();

        if (!binder.writeBeanIfValid(meal)) {
            Notification.show("Invalid data provided");
            return;
        }

        mealService.save(meal);
        Notification.show("Saved");

        UI.getCurrent().navigate(MainView.class);
    }
}
