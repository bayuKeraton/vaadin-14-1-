package org.vaadin.example;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.littemplate.LitTemplate;

@Tag("hello-world")
@NpmPackage(value = "@axa-ch/input-text", version = "4.3.11")
@JsModule("./src/component/HelloWorld.js")
public class HelloWorld extends LitTemplate {

    /**
     * Creates the hello world template.
     */
    public HelloWorld() {
    }
}