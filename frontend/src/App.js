import logo from './logo.svg';
import React from "react";
import './App.css';
import Books from "./component/Books.jsx";
import {Route} from "react-router-dom";
import {Main} from "./component/Main";
import BookSection from "./component/BookSection";
import Footer from "./component/Footer";
import Navbar from "./component/Navbar";
// import Footer from "./Footer";
import Sections from "./component/Sections";



function App() {
        // return (
        //   <div className="App">
        //     <header className="App-header">
        //       <img src={logo} className="App-logo" alt="logo" />
        //       <p>
        //         Edit <code>src/App.js</code> and save to reload.
        //       </p>
        //       <a
        //         className="App-link"
        //         href="https://reactjs.org"
        //         target="_blank"
        //         rel="noopener noreferrer"
        //       >
        //         Learn React
        //       </a>
        //     </header>
        //   </div>
        // );
        return (<div>
                    <Navbar/>
                    <Sections/>
                    <BookSection all={true}/>
                    {/*<span>{books}</span>// вызывать BookSection all="true/false"*/}
                    <Footer/>
            </div>
        );
}

export default App;