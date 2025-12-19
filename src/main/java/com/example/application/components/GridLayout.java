package com.example.application.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;

public class GridLayout extends Div {
    public GridLayout(Component... children) {
        getStyle().set("display", "grid").set("grid-template-columns", "repeat(auto-fit, minmax(250px, 1fr))").set("gap", "1rem");
        add(children);
    }
}
