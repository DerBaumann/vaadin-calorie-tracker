package com.example.application.layouts;

import com.example.application.views.AddView;
import com.example.application.views.MainView;
import com.example.application.views.SettingsView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.router.RouterLink;

@Layout
public class MainLayout extends AppLayout {
    public MainLayout() {
        var layout = new HorizontalLayout(new RouterLink("Home", MainView.class), new RouterLink("Add", AddView.class), new RouterLink("Settings", SettingsView.class));
        layout.getThemeList().add("spacing");

        addToNavbar(layout);
    }
}
