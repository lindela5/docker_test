import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
// import {Button} from '@material-ui/core';
import './Book.css';
import {
    Card, CardImg, CardText, CardBody,
    CardTitle, CardSubtitle, Button
} from 'reactstrap';

export class Book extends React.Component {

    constructor(props) {
        super(props);
    }


    render = () => {
        const authors = this.props.book.bookAuthor.map(author => author.authorLastName).join(", ");
        console.log(this.props.book.bookAuthor)
        return (<div key={this.props.book.bookId}>
            <Card className="card" style={{width: '18rem'}}>
                {/*{this.props.book.bookTitle}*/}
                <CardImg className="card-img-top" variant="top" src={this.props.book.picture}/>
                <CardBody>
                    {/*<CardTitle>{this.props.book.bookTitle}</CardTitle>*/}
                    <CardText>
                        <span>Author(s): {authors}</span><br />
                        <span>Year: {this.props.book.yearOfIssue}</span><br />
                        <span>Price: {this.props.book.price}$</span>
                    </CardText>
                    <Button variant="primary">Купить</Button>
                </CardBody>

            </Card>
        </div>)

    };

}
