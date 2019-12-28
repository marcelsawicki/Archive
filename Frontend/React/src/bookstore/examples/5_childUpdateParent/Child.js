var React = require('react')

var Child = React.createClass({
  propTypes: {
    name: React.PropTypes.string,
    onChange: React.PropTypes.func
  },
  handleChange: function (e) {
    var name = e.target.value
    this.props.onChange(name)
  },
  render: function () {
    return (
      <div>
        <h1>
          Hey my name is {this.props.name}!
        </h1>
        <select
          onChange={this.handleChange} id='great-names'>
          <option value='Frarthur'>
            Frarthur
          </option>

          <option value='Gromulus'>
            Gromulus
          </option>

          <option value='Thinkpiece'>
            Thinkpiece
          </option>
        </select>
      </div>
    )
  }
})

Child.propTypes = {
  name: React.PropTypes.string }

module.exports = Child
