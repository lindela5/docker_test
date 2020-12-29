import React from "react";
import Navbar from "./Navbar";
import axios from "axios";
import {Book} from "./Book";
import Sections from "./Sections";
import BookSection from "./BookSection";

export class Main extends React.Component {



     render = () => {

        return (<div>
            {/*<Navbar/>*/}
            {/*<Sections/>*/}
            <BookSection all={true}/>
            {/*<span>{books}</span>// вызывать BookSection all="true/false"*/}
        </div>
        );
    };



};