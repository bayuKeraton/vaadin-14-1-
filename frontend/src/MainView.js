import {LitElement, html} from 'lit-element';
import '@vaadin/vaadin-grid/vaadin-grid.js'
import './component/UserForm.js';

class MainView extends LitElement {
    render() {
        return html`
            <div id="main-container">
                <vaadin-grid id="users-grid"></vaadin-grid>
                <user-form id="user-form"></user-form>
            </div>`;
    }
}

customElements.define('main-view', MainView);