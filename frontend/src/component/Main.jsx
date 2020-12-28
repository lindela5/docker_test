import React from "react";
import Navbar from "./Navbar";
import axios from "axios";
import {Book} from "./Book";
import Sections from "./Sections";
import BookSection from "./BookSection";

export class Main extends React.Component {



     render = () => {

        return (<div>
            <div className="fig"><img src="https://i.ibb.co/tzy7qSS/unnamed.png" className="img-fluid"
                                      alt="Responsive image">
            </img>
            </div>
            {/*<Navbar/>*/}
            {/*<Sections/>*/}
            <BookSection all={true}/>
            {/*<span>{books}</span>// вызывать BookSection all="true/false"*/}
        </div>
        );
    };



};