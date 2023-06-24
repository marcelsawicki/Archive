import React, { Component } from "react";
import { Link } from "react-router-dom";

export class Checkout extends Component {
    constructor(props) {
        super(props);
        this.defaultAttrs = { type: "text", required: true };
        this.formModel = [
            { label: "Imię i nazwisko" },
            { label: "Adres e-mail", attrs: { type: "email" } },
            { label: "Adres" },
            { label: "Miejscowość"},
            { label: "Kod pocztowy", name: "zip" },
            { label: "Kraj" }
        ]
    }

    render() {
        return <div className="container-fluid">
            <div className="row">
                <div className="col bg-dark text-white p-2">
                    <div className="navbar-brand">Sklep SPORTSTORE</div>
                    <Link to="/about"><button class="btn btn-sm">About</button></Link>
                </div>
            </div>
            <div className="col m-2">
                <p>Formularz</p>
                <Link to="/shop/thanks"><button class="btn btn-sm">Potwierdz złożenie zamówienia</button></Link>
            </div>
        </div>
    }
}