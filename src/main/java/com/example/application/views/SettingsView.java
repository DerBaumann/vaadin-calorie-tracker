package com.example.application.views;

import com.example.application.components.UserEditDialog;
import com.example.application.layouts.MainLayout;
import com.example.application.singletons.User;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/settings")
public class SettingsView extends MainLayout {
    private final User user;

    private final H1 bmiLabel = new H1();
    private final H2 bmiStatusLabel = new H2();
    private final H3 calorieLabel = new H3();
    private final Paragraph nameLabel = new Paragraph();
    private final Paragraph ageLabel = new Paragraph();
    private final Paragraph heightLabel = new Paragraph();
    private final Paragraph weightLabel = new Paragraph();
    private final Paragraph activityLevelLabel = new Paragraph();
    private final Paragraph genderLabel = new Paragraph();

    public SettingsView(User user) {
        this.user = user;

        refresh();
        add(bmiLabel, bmiStatusLabel, calorieLabel);
        add(nameLabel, ageLabel, heightLabel, weightLabel, activityLevelLabel, genderLabel);

        var editButton = new Button("Bearbeiten");
        var dialog = new UserEditDialog(user, this::refresh);

        editButton.addClickListener(e -> dialog.open());

        add(editButton, dialog);
    }

    public void refresh() {
        bmiLabel.setText("%.2f BMI".formatted(user.getBMI()));
        bmiStatusLabel.setText(user.getBMIStatus().toString());
        calorieLabel.setText("%d kcal".formatted(user.getDailyCalories()));

        nameLabel.setText(user.getName());
        ageLabel.setText("Alter: %d".formatted(user.getAge()));
        heightLabel.setText("Grösse: %d cm".formatted(user.getHeight()));
        weightLabel.setText("Gewicht: %d kg".formatted(user.getWeight()));
        activityLevelLabel.setText("Aktivität: %s".formatted(user.getActivityLevel().toLabel()));
        genderLabel.setText("Geschlecht: %s".formatted(user.getGender().toLabel()));
    }
}