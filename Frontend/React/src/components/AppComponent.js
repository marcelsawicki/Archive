var React = require('react')
// var ReactDOM = require('react-dom')

class AppComponent extends React.Component {
  constructor (props) {
    super(props)
    this.state = {
      like: 0,
      unlike: 0
    }
  }
  onButtonClickLike () {
    this.setState({ like: this.state.like + 1 })
  }
  onButtonClickUnlike () {
    this.setState({ unlike: this.state.unlike + 1 })
  }
  render () {
    return (
      <div className='messageTemplate'>
        <label> New message: { this.props.textMessage } </label>
        <button className='btn btn-primary' onClick={() => this.onButtonClickLike()}> Like {this.state.like}</button>
        <button className='btn btn-primary' onClick={() => this.onButtonClickUnlike()}> Unlike {this.state.unlike}</button>
      </div>
    )
  }
}

AppComponent.propTypes = {

  textMessage: React.PropTypes.string }

module.exports = AppComponent

