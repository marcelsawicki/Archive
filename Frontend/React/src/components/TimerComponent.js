var React = require('react')
// var ReactDOM = require('react-dom')

class TimerComponent extends React.Component {
  constructor (props) {
    super(props)
    this.state = {
    }
  }
  render () {
    return (
      <div>
        <label>{new Date().toDateString()}</label>
      </div>
    )
  }
}

module.exports = TimerComponent
