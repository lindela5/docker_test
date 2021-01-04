import React from "react";
import Navbar from "./Header";
import axios from "axios";
// import {Book} from "./Book";
import Sections from "./Sections";
import BookSection from "./BookSection";
import {Route} from "react-router-dom";
import Books from "./Books";
import './Book.css';


export class Main extends React.Component {



    render = () => {

        return (
// <div><span>sss</span></div>
            <>
                {/*<BrowserRouter>*/}
                {/*<Switch>*/}
                <Route exact path="/" render={() => <BookSection all={true}/>}/>
                <Route exact path="/books" component={Books}/>
                <Route exact path="/section/:id" component={BookSection}/>
                {/*</Switch>*/}
                {/*</BrowserRouter>*/}
            </>
        );
    };



};