var React = require('react')
// var ReactDOM = require('react-dom')
var MyLabel = require('./MyLabel')
var green = '#39D1B4'
var yellow = '#FFD712'
var myPropsMessage = 'I am sending this props to component.'

var MyColors = React.createClass({
  getInitialState: function () {
    return {
      color: green,
      tresc: 'Please push the button.'
    }
  },
  changeColor: function () {
    var color = this.state.color === green ? yellow : green
    this.setState({ color: color })
    var tresc = this.state.tresc === 'The button has been unpushed' ? 'The button has been pushed' : 'The button has been unpushed'
    this.setState({ tresc: tresc })
  },
  render: function () {
    return (
      <div style={{ background: this.state.color }}>
        Example of set state usage and multiply components: <br />
        <button onClick={this.changeColor} className='btn btn-primary'> Change color </button>
        <br />
        <MyLabel fullName={myPropsMessage} />
        <br />
        <label>{this.state.tresc} </label>
        <br />
      </div>
    )
  }
})

module.exports = MyColors
