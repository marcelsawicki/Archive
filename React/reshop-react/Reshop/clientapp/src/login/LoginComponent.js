import React, { Component } from "react";
import { Link } from "react-router-dom";
import { CartSummary } from "../data/CartSummary";

export class LoginComponent extends Component {
    
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
        <div className="text-center">
            <form className="form-signin">
                    <img class="mb-4" src="dc.png" alt="" width="72" height="72"/>
                    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
                    <label for="inputEmail" class="sr-only">Email address</label>
                    <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus/>
                    <label for="inputPassword" class="sr-only">Password</label>
                    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required/>
                    <div class="checkbox mb-3">
                    <label>
                        <input type="checkbox" value="remember-me"/> Remember me
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            <p class="mt-5 mb-3 text-muted">&copy; 2023</p>
            </form>
        </div>
        </div>
    </div>
        
    }
}