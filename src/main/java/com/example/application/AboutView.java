package com.example.application;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("/about")
public class AboutView extends VerticalLayout {
    public AboutView() {
        var mainText = new Paragraph("""
                 Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                 Sed semper erat vel elit scelerisque, eu porta tellus dictum.
                 Phasellus lobortis cursus arcu vitae pretium. Vestibulum et aliquam tellus.
                 Praesent urna nunc, egestas ac tempor in, laoreet vitae lorem.
                 Maecenas gravida eros nec turpis volutpat, a fermentum tellus imperdiet.
                 Proin tristique rhoncus ex, non vestibulum dolor consequat eleifend.
                 Etiam sagittis ligula at ipsum sodales, in pharetra mi suscipit.
                 Quisque et tortor ac massa laoreet mattis. Phasellus ut erat sit amet magna vulputate facilisis.
                 Curabitur a venenatis augue. Vestibulum aliquam purus non turpis consectetur hendrerit.
                 Etiam ultricies rutrum sem, ac mollis sapien vestibulum sit amet.
                """);

        add(new H1("About"), mainText, new RouterLink("Home", MainView.class));
    }
}
