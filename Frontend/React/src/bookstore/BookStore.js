var React = require('react')
var ReactDOM = require('react-dom')

var BookList = React.createClass({
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
  handleSelectedBooks (event) {
    var selectedBooks = this.state.selectedBooks
    var index = selectedBooks.indexOf(event.target.value)

    if (event.target.checked) {
      if (index === -1) { selectedBooks.push(event.target.value) }
    } else { selectedBooks.splice(index, 1) }

    this.setState({ selectedBooks: selectedBooks })
  },
  render () {
    return (
      <div>
        <h3> Choose from wide variety of books available in our store </h3>
        <form onSubmit={this.handleSubmit}>{ this.state.books.map((book) => { return this._renderBook(book) }) }
          <input type='submit' className='btn btn-success' />
        </form>
      </div>
    )
  },
  handleSubmit (event) {
    event.preventDefault()
    this.props.updateFormData({ selectedBooks: this.state.selectedBooks })
  }
})

var ShippingDetails = React.createClass({ render () { return (<h1> Enter your shipping information. </h1>) } })

var DeliveryDetails = React.createClass({ render () { return (<h1> Choose your delivery options here. </h1>) } })

var BookStore = React.createClass({
  getInitialState () {
    return ({ currentStep: 1, formValues: {} })
  },

  // Updating BookStore component
  updateFormData (formData) {
    var formValues = Object.assign({}, this.state.formValues, formData)
    var nextStep = this.state.currentStep + 1
    this.setState({currentStep: nextStep, formValues: formValues})
    console.log(formData)
  },
  render () {
    switch (this.state.currentStep) {
      case 1:
        return <BookList updateFormData={this.updateFormData} />
      case 2:
        return <ShippingDetails updateFormData={this.updateFormData} />
      case 3:
        return <DeliveryDetails updateFormData={this.updateFormData} />
    }
  }
})

 // module.exports = BookStore
ReactDOM.render(<BookStore />, document.getElementById('app'))
