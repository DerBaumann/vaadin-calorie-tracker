package com.example.application;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 * <p>
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service
     *            The message service. Automatically injected Spring managed bean.
     */
    public MainView(GreetService service) {

//        // Use TextField for standard text input
//        TextField textField = new TextField("Your name");
//        textField.addClassName("bordered");
//
//        // Button click listeners can be defined as lambda expressions
//        Button button = new Button("Say hello", e -> {
//            add(new Paragraph(service.greet(textField.getValue())));
//        });
//
//        // Theme variants give you predefined extra styles for components.
//        // Example: Primary button has a more prominent look.
//        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
//
//        // You can specify keyboard shortcuts for buttons.
//        // Example: Pressing enter in this view clicks the Button.
//        button.addClickShortcut(Key.ENTER);
//
//        // Use custom CSS classes to apply styling. This is defined in
//        // styles.css.
//        addClassName("centered-content");
//
//        add(textField, button);


        var h1 = new H1("Hello World");
        var p1 = new Paragraph("This is my Vaadin App");
        var btn = new Button("Click me", e -> add(new Paragraph(service.greet())));

        var div = new Div();
        div.add(h1, p1, btn, new RouterLink("Go to About", AboutView.class));
        add(div);
    }
}
