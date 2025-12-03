package com.example.application.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("/add")
public class AddView extends VerticalLayout {
    public AddView() {
        add(new H1("Add"), new RouterLink("Home", MainView.class));
    }
}
