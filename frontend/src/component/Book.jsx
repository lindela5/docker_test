import React from "react";

export class Book extends React.Component {

    constructor(props) {
        super(props);
    }

    render = () => {
        return <div key={this.props.book.bookId}>{this.props.book.bookTitle}</div>
    };

}