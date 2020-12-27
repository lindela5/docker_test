import React from "react";
import Sections from "./Sections";
import axios from "axios";
import {Book} from "./Book";
import Navbar from "./Navbar";

class BookSection extends React.Component {
    state = {
        sectionName: "",
        books: []
    }

    getBooks = () => {
        const config = {headers: {'Accept': 'application/json'}};
        const sectionId = this.props.match.params.id;

        axios.get("/book/getbysection/" + sectionId, config)
            .then(response => this.setState({books: response.data}))
            .catch(error => console.log(error))
    };

    componentDidMount() {
        this.getBooks();
    };


    render() {
        //console.log(this.state.books);
        const books = this.state.books.length > 0 ?
            this.state.books.map((book) => <Book key={book.bookId} book={book}/>) : <div>No such book</div>

        return (<div>
            <Navbar/>
            <Sections/>
            <span>{books}</span>
        </div>);
    }
}

export default BookSection;