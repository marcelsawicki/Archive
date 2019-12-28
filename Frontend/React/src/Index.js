var React = require('react')
var ReactDOM = require('react-dom')

var AppComponent = require('./components/AppComponent')
var SimpleComponent = require('./bookstore/examples/1_simpleComponent/IndexComponent')
var Change = require('./bookstore/examples/2_handleChange/Change')
var MyColors = require('./components/MyColors') // example3
var MapArray = require('./bookstore/examples/4_mapArray/MapArray')
var Parent = require('./bookstore/examples/5_childUpdateParent/Parent')
// import routes from './routes'
import { Router, Route, IndexRoute, browserHistory, Link } from 'react-router'

// var facebook1 = '#3b5998'
var facebook2 = '#8b9dc3'
// var facebook3 = '#dfe3ee'
var myMessage = []

class EssayForm extends React.Component {
  constructor (props) {
    super(props)
    this.state = {
      value: 'Please write message.',
      wiadomosc: 'Waiting.',
      text: 'Not clicked!'
    }
    this.handleChange = this.handleChange.bind(this)
    // this.handleChange = () => this.handleChange()
    this.handleSubmit = this.handleSubmit.bind(this)
  }

  handleChange (event) {
    this.setState({ value: event.target.value })
  }

  handleSubmit (event) {
    myMessage.push(this.state.value)
    var listMessage = myMessage.map((message, index) => <ol className='letter' key={index}> <AppComponent textMessage={message} /> </ol>)
    this.setState({ wiadomosc: listMessage.reverse() })
    event.preventDefault()
  }

  onButtonClick () {
    if (this.state.text === 'Clicked!') {
      this.setState({ text: 'Not clicked!' })
    } else {
      this.setState({ text: 'Clicked!' })
    }
  }

  render () {
    return (
      <div style={{ background: facebook2 }}>
        <div >
          <Link to='/example1' className='routeLinks'> example1 </Link>
          <Link to='/example2' className='routeLinks'> example2 </Link>
          <Link to='/example3' className='routeLinks'> example3 </Link>
          <Link to='/example4' className='routeLinks'> example4 </Link>
          <Link to='/example5' className='routeLinks'> example5 </Link>
        </div>
        <form onSubmit={this.handleSubmit}>
          <div className='areaFrame'>
            <br />
            <h1 style={{ color: '#ffffff' }}>Local wall:</h1> <br />
            <textarea value={this.state.value} onChange={this.handleChange} cols='80' rows='2' /> <br /> <br />
            <input type='submit' value='Send message' className='btn btn-primary' /> <br />
          </div>
        </form>
        <br />
        { 'prefix - ' + this.state.value + ' - suffix'} <br />
        <label> {this.state.wiadomosc} </label>
        <br /><br />
        <p>{this.state.text}</p>
        <button onClick={() => this.onButtonClick()} className='btn btn-danger'>Click</button>
        {/* <MyColors /> */}
      </div>
    )
  }
}

// ReactDOM.render goes here:
ReactDOM.render(
  <Router history={browserHistory}>
    <IndexRoute component={EssayForm} />
    <Route path='/' component={EssayForm} />
    <Route path='/example1' component={SimpleComponent} />
    <Route path='/example2' component={Change} />
    <Route path='/example3' component={MyColors} />
    <Route path='/example4' component={MapArray} />
    <Route path='/example5' component={Parent} />
  </Router>
, document.getElementById('app'))

/* const userRoutes = (
  <Route >
    <Route path='/example1' component={SimpleComponent} />
    <Route path='/example2' component={Change} />
    <Route path='/example3' component={MyColors} />
    <Route path='/example4' component={MapArray} />
    <Route path='/example5' component={Parent} />
  </Route>
)

// module.export = EssayForm
// ReactDOM.render goes here:
ReactDOM.render(
  <Router history={browserHistory}>
    <IndexRoute component={EssayForm} />
    {userRoutes}
  </Router>
, document.getElementById('app')) */

