import {LitElement,html,css} from "lit-element"

class MainPage extends LitElement{
    static get styles(){
        return css`
    .body {
      background-color: cornsilk;
      color: red;
    }
          #helloButton{
            font-size: 20px;
            background-color: #877f89;
            color: red;
            margin-left: 200px;
          }
    `;
    }

    render(){

        return html`
        <div id="content"></div>
        <button id="helloButton">Click Me!</button>`
    }
}

customElements.define('main-page', MainPage);