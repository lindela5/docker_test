import React from "react";
import Navbar from "./Navbar";
import {getBooks} from "../api/BookApi";

export default function Main() {
    getBooks();
    return <div>
        <Navbar/>
        <span>  {this.state.books.length > 0  &&
        this.state.books.map((book, key) =>
           {return <div>book.id</div>}
        )
        }</span>
    </div>;
};