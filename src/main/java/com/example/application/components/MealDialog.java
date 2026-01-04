package com.example.application.components;

import com.example.application.entities.Meal;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

import java.util.function.Consumer;

public class MealDialog extends Dialog {
    private TextField name = new TextField("Name");

    private IntegerField calories = new IntegerField("Kalorien");
    private IntegerField carbs = new IntegerField("Kohlenhydrate");
    private IntegerField protein = new IntegerField("Protein");
    private IntegerField fats = new IntegerField("Fett");
    private IntegerField fibers = new IntegerField("Ballaststoffe");

    private Button saveButton = new Button("Speichern");
    private Button closeButton = new Button("Zurück");

    private Binder<Meal> binder = new Binder<>(Meal.class);

    public MealDialog(Meal meal, Consumer<Meal> onSave) {
        var layout = new FormLayout();

        binder.bindInstanceFields(this);
        saveButton.addClickListener(e -> saveMeal(meal, onSave));
        closeButton.addClickListener(e -> close());

        layout.add(name,  calories, carbs, protein, fats, fibers);

        binder.bindInstanceFields(this);
        binder.setBean(meal);

        add(layout);
        getFooter().add(closeButton, saveButton);
    }

    public void saveMeal(Meal meal, Consumer<Meal> onSave) {
        if (!binder.writeBeanIfValid(meal)) {
            Notification.show("Ungülige Daten gegeben");
            return;
        }

        Notification.show("Gespeichert");
        onSave.accept(meal);
        close();
    }
}
