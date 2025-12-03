package com.example.application.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route("view")
public class ViewView extends VerticalLayout implements HasUrlParameter<String> {
    @Override
    public void setParameter(BeforeEvent beforeEvent, String id) {
        add(new H1(String.format("View Meal: %s", id)));
    }
}
