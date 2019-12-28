var React = require('react')
// var ReactDOM = require('react-dom')

var Change = React.createClass({
  getInitialState: function () {
    return ({name: 'How to handle event?'})
  },
  handleChange: function (event) {
    this.setState({ name: event.target.value })
  },
  render: function () {
    return (
      <div>
        <p>{ this.state.name }</p>
        <input type='text' value={this.state.name} onChange={this.handleChange} />
      </div>
    )
  }
})

// ReactDOM.render(<Change />, document.getElementById('app'))

module.exports = Change
