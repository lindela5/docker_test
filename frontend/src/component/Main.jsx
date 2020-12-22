import React from "react";
import Navbar from "./Navbar";
import axios from "axios";
import {Book} from "./Book";

export class Main extends React.Component {
    state = {
        books: []
    }

    componentDidMount() {
        this.getBooks();
    };

    render = () => {
        console.log(this.state.books);
        const books = this.state.books.length > 0 ?
            this.state.books.map((book) => <Book book={book}/>) : <div>No such book</div>

        return (<div>
            <Navbar/>
            <span>{books}</span>
        </div>);
    };


    getBooks = () => {
        const config = {headers: {'Accept': 'application/json'}};

        axios.get("/book/findAll", config)
            .then(response => this.setState({books: response.data}))
            .catch(error => console.log(error))
    };
};