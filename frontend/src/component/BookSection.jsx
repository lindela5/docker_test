import React from "react";
import Sections from "./Sections";
import axios from "axios";
import {Book} from "./Book";
import Navbar from "./Navbar";
import {CardGroup} from 'reactstrap';
import './Book.css';

class BookSection extends React.Component {
    state = {
        sectionName: "",
        books: []
    }
    constructor(props) {
        super(props);
    }


    getBooks = () => {
        const config = {headers: {'Accept': 'application/json'}};

        let urlBooks;

        if (this.props.all) {
            urlBooks = "/book/findAll";
        } else {
            const sectionId = this.props.match.params.id;
            urlBooks = "/book/getbysection/" + sectionId;
        }

        axios.get(urlBooks, config)
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
            <CardGroup className="cardgroup">
            <span>{books}</span>
            </CardGroup>
        </div>);
    }
}

export default BookSection;