package com.example.application.views;

import com.example.application.components.grid.GridLayout;
import com.example.application.components.grid.GridTrack;
import com.example.application.entities.Meal;
import com.example.application.repositories.MealRepo;
import com.example.application.services.MealService;
import com.nimbusds.jose.crypto.ECDH1PUX25519Decrypter;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import lombok.RequiredArgsConstructor;
import org.hibernate.dialect.function.array.H2ArrayContainsFunction;

@Route("view")
@RequiredArgsConstructor
public class MealView extends VerticalLayout implements HasUrlParameter<String> {
    private final MealService mealService;

    @Override
    public void setParameter(BeforeEvent beforeEvent, String idStr) {
        Long id = Long.valueOf(idStr);
        var mealOpt = mealService.findById(id);

        if (mealOpt.isEmpty()) {
            add(new Paragraph("Mahlzeit wurde nicht gefunden!"));
            return;
        }

        Meal meal = mealOpt.get();

        var title = new H1(meal.getName());
        var caloriesHeader = new H2("%d kcal".formatted(meal.getCalories()));

        var nutritionGrid = new GridLayout(new GridTrack.Count(2));
        var tmpl = "%dg %s";
        nutritionGrid.add(
                new Paragraph(tmpl.formatted(meal.getCarbs(), "Kohlenhydrate")),
                new Paragraph(tmpl.formatted(meal.getProtein(), "Protein")),
                new Paragraph(tmpl.formatted(meal.getFats(), "Fett")),
                new Paragraph(tmpl.formatted(meal.getFibers(), "Ballaststoffe"))
        );

        var buttonLayout = new HorizontalLayout();
        var backButton = new Button("Zurück", e -> {
            UI.getCurrent().navigate(MainView.class);
        });
        var editButton = new Button("Bearbeiten");
        buttonLayout.add(backButton, editButton);

        add(title, caloriesHeader, nutritionGrid, buttonLayout);
    }
}
