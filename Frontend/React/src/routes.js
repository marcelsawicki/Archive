// routes.js
import { React } from 'react'
// import { ReactDOM } from 'react-dom'
import { Route } from 'react-router'
// import {EssayForm} from './Index'
import {SimpleComponent} from './bookstore/examples/1_simpleComponent/IndexComponent'
import {Change} from './bookstore/examples/2_handleChange/Change'
import {MyColors} from './components/MyColors'
import {MapArray} from './bookstore/examples/4_mapArray/MapArray'
import {Parent} from './bookstore/examples/5_childUpdateParent/Parent'
// import {AppComponent} from './components/AppComponent'
const routes =
  <Route>
    <Route path='/example1' component={SimpleComponent} />
    <Route path='/example2' component={Change} />
    <Route path='/example3' component={MyColors} />
    <Route path='/example4' component={MapArray} />
    <Route path='/example5' component={Parent} />
  </Route>

export default routes

