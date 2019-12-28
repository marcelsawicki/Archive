var React = require('react')
// var ReactDOM = require('react-dom')

// class SimpleComponent extends React.Component {}
var MapArray = React.createClass({
  getInitialState () {
    return ({ books: [
        { id: 1, name: 'Zero to One', author: 'Peter Thiel' },
        { id: 2, name: 'Monk who sold his Ferrari', author: 'Robin Sharma' },
        { id: 3, name: 'Wings of Fire', author: 'A.P.J. Abdul Kalam' }
    ],
      selectedBooks: []
    })
  },
  _renderBook (book) {
    return (
      <div className='checkbox' key={book.id}>
        <label><input type='checkbox' value={book.name} onChange={this.handleSelectedBooks} /> {book.name} -- {book.author} </label>
      </div>
    )
  },
  render () {
    return (
      <div className='checkbox'>
        <label>{ this.state.books.map((book) => { return this._renderBook(book) }) }</label>
      </div>
    )
  }
})

module.exports = MapArray
// ReactDOM.render(<SimpleComponent />, document.getElementById('app'))
