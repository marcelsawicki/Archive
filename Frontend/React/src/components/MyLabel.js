var React = require('react')
// var ReactDOM = require('react-dom')

var MyTextLabel = React.createClass({
  propTypes: { fullName: React.PropTypes.string },
  render () {
    return (<label> {this.props.fullName} </label>)
  }
})

module.exports = MyTextLabel
