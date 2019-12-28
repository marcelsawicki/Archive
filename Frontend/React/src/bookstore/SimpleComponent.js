var React = require('react')
var ReactDOM = require('react-dom')

// class SimpleComponent extends React.Component {}

var SimpleComponent = React.createClass({
  render () {
    return (
      <div>
        <h1> a Component </h1>
      </div>
    )
  }
})

// module.exports = SimpleComponent
ReactDOM.render(<SimpleComponent />, document.getElementById('app'))

