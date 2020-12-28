import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
// import {Button} from '@material-ui/core';
import './Book.css';
// import {
//     Card, CardImg, CardText, CardBody,
//     CardTitle, CardSubtitle, Button
// } from 'reactstrap';
import {
    Card,  Button
} from "react-bootstrap";


export class Book extends React.Component {

    constructor(props) {
        super(props);
    }


    render = () => {
        const authors = this.props.book.bookAuthor.map(author => author.authorLastName).join(", ");
        console.log(this.props.book.bookAuthor)
        return (<Card key={this.props.book.bookId} className="card">
                {/*{this.props.book.bookTitle}*/}
                <Card.Img className="card-img-top" variant="top" src={this.props.book.picture}/>
                <Card.Body>
                    {/*<CardTitle>{this.props.book.bookTitle}</CardTitle>*/}
                    <Card.Text>
                        <span>Author(s): {authors}</span><br />
                        <span>Year: {this.props.book.yearOfIssue}</span><br />
                        <span>Price: {this.props.book.price}$</span>
                    </Card.Text>
                    <Button variant="primary">Купить</Button>
                </Card.Body>

            </Card>)

    };

}
