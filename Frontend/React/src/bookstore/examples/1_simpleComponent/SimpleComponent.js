var React = require('react')
// var ReactDOM = require('react-dom')
var element = <h1>Hello, world!</h1>
// class SimpleComponent extends React.Component {}

var SimpleComponent = React.createClass({
  propTypes: {
    name: React.PropTypes.string
  },
  render () {
    return (
      <div>
        <h1> JSX variable: { element } props:{ this.props.name } </h1>
      </div>
    )
  }
})

module.exports = SimpleComponent
// ReactDOM.render(<SimpleComponent />, document.getElementById('app'))

