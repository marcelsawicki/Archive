import React, { Component } from "react";

export class CartDetailsRows extends Component {
    render() {
        if(!this.props.cart || this.props.cart.length === 0)
        {
            return <tr>
                <td colSpan="5">Twój koszyk jest pusty</td>
            </tr>
        }
        else
        {
            return <React.Fragment>
                {this.props.cart.map(item =>
                    <tr key={item.product.id}>
                        <td>
                            <input type="number" value={item.quantity} onChange={(ev)=>this.handleChange(item.product, ev)}/>
                        </td>
                        <td>{item.product.name}</td>
                        <td>{item.product.price.toFixed(2)} zł</td>
                        <td>{(item.quantity*item.product.price).toFixed(2)} zł</td>
                        <td>
                            <button className="btn btn-sm btn-danger" onClick={()=>this.props.removeFromCart(item.product)}>Usuń</button>
                        </td>
                    </tr>
                )}
                <tr>
                    <th colSpan="3">Wartość sumaryczna:</th>
                    <th colSpan="2">{this.props.cartPrice.toFixed(2)} zł</th>
                </tr>
            </React.Fragment>
        }
        
    }
}