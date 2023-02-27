package org.vaadin.example;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.EmailValidator;
import org.apache.catalina.User;

import java.util.Optional;

@Tag("user-form")
@JsModule("./src/UserForm.js")
public class UserForm extends LitTemplate {

    @Id("email")
    private TextField email;

    @Id("first-name")
    private TextField firstName;

    @Id("last-name")
    private TextField lastName;

    @Id("comments")
    private TextArea comment;

    @Id("action-buttons")
    private Button actionButtons;

    private Binder<User> binder;

    /**
     * Connects the bean to the binder.
     *
     * @param user bean
     */
    public void setBean(User user) {
        binder.setBean(user);
    }

    /**
     * Clears the form and disconnnect any bean.
     */
    public void removeBean() {
        binder.removeBean();
    }

    /**
     * Gets the binder of the UserForm
     *
     * @return binder it binds the fields of an object to the fields shown
     */
    public Optional<User> getBean() {
        return Optional.of(binder.getBean());
    }

    private void initBinder() {
        binder = new Binder<>();

        // email
        binder.forField(email).withValidator(
                new EmailValidator("This doesn't look like a valid email address")
        ).bind(User::getEmail, User::setEmail);

        // firstName
        binder.forField(firstName).withValidator(firstName -> firstName.length() > 1,
                        "The first name must contains at least 2 characters").asRequired()
                .bind(User::getFirstName, User::setFirstName);

        // lastName
        binder.forField(lastName).asRequired("Last name can't be empty")
                .bind(User::getLastName, User::setLastName);

        // comment
        binder.forField(comment).bind(User::getComment, User::setComment);
    }

    public UserForm() {
        initBinder();
    }

}
