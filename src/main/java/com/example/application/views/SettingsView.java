package com.example.application.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("/settings")
public class SettingsView extends VerticalLayout {
    public SettingsView() {
        add(new H1("Settings"), new RouterLink("Home", MainView.class));
    }
}