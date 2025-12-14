package com.example.application.views;

import com.example.application.entities.Person;
import com.example.application.repositories.PersonRepo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("person-form")
public class PersonFormView extends VerticalLayout {

    private final PersonRepo personRepo;

    private final TextField firstName = new TextField("First name");
    private final TextField lastName = new TextField("Last name");
    private final EmailField email = new EmailField("Email");

    private Button saveButton = new Button("Save");

    private Binder<Person> binder = new Binder<>(Person.class);

    @Autowired
    public PersonFormView(PersonRepo personRepo) {
        this.personRepo = personRepo;

        FormLayout formLayout = new FormLayout();
        formLayout.add(firstName, lastName, email, saveButton);

        binder.bindInstanceFields(this);

        saveButton.addClickListener(e -> savePerson());

        add(formLayout);
    }

    private void savePerson() {
        Person person = new Person();
        if (binder.writeBeanIfValid(person)) {
            personRepo.save(person);
            Notification.show("Person has been saved");
            binder.readBean(new Person());
        } else {
            Notification.show("Please fill all the fields");
        }
    }

}
