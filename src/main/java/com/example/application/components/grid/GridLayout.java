package com.example.application.components.grid;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;


public class GridLayout extends Div {
    public GridLayout(GridTrack cols, Component... children) {
        getStyle().set("display", "grid").set("grid-template-columns", String.format("repeat(%s, minmax(250px, 1fr))", cols.toCss())).set("gap", "1rem");
        add(children);
    }

    public GridLayout(Component... children) {
        this(new GridTrack.AutoFit(), children);
    }
}
