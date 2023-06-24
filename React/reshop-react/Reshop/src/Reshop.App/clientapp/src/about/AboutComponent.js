import React, { Component } from "react";
import { Link } from "react-router-dom";
import { CartSummary } from "../data/CartSummary";

export class AboutComponent extends Component {
    render() {
        return <div className="container-fluid">
            <div className="row">
                <div className="col bg-dark text-white p-2">
                    <div className="navbar-brand">Sklep SPORTSTORE</div>
                    <Link to="/about"><button class="btn btn-sm">About</button></Link>
                </div>
            </div>
            <Link className="btn btn-primary m-1" to="/shop">Kontynuuj zakupy</Link>
            <table class="table">
            <thead>
                <tr>
                <th scope="col">#</th>
                <th scope="col">Data</th>
                <th scope="col">Wpis</th>
                <th scope="col">Komentarz</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                <th scope="row">1</th>
                <td>2022-12-28</td>
                <td>Koszyk</td>
                <td>Szczegóły zawartosci koszyka</td>
                </tr>
                <tr>
                <th scope="row">2</th>
                <td>2022-12-29</td>
                <td>Formularz zamówienia</td>
                <td>Szczegóły</td>
                </tr>
                <tr>
                <th scope="row">3</th>
                <td>2022-12-30</td>
                <td>Walidacja formularza zamówienia</td>
                <td>Walidacja formularza zamówienia</td>
                </tr>
            </tbody>
            </table>
        </div>
    }
}