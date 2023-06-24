import React, { Component } from "react";
import { Link } from "react-router-dom";

export class Thanks extends Component {
    render() {
        return <div className="container-fluid">
            <div className="row">
                <div className="col bg-dark text-white p-2">
                    <div className="navbar-brand">Sklep SPORTSTORE</div>
                    <Link to="/about"><button class="btn btn-sm">About</button></Link>
                </div>
            </div>
            <div className="m-2 text-center">
                <h2>Dziękujemy!</h2>
                <p>Dziękujemy za złozenie zamówienia.</p>
                <p>Twoje zamówienie ma numer: #</p>
                <p>Zamówione produkty wyslemy możliwie jak najszybciej.</p>
                <Link to="/shop" className="btn btn-primary">Wróć do sklepu</Link>
            </div>
        </div>
    }
}