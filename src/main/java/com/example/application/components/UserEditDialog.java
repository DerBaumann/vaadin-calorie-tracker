package com.example.application.components;

import com.example.application.enums.ActivityLevel;
import com.example.application.enums.Gender;
import com.example.application.singletons.User;
import com.example.application.views.MainView;
import com.example.application.views.SettingsView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class UserEditDialog extends Dialog {
    private TextField name = new TextField("Name");
    private IntegerField age = new IntegerField("Alter");
    private IntegerField height = new IntegerField("Grösse");
    private IntegerField weight = new IntegerField("Gewicht");
    private Select<ActivityLevel> activityLevel = new Select<>();
    private Select<Gender> gender = new Select<>();

    private Binder<User> binder = new Binder<>(User.class);

    public UserEditDialog(User user, Runnable onSave) {
        var dialogLayout = new FormLayout();

        activityLevel.setLabel("Aktivität");
        activityLevel.setItemLabelGenerator(ActivityLevel::toLabel);
        activityLevel.setItems(ActivityLevel.values());
        gender.setLabel("Geschlecht");
        gender.setItemLabelGenerator(Gender::toLabel);
        gender.setItems(Gender.values());

        dialogLayout.add(name, age, height, weight, activityLevel, gender);

        binder.bindInstanceFields(this);
        binder.setBean(user);

        add(dialogLayout);

        var backButton = new Button("Abbrechen", e -> close());
        var saveButton = new Button("Speichern", e -> save(user, onSave));

        getFooter().add(backButton, saveButton);
    }

    private void save(User user, Runnable onSave) {
        if (!binder.writeBeanIfValid(user)) {
            Notification.show("Keine gültigen Werte eingegeben!");
            return;
        }

        Notification.show("Gespeichert!");
        onSave.run();
        close();
    }
}
