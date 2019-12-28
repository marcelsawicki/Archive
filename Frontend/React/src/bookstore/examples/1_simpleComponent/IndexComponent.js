var React = require('react')
// var ReactDOM = require('react-dom')
var SimpleComponent = require('./SimpleComponent')

// class SimpleComponent extends React.Component {}

var IndexComponent = React.createClass({
  render () {
    return (
      <div>
        <SimpleComponent name='sent by props.' />
      </div>
    )
  }
})

module.exports = IndexComponent
// ReactDOM.render(<SimpleComponent />, document.getElementById('app'))
