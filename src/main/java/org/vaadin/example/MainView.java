package org.vaadin.example;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.apache.catalina.User;

import java.util.Optional;


@Route
@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")

@Tag("main-view")
@JsModule("./src/main-view.ts")
public class MainView extends LitTemplate {

    @Id("user-form")
    private UserForm userForm;

    @Id("users-grid")
    private UsersGrid usersGrid;

    public MainView(){
        usersGrid.addSelectionListener(selectionEvent -> {
        Optional<User> optionalUser = usersGrid.getSelectedItems().stream().findAny();

        if (optionalUser.isPresent()) {
            userForm.setBean(optionalUser.get());
            setEditionEnabled(true);
        } else {
            userForm.removeBean();
            setEditionEnabled(false);
        }
    });

    initFormListeners();


    }
}
