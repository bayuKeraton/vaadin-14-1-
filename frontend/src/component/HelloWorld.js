import {css, html, LitElement} from 'lit-element';
import '@vaadin/vaadin-text-field/vaadin-text-field.js';
import '@vaadin/vaadin-button/vaadin-button.js';
import '@axa-ch/input-text';

class HelloWorld extends LitElement {

    static get styles() {
        return css`
          :host {
            display: block;
          }

          #helloButton {
            font-weight: bold;
            border-bottom: 1px solid black;
          }

        `
    }

    render() {
        return html`
            <div>
                <vaadin-text-field id="firstInput"></vaadin-text-field>
                <axa-input-text id="secondInput"></axa-input-text>
                <vaadin-button id="helloButton">Click me!</vaadin-button>
            </div>`;
    }
}

customElements.define('hello-world', HelloWorld);