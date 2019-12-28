// src/index.js
var React = require('react')
var ReactDOM = require('react-dom')

var InputExample = React.createClass({
  getInitialState () {
    return ({ name: '-' })
  },
  handleChange (event) {
    this.setState({ name: event.target.value })
  },
  render () {
    return (<input type='text' value={this.state.name} onChange={this.handleChange} />
    )
  }
})

// module.exports = BookStore
ReactDOM.render(<InputExample />, document.getElementById('app'))

/* <button onClick={(this.onButtonClick.bind(this))}> Click </button>

<button onClick={() => { return this.onButtonClick() }}> Click </button>

<button onClick={() => this.onButtonClick() }> Click </button> */

var myVariable = <h1>I am a nav bar</h1>

var myObject = {
  center: <li>Ben Wallace</li>,
  powerForward: <li>Rasheed Wallace</li>,
  smallForward: <li>Tayshaun Prince</li>,
  shootingGuard: <li>Richard Hamilton</li>,
  pointGuard: <li>Chauncey Billups</li>
}

