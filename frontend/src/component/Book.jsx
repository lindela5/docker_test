import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
// import {Button} from '@material-ui/core';
import {
    Card, CardImg, CardText, CardBody,
    CardTitle, CardSubtitle, Button
} from 'reactstrap';

export class Book extends React.Component {

    constructor(props) {
        super(props);
    }



    render = () => {
        return (<div key={this.props.book.bookId}>
            <Card style={{width: '18rem'}}>
                {/*{this.props.book.bookTitle}*/}
                <CardImg variant="top" src={this.props.book.picture}/>
                <CardBody>
                    <CardTitle>{this.props.book.bookTitle}</CardTitle>
                    <CardText>
                        {/*<span>Author(s): {this.props.book.bookAuthor}</span>*/}
                        <span>Year: {this.props.book.yearOfIssue}</span>
                        <span>Price: {this.props.book.price}$</span>
                            </CardText>
                    <Button variant="primary">Купить</Button>
                </CardBody>

            </Card>
        </div>)

    };

}