package com.example.application.components;

import com.example.application.entities.Meal;
import com.example.application.services.MealService;
import com.example.application.views.MealView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.List;
import java.util.function.Consumer;

public class MealList extends UnorderedList {
    public MealList(List<Meal> meals, Consumer<Meal> onDelete) {

        addClassNames(
                LumoUtility.Padding.NONE,
                LumoUtility.Margin.NONE,
                LumoUtility.Width.FULL,
                LumoUtility.ListStyleType.NONE
        );

        if (meals.isEmpty()) {
            add(new Paragraph("Keine Mahlzeiten gefunden"));
        } else {
            for (Meal meal : meals) {
                add(new ListItem(mealCard(meal, onDelete)));
            }
        }
    }

    public HorizontalLayout mealCard(Meal meal, Consumer<Meal> onDelete) {
        var layout = new HorizontalLayout();

        layout.addClassNames(
                "meal-card",
                LumoUtility.Padding.Horizontal.XLARGE,
                LumoUtility.Padding.Vertical.MEDIUM,
                LumoUtility.Margin.Vertical.MEDIUM,
                LumoUtility.Gap.XLARGE
        );
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        var startContainer = new HorizontalLayout();
        startContainer.add(new Paragraph(meal.getName()));

        var endContainer = new HorizontalLayout();
        endContainer.add(
                new Paragraph("%d kcal".formatted(meal.getCalories())),
                new Button(VaadinIcon.SEARCH.create(), e -> {
                    UI.getCurrent().navigate(MealView.class, meal.getId().toString());
                }),
                new Button("X", e -> onDelete.accept(meal))
        );


        layout.add(startContainer, endContainer);
        return layout;
    }
}
