package com.example.application.layouts;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class MainLayout extends VerticalLayout {
    public MainLayout() {
        addClassNames(
                LumoUtility.MaxWidth.SCREEN_MEDIUM,
                LumoUtility.Margin.Horizontal.AUTO
        );
    }
}
