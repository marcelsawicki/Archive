import logo from './logo.svg';
import './App.css';
import React, { Component } from 'react';
import { SportStoreDataStore } from './data/DataStore';
import { Provider } from "react-redux";
import { Routes, Route, BrowserRouter as Router, Switch, Redirect  } from "react-router-dom";
import { ShopConnector } from './shop/ShopConnector';
import { AboutComponent } from './about/AboutComponent';
import { LoginComponent } from './login/LoginComponent';

export default class App extends Component {
  render(){
    return <div>
      <Provider store={SportStoreDataStore} >
      <Router>
        <Switch>
          <Route path="/shop" component={ShopConnector}></Route>
          <Route path="/about" component={AboutComponent}></Route>
          <Route path="/loginprompt" component={LoginComponent}></Route>
          <Route exact path="/edu1" render={() => { window.location.href = "edu1.html" }} />
          <Route exact path="/edu2" render={() => { window.location.href = "edu2.html" }} />
          <Route exact path="/edu3" render={() => { window.location.href = "edu2.html" }} />
          <Redirect to="/shop" />
        </Switch>
        </Router>
      </Provider>
      </div>
    }
}
