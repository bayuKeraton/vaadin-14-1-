package org.vaadin.example;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.polymertemplate.Id;

//interact with MainPage.ts
@Tag("main-page")
//module of the TS file
@JsModule("./src/MainPage.js")
public class MainPage extends LitTemplate {
    @Id("content")
    private Div content;

    @Id("helloButton")
    private NativeButton helloButton;

    public MainPage(){
        helloButton.addClickListener(e->{
            System.out.println("Clicked !");
        });
    }

    public void setContent(Component content){
        this.content.removeAll();
        this.content.add(content);
    }

}
