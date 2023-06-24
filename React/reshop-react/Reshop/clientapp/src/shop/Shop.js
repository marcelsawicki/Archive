import React, { Component } from "react";
import { CategoryNavigation } from "./CategoryNavigation";
import { ProductList } from "./ProductList";
import { CartSummary } from "../data/CartSummary";
import Link from "react-router-dom/Link";

export class Shop extends Component {
    render() {
        return <div className="container-fluid">
            <div className="row">
                <div className="col bg-dark text-white p-2">
                    <div className="navbar-brand">Sklep SPORTSTORE</div>
                    <Link to="/about"><button class="btn btn-sm">About</button></Link>
                    <Link to="/loginprompt"><button class="btn btn-sm" id="login1">Login</button></Link>
                    <CartSummary {...this.props } />
                </div>
            </div>
            <div className="row">
                <div className="col-3 p-2">
                    <CategoryNavigation baseUrl="/shop/products" categories={ this.props.categories } />
                </div>
                <div className="col-9 p-2">
                    <ProductList products={ this.props.products } addToCart={ this.props.addToCart }/>
                </div>
            </div>
        </div>
    }
}