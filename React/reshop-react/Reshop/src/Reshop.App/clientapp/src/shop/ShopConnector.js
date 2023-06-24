import React, { Component } from "react";
import { Route, Routes, Switch, Redirect } from "react-router-dom";
import { connect } from "react-redux";
import { loadData } from "../data/ActionCreators";
import { DataTypes } from "../data/Types";
import { Shop } from "./Shop";
import {addToCart, updateCartQuantity, removeFromCart, clearCart } from "../data/CartActionCreators";
import { CartDetails } from "./CartDetails";
import { Checkout } from "./Checkout";
import { Thanks } from "./Thanks";

const mapStateToProps = (dataStore) => ({
    ...dataStore
})

const mapDispatchToProps = {
    loadData, addToCart, updateCartQuantity, removeFromCart, clearCart
}

const filterProducts = (products = [], category) =>
(!category || category === "Wszystkie") ? products : products.filter(p => p.category.toLowerCase() === category.toLowerCase());

export const ShopConnector = connect(mapStateToProps, mapDispatchToProps)(
    class extends Component {
        render() {
            return <Switch>
                <Route path="/shop/products/:category?" render={(routeProps) => <Shop {...this.props} {...routeProps} products={filterProducts(this.props.products, routeProps.match.params.category)} />} />
                <Route path="/shop/cart" render={(routeProps) => <CartDetails {...this.props} {...routeProps} />} />
                <Route path="/shop/checkout" render={(routeProps) => <Checkout {...this.props} {...routeProps} />} />
                <Route path="/shop/thanks" render={(routeProps) => <Thanks {...this.props} {...routeProps} />} />
                <Redirect to="/shop/products" />
            </Switch>
        }
        componentDidMount() {
            this.props.loadData(DataTypes.CATEGORIES);
            this.props.loadData(DataTypes.PRODUCTS);
        }
    }
)