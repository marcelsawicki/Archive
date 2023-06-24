import React, { Component } from "react";
import { Link } from "react-router-dom";
import { faCartShopping } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

export class CartSummary extends Component {
    getSummary = () => {
        if(this.props.cartItems>0)
        {
            return <span>
                Produktów: {this.props.cartItems} /
                Wartość: {this.props.cartPrice.toFixed(2)} zł
            </span>
        }
        else
        {
            return <span>Koszyk: (jest pusty) </span>
        }
    }

    getLinkClasses = () => {
        return `btn btn-sm bg-dark text-white ${ this.props.cartItems === 0 ? "disabled" : ""}`

    }

    render() {
        return <div className="float-right">
            <small>
                { this.getSummary() }
                <Link className={this.getLinkClasses()} to="/shop/cart">
                <FontAwesomeIcon icon={faCartShopping} />
                </Link>
            </small>
        </div>
    }
}