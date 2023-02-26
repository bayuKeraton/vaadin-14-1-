import {LitElement,html,css} from "lit-element"

class MainPage extends LitElement{
    static get styles(){
        return css`
    :host{
      background-color: cornsilk;
      color: red;
    }
    `;
    }

    render(){
        console.log("Hello World");
        return html`
        <div id="content"></div>
        <button id="helloButton">Click Me!</button>`
    }
}

customElements.define('main-page', MainPage);